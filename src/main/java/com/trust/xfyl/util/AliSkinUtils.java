package com.trust.xfyl.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.UUID;

public class AliSkinUtils {
    private static final Logger logger = LoggerFactory.getLogger(AliSkinUtils.class);

    // HTTPMethod推荐使用POST
    static final String API_HTTP_METHOD = "POST";

    // API访问域名，与类目相关，具体类目的API访问域名请参考：https://help.aliyun.com/document_detail/143103.html
    static final String API_ENDPOINT = "imageprocess.cn-shanghai.aliyuncs.com";

    // API版本，与类目相关，具体类目的API版本请参考：https://help.aliyun.com/document_detail/464194.html
    static final String API_VERSION = "2020-03-20";

    public static final java.text.SimpleDateFormat DF = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

    private static HttpClient httpClient;

    static {
        // 创建连接池
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        // 增加最大总连接数
        cm.setMaxTotal(100);
        // 增加每个路由的默认最大连接数
        cm.setDefaultMaxPerRoute(20);
        try {
            httpClient = HttpClients.custom().setConnectionManager(cm).build();
            // 设置连接空闲验证时间
            cm.setValidateAfterInactivity(5000);
        } catch (Exception e) {
            logger.error("HttpClient initialization failed", e);
        }
    }

    /**
     * @return org.json.JSONObject
     * @Author djj
     * @Description 根据接口要求传过去 accessKeyId，accessSecret，Map里面放的是经过处理的image的url，来获取皮肤的检测信息
     * @Date 9:32 2024/1/29
     * @Param [action, accessKeyId, accessSecret, bizParams]
     **/
    public static JSONObject execute(String action, String accessKeyId, String accessSecret, Map<String, String> bizParams) throws Exception {
        java.util.Map<String, String> params = new java.util.HashMap<>();
        // 系统参数
        params.put("SignatureMethod", "HMAC-SHA1");
        // 防止重放攻击
        params.put("SignatureNonce", UUID.randomUUID().toString());
        params.put("AccessKeyId", accessKeyId);
        params.put("SignatureVersion", "1.0");
        // 更新时间戳
        params.put("Timestamp", DF.format(new java.util.Date()));
        params.put("Format", "JSON");
        // 业务API参数
        params.put("RegionId", "cn-shanghai");
        params.put("Version", API_VERSION);
        params.put("Action", action);
        params.put("OrgId", "");
        params.put("OrgName", "");
        if (bizParams != null && !bizParams.isEmpty()) {
            params.putAll(bizParams);
        }
        // 去除签名关键字Key
        params.remove("Signature");
        // 参数KEY排序
        java.util.TreeMap<String, String> sortParams = new java.util.TreeMap<>();
        sortParams.putAll(params);
        // 构造待签名的字符串
        StringBuilder sortQueryStringTmp = new StringBuilder();
        for (String key : sortParams.keySet()) {
            sortQueryStringTmp.append("&").append(specialUrlEncode(key)).append("=").append(specialUrlEncode(params.get(key)));
        }
        String sortedQueryString = sortQueryStringTmp.substring(1);
        StringBuilder stringToSign = new StringBuilder();
        stringToSign.append(API_HTTP_METHOD).append("&");
        stringToSign.append(specialUrlEncode("/")).append("&");
        stringToSign.append(specialUrlEncode(sortedQueryString));
        String sign = sign(accessSecret + "&", stringToSign.toString());
        // 签名最后也要做特殊URL编码
        String signature = specialUrlEncode(sign);

        // 最终生成出合法请求的URL
        String url = "http://" + API_ENDPOINT + "/?Signature=" + signature + sortedQueryString;

        return parseResponse(post(url));
    }

    private static JSONObject parseResponse(String response) throws Exception {
        JSONObject jsonObject = new JSONObject(response);
        logger.info("皮肤检测的结果集: " + jsonObject.toString());
        return jsonObject;
    }

    private static String post(String url) throws Exception {
        HttpPost request = new HttpPost(url);
        HttpResponse response = httpClient.execute(request);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            try (InputStream inputStream = entity.getContent()) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder result = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
                return result.toString();
            } catch (IOException e) {
                throw new Exception("处理实体内容时出现IOException", e);
            }
        } else {
            throw new Exception("实体为null");
        }
    }

    /**
     * @return java.lang.String
     * @Author djj
     * @Description 签名最后做特殊URL编码
     * @Date 9:40 2024/1/29
     * @Param [value]
     **/
    public static String specialUrlEncode(String value) throws Exception {
        return java.net.URLEncoder.encode(value, "UTF-8")
                .replace("+", "%20")
                .replace("*", "%2A")
                .replace("%7E", "~");
    }

    /**
     * @return java.lang.String
     * @Author djj
     * @Description 签名
     * @Date 9:41 2024/1/29
     * @Param [accessSecret, stringToSign]
     **/
    public static String sign(String accessSecret, String stringToSign) throws Exception {
        javax.crypto.Mac mac = javax.crypto.Mac.getInstance("HmacSHA1");
        mac.init(new javax.crypto.spec.SecretKeySpec(accessSecret.getBytes(StandardCharsets.UTF_8), "HmacSHA1"));
        byte[] signData = mac.doFinal(stringToSign.getBytes(StandardCharsets.UTF_8));
        return new sun.misc.BASE64Encoder().encode(signData);
    }
}
