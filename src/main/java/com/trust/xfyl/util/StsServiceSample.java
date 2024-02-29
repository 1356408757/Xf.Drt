package com.trust.xfyl.util;

import com.aliyun.oss.*;
import com.aliyun.oss.common.utils.HttpHeaders;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import com.aliyun.sts20150401.Client;
import com.aliyun.sts20150401.models.AssumeRoleRequest;
import com.aliyun.sts20150401.models.AssumeRoleResponse;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.teautil.models.RuntimeOptions;
import com.trust.xfyl.entity.ResultVO;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import static com.aliyun.oss.internal.OSSHeaders.OSS_USER_METADATA_PREFIX;

/**
 * @Author djj
 * @Description //TODO 阿里云 sts-临时访问凭证生成 以及上传文件；
 * @Date 14:14 2024/2/23
 **/
@Component
public class StsServiceSample {

    private static final Logger logger = LoggerFactory.getLogger(StsServiceSample.class);
    private static String ossAccessKeyId;
    private static String ossAccessKeySecret;
    private static String ossSecurityToken;
    String accessKeyId = System.getenv("ALIBABA_CLOUD_ACCESS_KEY_ID");
    String keySecret = System.getenv("ALIBABA_CLOUD_ACCESS_KEY_SECRET");
    @Value("${aliyun.api.roleArn}")
    private String roleArn;
    @Value("${aliyun.api.policy}")
    private String policy;
    @Value("${aliyun.api.externalId}")
    private String externalId;
    private Client stsClient;
    /**
    * @Author djj
    * @Description //TODO 阿里云上传到oss返回可以对接皮肤检测的method;
    * @Date 14:06 2024/2/28
    * @Param [files]
    * @return com.trust.xfyl.entity.ResultVO
    **/

