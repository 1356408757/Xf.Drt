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

    public static ResultVO uploadFiles(List<MultipartFile> files){
        String endpoint = "https://oss-cn-shanghai.aliyuncs.com";
        if (ossAccessKeyId == null || ossAccessKeySecret == null || ossSecurityToken == null) {
            logger.error("文件上传失败。STS 令牌无效。");
            return ResultVOUtil.error("STS 令牌无效。");
        }

        List<Map<String, Object>> resultList;
        OSS ossClient = new OSSClientBuilder().build(endpoint, ossAccessKeyId, ossAccessKeySecret, ossSecurityToken);
        ExecutorService executorService;
        executorService = new ThreadPoolExecutor(
                10, 10, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                new CustomThreadFactory()
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

    /**
     * 上传文件到OSS（阿里云对象存储服务）并返回文件信息的映射。
     *
     * @param file 需要上传的多部分文件对象，不可为null。
     * @param ossClient 用于与OSS交互的客户端对象，不可为null。
     * @return 一个包含文件名、文件URL（如果上传成功）和原始文件名的映射对象。如果上传失败，返回一个包含错误信息的映射。
     */
    private static Map<String, Object> uploadFile(MultipartFile file, OSS ossClient) {
        try {
            // 图片压缩
            File compressedFile = compressImage(file);

            // 生成唯一的文件名
            String uniqueFileName = generateUniqueFileName(Objects.requireNonNull(file.getOriginalFilename()));

            // 生成签名URL并将压缩后的文件上传到OSS
            URL signedUrl = generateAndUploadObject(ossClient, compressedFile, uniqueFileName);

            // 准备文件信息的映射
            Map<String, Object> fileMap = new HashMap<>();
            fileMap.put("fileName", file.getOriginalFilename());
            if (signedUrl != null) {
                fileMap.put("fileUrl", signedUrl.toString());
            }
            fileMap.put("originalFilename", uniqueFileName);

            return fileMap;
        } catch (Exception e) {
            // 记录文件上传失败的错误日志
            logger.error("文件上传失败。异常信息: {}", e.getMessage());
            // 返回包含错误信息的映射
            return createErrorResultMap(e.getMessage());
        }
    }
   /* private static boolean skinDetection(MultipartFile file) {
        try {
            // 将 MultipartFile 转换为临时文件
            File tempFile = convertMultipartFileToFile(file);
            boolean b = SkinDetection.skinDetection(tempFile.getAbsolutePath());
            // 调用皮肤检测方法
           return b;
        } catch (IOException e) {
            logger.error("皮肤检测失败。异常信息: {}", e.getMessage());
            return false;
        }
    }*/

    /**
     * 将MultipartFile转换为File类型。
     *
     * @param file MultipartFile对象，代表上传的文件。
     * @return 转换后的File对象，该文件存储在系统的临时目录中。
     * @throws IOException 如果在文件转换或存储过程中发生IO错误。
     */
    private static File convertMultipartFileToFile(MultipartFile file) throws IOException {
        // 创建一个临时文件用于存储上传的文件内容
        File tempFile = File.createTempFile("temp", null);
        // 将上传文件的内容转移到临时文件中
        file.transferTo(tempFile);
        return tempFile;
    }
    /**
     * 创建一个包含错误信息的Map对象。
     *
     * @param errorMessage 错误信息字符串，用于在Map中存储的错误消息。
     * @return 返回一个包含"error"键和对应错误消息值的Map对象。
     */
    private static Map<String, Object> createErrorResultMap(String errorMessage) {
        // 初始化一个空的HashMap用于存储错误信息
        Map<String, Object> errorResult = new HashMap<>();
        // 将错误消息放入Map中，键为"error"
        errorResult.put("error", errorMessage);
        return errorResult;
    }

    /**
     * 生成并上传对象到OSS（阿里云对象存储服务）。
     *
     * @param ossClient OSS客户端，用于与OSS进行交互。
     * @param file 要上传的文件。
     * @param uniqueFileName 上传至OSS的文件名，需要保证唯一性。
     * @return 返回上传文件的预签名URL，如果上传失败则返回null。
     */
    private static URL generateAndUploadObject(OSS ossClient, File file, String uniqueFileName) {
        try {
            // 创建一个预签名URL请求，用于PUT方法上传文件。
            GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest("drt-oss-disk", "src/image/" + uniqueFileName, HttpMethod.PUT);
            // 设置预签名URL的过期时间。
            Date expiration = new Date(System.currentTimeMillis() + 3600 * 1000L);
            request.setExpiration(expiration);
            // 设置请求的内容类型。
            request.setContentType("multipart/form-data");
            // 添加自定义元数据。
            request.addUserMetadata("author", "xfdf");
            // 生成预签名URL。
            URL signedUrl = ossClient.generatePresignedUrl(request);

            // 准备上传时的请求头，包含内容类型和作者信息。
            Map<String, String> requestHeaders = new HashMap<>();
            requestHeaders.put(HttpHeaders.CONTENT_TYPE, "multipart/form-data");
            requestHeaders.put(OSS_USER_METADATA_PREFIX + "author", "xfdf");

            // 使用预签名URL上传文件。
            ossClient.putObject(signedUrl, new BufferedInputStream(new FileInputStream(file)), file.length(), requestHeaders, true);

            // 创建一个预签名URL请求，用于GET方法下载文件。
            GeneratePresignedUrlRequest getUrlRequest = new GeneratePresignedUrlRequest("drt-oss-disk", "src/image/" + uniqueFileName, HttpMethod.GET);
            // 设置下载URL的过期时间。
            getUrlRequest.setExpiration(expiration);
            // 生成并返回文件的预签名下载URL。
            return ossClient.generatePresignedUrl(getUrlRequest);
        } catch (Exception e) {
            // 记录生成和上传对象失败的错误日志。
            logger.error("生成并上传对象失败。异常信息: {}", e.getMessage());
            return null;
        }
    }


    /**
     * 关闭ExecutorService和OSS客户端。
     * 该方法负责安全地关闭提供的ExecutorService和OSS客户端实例，确保资源得到释放。
     *
     * @param executorService ExecutorService实例，如果为null，则不进行关闭操作。
     * @param ossClient OSS客户端实例，如果为null，则不进行关闭操作。
     */
    private static void shutdownExecutorAndOssClient(ExecutorService executorService, OSS ossClient) {
        // 关闭OSS客户端，如果存在的话
        if (ossClient != null) {
            ossClient.shutdown();
        }
        // 关闭ExecutorService，如果存在的话
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    /**
     * 判断上传的文件是否为图片文件。
     *
     * @param file 上传的文件对象，类型为 MultipartFile。
     * @return 返回一个布尔值，如果文件类型以"image"开头，则返回 true，表示是图片文件；否则返回 false。
     */
    private static boolean isImageFile(MultipartFile file) {
        // 获取上传文件的 content type
        String contentType = file.getContentType();
        // 判断 content type 是否非空且以"image"开头
        return contentType != null && contentType.startsWith("image");
    }

    /**
     * 压缩上传的图片文件。
     *
     * @param file 上传的图片文件，类型为MultipartFile。
     * @return 压缩后的图片文件，如果压缩失败则返回原文件。
     * @throws IOException 如果读取或写入文件发生错误。
     */
    private static File compressImage(MultipartFile file) {
        try {
            // 从文件输入流中读取图片
            BufferedImage image = ImageIO.read(file.getInputStream());

            // 设置压缩后的图片宽度为800像素，根据原图宽高比计算高度
            int newWidth = 800;
            int newHeight = (int) (image.getHeight() * ((double) newWidth / image.getWidth()));

            // 创建一个新的缓冲区图像，用于存放调整大小后的图像
            BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = resizedImage.createGraphics();
            // 设置图像拉伸质量
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            // 在新尺寸上绘制原图
            g.drawImage(image, 0, 0, newWidth, newHeight, null);
            g.dispose(); // 释放Graphics2D资源

            // 创建一个临时文件，用于存放压缩后的图像
            File compressedFile = File.createTempFile("compressed", ".jpg");
            // 将调整大小后的图像以JPEG格式写入文件
            ImageIO.write(resizedImage, "jpg", compressedFile);

            return compressedFile;
        } catch (IOException e) {
            // 如果处理图片过程中发生错误，返回原文件
            return new File(Objects.requireNonNull(file.getOriginalFilename()));
        }
    }


    /**
     * 生成唯一的文件名
     *
     * @param originalFileName 原始文件名，用于获取文件扩展名
     * @return 由时间戳、UUID和原始文件扩展名组成的唯一文件名
     */
    public static String generateUniqueFileName(String originalFileName) {
        // 创建日期格式化对象，用于生成时间戳字符串
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm-ssSSS");
        // 获取当前日期时间的时间戳字符串
        String timestamp = sdf.format(new Date());
        // 生成UUID并移除其中的"-"
        String uuid = UUID.randomUUID().toString().replace("-", "");
        // 从原始文件名中提取文件扩展名
        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        // 拼接时间戳、UUID和文件扩展名，形成新的唯一文件名
        return timestamp + "-" + uuid + fileExtension;
    }


    /**
     * 初始化方法，该方法在对象创建后，其依赖注入完成时被调用。
     * 本方法主要完成以下两项任务：
     * 1. 创建STS（Security Token Service）客户端。
     * 2. 刷新STS令牌。
     *
     * @throws Exception 如果在创建客户端或刷新令牌时发生错误，则抛出异常。
     */
    @PostConstruct
    public void init() throws Exception {
        // 创建STS客户端
        stsClient = createClient();
        // 刷新STS令牌
        refreshStsToken();
    }

    /**
     * 定时刷新STS Token。
     * 该方法使用异步执行，每隔3500秒执行一次。首次执行延迟为0秒。
     * 无参数和返回值。
     *
     * 使用阿里云STS（Security Token Service）服务获取临时访问凭证。
     * 凭证包括访问密钥ID（AccessKeyId）、访问密钥秘钥（AccessKeySecret）和安全令牌（SecurityToken）。
     * 刷新成功后，将更新的STS凭证信息记录到相应的字段中。
     */
    @Scheduled(initialDelay = 0, fixedDelay = 3500000L)
    @Async
    public void refreshStsToken() {
        try {
            // 构建获取STS Token的请求
            AssumeRoleRequest assumeRoleRequest = new AssumeRoleRequest()
                    .setDurationSeconds(3600L) // 设置令牌有效期为3600秒
                    .setPolicy(policy) // 设置权限策略
                    .setRoleArn(roleArn) // 设置角色ARN
                    .setRoleSessionName("SessionTest") // 设置角色会话名称
                    .setExternalId(externalId); // 设置外部ID

            // 创建运行时选项
            RuntimeOptions runtime = new RuntimeOptions();

            // 发起STS Token的刷新请求，并处理响应
            AssumeRoleResponse assumeRoleResponse = stsClient.assumeRoleWithOptions(assumeRoleRequest, runtime);

            // 更新STS凭证信息
            ossAccessKeyId = assumeRoleResponse.getBody().getCredentials().getAccessKeyId();
            ossAccessKeySecret = assumeRoleResponse.getBody().getCredentials().getAccessKeySecret();
            ossSecurityToken = assumeRoleResponse.getBody().getCredentials().getSecurityToken();

            // 记录刷新成功日志
            logger.info("Successfully refreshed STS token: {}", assumeRoleResponse);
        } catch (Exception e) {
            // 记录刷新失败日志
            logger.error("Failed to refresh STS token: {}", e.getMessage());
        }
    }


    /**
     * 创建并返回一个阿里云 STS 客户端实例。
     * 该方法不接受任何参数，但需要在类级别上访问 accessKeyId 和 keySecret。
     *
     * @return Client 阿里云 STS 客户端实例
     * @throws Exception 如果在创建客户端时遇到任何问题，则抛出异常
     */
    private Client createClient() throws Exception {
        // 设置STS服务的访问端点
        String endpoint = "sts.cn-shanghai.aliyuncs.com";
        // 配置STS客户端，包括访问密钥ID、密钥和端点
        Config config = new Config().setAccessKeyId(accessKeyId).setAccessKeySecret(keySecret).setEndpoint(endpoint);
        // 根据配置创建并返回STS客户端实例
        return new Client(config);
    }


    /**
     * TODO  下面的方法为阿里oss对象存储的上传下载针对于测试类里面的方法，我就不删除了
     *
     * @Description
     * @Author Bay-max
     * @Date 2024/3/1 12:07
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