    public static ResultVO uploadFiles(List<MultipartFile> files) throws IOException {
        String endpoint = "https://oss-cn-shanghai.aliyuncs.com";
        if (ossAccessKeyId == null || ossAccessKeySecret == null || ossSecurityToken == null) {
            logger.error("文件上传失败。STS 令牌无效。");
            return ResultVOUtil.error("STS 令牌无效。");
        }

        List<Map<String, Object>> resultList;
        OSS ossClient = new OSSClientBuilder().build(endpoint, ossAccessKeyId, ossAccessKeySecret, ossSecurityToken);
        ExecutorService executorService = new ThreadPoolExecutor(
                10, 10, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>()
        );

        try {
            List<CompletableFuture<Map<String, Object>>> futures = files.stream()
                    .filter(file -> !file.isEmpty() && isImageFile(file))
                    .map(file -> CompletableFuture.supplyAsync(() -> uploadFile(file, ossClient), executorService))
                    .collect(Collectors.toList());

            resultList = futures.stream()
                    .map(CompletableFuture::join)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());

            return ResultVOUtil.success(resultList);
        } catch (OSSException oe) {
            logger.error("文件上传失败。OSS 异常 - 错误消息: {}, 错误码: {}, 请求 ID: {}, 主机 ID: {}",
                    oe.getErrorMessage(), oe.getErrorCode(), oe.getRequestId(), oe.getHostId());
            return ResultVOUtil.error("文件上传失败。OSS 异常");
        } finally {
            shutdownExecutorAndOssClient(executorService, ossClient);
        }
    }

    private static Map<String, Object> uploadFile(MultipartFile file, OSS ossClient) {
        try {
            File compressedFile = compressImage(file);

            String uniqueFileName = generateUniqueFileName(file.getOriginalFilename());

            URL signedUrl = generateAndUploadObject(ossClient, compressedFile, uniqueFileName);

            Map<String, Object> fileMap = new HashMap<>();
            fileMap.put("fileName", file.getOriginalFilename());
            fileMap.put("fileUrl", signedUrl.toString());
            fileMap.put("originalFilename", uniqueFileName);

            return fileMap;
        } catch (Exception e) {
            logger.error("文件上传失败。异常信息: {}", e.getMessage());
            return createErrorResultMap(e.getMessage());
        }
    }

    private static Map<String, Object> createErrorResultMap(String errorMessage) {
        Map<String, Object> errorResult = new HashMap<>();
        errorResult.put("error", errorMessage);
        return errorResult;
    }

    private static URL generateAndUploadObject(OSS ossClient, File file, String uniqueFileName) {
        try {
            GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest("drt-oss-disk", "src/image/" + uniqueFileName, HttpMethod.PUT);
            Date expiration = new Date(System.currentTimeMillis() + 3600 * 1000L);
            request.setExpiration(expiration);
            request.setContentType("multipart/form-data");
            request.addUserMetadata("author", "xfdrt");
            URL signedUrl = ossClient.generatePresignedUrl(request);

            Map<String, String> requestHeaders = new HashMap<>();
            requestHeaders.put(HttpHeaders.CONTENT_TYPE, "multipart/form-data");
            requestHeaders.put(OSS_USER_METADATA_PREFIX + "author", "xfdrt");

            ossClient.putObject(signedUrl, new BufferedInputStream(new FileInputStream(file)), file.length(), requestHeaders, true);

            GeneratePresignedUrlRequest getUrlRequest = new GeneratePresignedUrlRequest("drt-oss-disk", "src/image/" + uniqueFileName, HttpMethod.GET);
            getUrlRequest.setExpiration(expiration);
            return ossClient.generatePresignedUrl(getUrlRequest);
        } catch (Exception e) {
            logger.error("生成并上传对象失败。异常信息: {}", e.getMessage());
            return null;
        }
    }

    private static void shutdownExecutorAndOssClient(ExecutorService executorService, OSS ossClient) {
        if (ossClient != null) {
            ossClient.shutdown();
        }
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    private static boolean isImageFile(MultipartFile file) {
        String contentType = file.getContentType();
        return contentType != null && contentType.startsWith("image");
    }

    private static File compressImage(MultipartFile file) {
        try {
            BufferedImage image = ImageIO.read(file.getInputStream());

            int newWidth = 800;
            int newHeight = (int) (image.getHeight() * ((double) newWidth / image.getWidth()));

            BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = resizedImage.createGraphics();
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.drawImage(image, 0, 0, newWidth, newHeight, null);
            g.dispose();

            File compressedFile = File.createTempFile("compressed", ".jpg");
            ImageIO.write(resizedImage, "jpg", compressedFile);

            return compressedFile;
        } catch (IOException e) {
            return new File(file.getOriginalFilename());
        }
    }

    public static String generateUniqueFileName(String originalFileName) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm-ssSSS");
        String timestamp = sdf.format(new Date());
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        return timestamp + "-" + uuid + fileExtension;
    }


    @PostConstruct
    public void init() throws Exception {
        stsClient = createClient();
        refreshStsToken();
    }

    @Scheduled(initialDelay = 0, fixedDelay = 3500000L)
    @Async
    public void refreshStsToken() {
        try {
            AssumeRoleRequest assumeRoleRequest = new AssumeRoleRequest()
                    .setDurationSeconds(3600L)
                    .setPolicy(policy)
                    .setRoleArn(roleArn)
                    .setRoleSessionName("SessionTest")
                    .setExternalId(externalId);
            RuntimeOptions runtime = new RuntimeOptions();
            AssumeRoleResponse assumeRoleResponse = stsClient.assumeRoleWithOptions(assumeRoleRequest, runtime);
            ossAccessKeyId = assumeRoleResponse.getBody().getCredentials().getAccessKeyId();
            ossAccessKeySecret = assumeRoleResponse.getBody().getCredentials().getAccessKeySecret();
            ossSecurityToken = assumeRoleResponse.getBody().getCredentials().getSecurityToken();
            logger.info("Successfully refreshed STS token: {}", assumeRoleResponse);
        } catch (Exception e) {
            logger.error("Failed to refresh STS token: {}", e.getMessage());
        }
    }

    private Client createClient() throws Exception {
        String endpoint = "sts.cn-shanghai.aliyuncs.com";
        Config config = new Config().setAccessKeyId(accessKeyId).setAccessKeySecret(keySecret).setEndpoint(endpoint);
        return new Client(config);
    }

    /**
     * @return void
     * @Author djj
     * @Description //TODO 下面的方法为阿里oss对象存储的上传下载针对于测试类里面的方法，我就不删除了
     * @Date 14:05 2024/2/28
     **/

    public static void ossTest() throws Throwable {
        // 以华东1（杭州）的外网Endpoint为例，其它Region请按实际情况填写。
        String endpoint = "https://oss-cn-shanghai.aliyuncs.com";
        // 填写Bucket名称，例如examplebucket。
        String bucketName = "drt-oss-disk";
        // 填写Object完整路径，例如exampleobject.txt。Object完整路径中不能包含Bucket名称。
        String objectName = "src/image/";
        // 填写本地文件的完整路径。如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件。
        String pathName = "D:\\home\\app\\uploadImg\\13af9fa6-48c5-4540-971f-71780785868f.png";

        // 创建OSSClient实例
        OSS ossClient = new OSSClientBuilder().build(endpoint, ossAccessKeyId, ossAccessKeySecret, ossSecurityToken);

        // 设置请求头。
        Map<String, String> headers = new HashMap<String, String>();
      /*  // 指定Object的存储类型。
        headers.put(OSSHeaders.STORAGE_CLASS, StorageClass.Standard.toString());
        // 指定ContentType。
        headers.put(OSSHeaders.CONTENT_TYPE, "image/png");*/

        // 设置用户自定义元数据。
        Map<String, String> userMetadata = new HashMap<String, String>();
        /*userMetadata.put("key1","value1");
        userMetadata.put("key2","value2");*/

        URL signedUrl = null;
        try {
            long currentTime = System.currentTimeMillis();
            Date expiration = new Date(currentTime + 3600 * 1000L);

            // 生成签名URL。
            GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucketName, objectName, HttpMethod.PUT);
            // 设置过期时间。
            request.setExpiration(expiration);

            // 将请求头加入到request中。
            request.setHeaders(headers);
            // 添加用户自定义元数据。
            request.setUserMetadata(userMetadata);

            // 通过HTTP PUT请求生成签名URL。
            signedUrl = ossClient.generatePresignedUrl(request);
            // 打印签名URL。
            System.out.println("signed url for putObject==========: " + signedUrl);

        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        }

        // 通过签名URL临时授权简单上传文件，以HttpClients为例说明。
        putObjectWithHttp(signedUrl, pathName, headers, userMetadata);
    }

    public static void putObjectWithHttp(URL signedUrl, String pathName, Map<String, String> headers, Map<String, String> userMetadata) throws IOException {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            HttpPut put = new HttpPut(signedUrl.toString());
            HttpEntity entity = new FileEntity(new File(pathName));
            put.setEntity(entity);
            // 如果生成签名URL时设置了header参数，例如用户元数据，存储类型等，则调用签名URL上传文件时，也需要将这些参数发送至服务端。如果签名和发送至服务端的不一致，会报签名错误。
            for (Map.Entry header : headers.entrySet()) {
                put.addHeader(header.getKey().toString(), header.getValue().toString());
            }
            for (Map.Entry meta : userMetadata.entrySet()) {
                // 如果使用userMeta，sdk内部会为userMeta拼接"x-oss-meta-"前缀。当您使用其他方式生成签名URL进行上传时，userMeta也需要拼接"x-oss-meta-"前缀。
                put.addHeader("x-oss-meta-" + meta.getKey().toString(), meta.getValue().toString());
            }

            httpClient = HttpClients.createDefault();

            response = httpClient.execute(put);

            System.out.println("返回上传状态码：" + response.getStatusLine().getStatusCode());
            if (response.getStatusLine().getStatusCode() == 200) {
                System.out.println("使用网络库上传成功");
                System.out.println();
            }
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            response.close();
            httpClient.close();
        }
    }

    public static void download() throws Throwable {
        // 以华东1（杭州）的外网Endpoint为例，其它Region请按实际情况填写。
        String endpoint = "https://oss-cn-shanghai.aliyuncs.com";
        // 填写Bucket名称，例如examplebucket。
        String bucketName = "drt-oss-disk";
        // 填写Object完整路径，例如exampleobject.txt。Object完整路径中不能包含Bucket名称。
        String objectName = "src/image/202402271205-40589-d1f905a37fe14322a695e0210811fbdf.jpg";
        // 填写本地文件的完整路径。如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件。
        String pathName = "D:\\home\\app\\uploadImg\\";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, ossAccessKeyId, ossAccessKeySecret, ossSecurityToken);

        // 设置请求头。
        Map<String, String> headers = new HashMap<String, String>();
        /*// 指定Object的存储类型。
        headers.put(OSSHeaders.STORAGE_CLASS, StorageClass.Standard.toString());
        // 指定ContentType。
        headers.put(OSSHeaders.CONTENT_TYPE, "text/txt");*/

        // 设置用户自定义元数据。
        Map<String, String> userMetadata = new HashMap<String, String>();
        /*userMetadata.put("key1","value1");
        userMetadata.put("key2","value2");*/

        URL signedUrl = null;
        try {
            // 指定生成的签名URL过期时间，单位为毫秒。本示例以设置过期时间为1小时为例。
            long currentTime = System.currentTimeMillis();
            Date expiration = new Date(currentTime+ 3600 * 1000L);

            // 生成签名URL。
            GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucketName, objectName, HttpMethod.GET);
            // 设置过期时间。
            request.setExpiration(expiration);

            // 将请求头加入到request中。
            request.setHeaders(headers);
            // 添加用户自定义元数据。
            request.setUserMetadata(userMetadata);

            // 设置查询参数。
            // Map<String, String> queryParam = new HashMap<String, String>();
            // 指定IP地址或者IP地址段，对应日志中sourceIpFromSource的值。
            // queryParam.put("x-oss-ac-source-ip","192.0.2.0");
            // 将子网掩码转换为二进制，然后填写转换结果中1的数量。
            // queryParam.put("x-oss-ac-subnet-mask","32");
            // 指定VPC ID。
            // queryParam.put("x-oss-ac-vpc-id","vpc-12345678");
            // 指定是否允许转发请求。
            // queryParam.put("x-oss-ac-forward-allow","true");
            // request.setQueryParameter(queryParam);

            // 设置单链接限速，单位为bit，例如限速100 KB/s。
            // request.setTrafficLimit(100 * 1024 * 8);

            // 通过HTTP GET请求生成签名URL。
            signedUrl = ossClient.generatePresignedUrl(request);
            // 打印签名URL。
            System.out.println("signed url for putObject: " + signedUrl);
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        }

        // 通过签名URL下载文件，以HttpClients为例说明。
        getObjectWithHttp(signedUrl, pathName, headers, userMetadata);
    }

    public static void getObjectWithHttp(URL signedUrl, String pathName, Map<String, String> headers, Map<String, String> userMetadata) throws IOException {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            HttpGet get = new HttpGet(signedUrl.toString());

            // 如果生成签名URL时设置了header参数，例如用户元数据，存储类型等，则调用签名URL下载文件时，也需要将这些参数发送至服务端。如果签名和发送至服务端的不一致，会报签名错误。
            for (Map.Entry header : headers.entrySet()) {
                get.addHeader(header.getKey().toString(), header.getValue().toString());
            }
            for (Map.Entry meta : userMetadata.entrySet()) {
                // 如果使用userMeta，sdk内部会为userMeta拼接"x-oss-meta-"前缀。当您使用其他方式生成签名URL进行下载时，userMeta也需要拼接"x-oss-meta-"前缀。
                get.addHeader("x-oss-meta-" + meta.getKey().toString(), meta.getValue().toString());
            }

            httpClient = HttpClients.createDefault();
            response = httpClient.execute(get);

            System.out.println("返回下载状态码：" + response.getStatusLine().getStatusCode());
            if (response.getStatusLine().getStatusCode() == 200) {
                System.out.println("使用网络库下载成功");
            }
            System.out.println(response);

            // 保存文件到磁盘。
            saveFileToLocally(response.getEntity().getContent(), pathName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            response.close();
            httpClient.close();
        }
    }

    public static void saveFileToLocally(InputStream inputStream, String pathName) throws IOException {
        DataInputStream in = null;
        OutputStream out = null;
        try {
            in = new DataInputStream(inputStream);
            out = new DataOutputStream(new FileOutputStream(pathName));
            int bytes = 0;
            byte[] bufferOut = new byte[1024];
            while ((bytes = in.read(bufferOut)) != -1) {
                out.write(bufferOut, 0, bytes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            in.close();
            out.close();
        }
    }
}

