package com.trust.xfyl.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Map;
/**
 * @author Bay-max
 * @date 2024/4/22 15:39
 **/
public class AliSkinUtils {
    // HTTPMethod推荐使用POST

    public static final java.text.SimpleDateFormat DF = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

    // API访问域名，与类目相关，具体类目的API访问域名请参考：https://help.aliyun.com/document_detail/143103.html
    static final String API_HTTP_METHOD = "POST";

    // API版本，与类目相关，具体类目的API版本请参考：https://help.aliyun.com/document_detail/464194.html
    static final String API_ENDPOINT = "imageprocess.cn-shanghai.aliyuncs.com";
    static final String API_VERSION = "2020-03-20";

    /**
     * @return org.json.JSONObject
     * @Author djj
     * @Description //根据接口要求传过去  accessKeyId，accessSecret ，Map里面放的是经过处理的image的url，来获取皮肤的检测信息
     * @Date 9:32 2024/1/29
     * @Param [action, accessKeyId, accessSecret, bizParams]
     **/
    public static JSONObject execute(String action, String accessKeyId, String accessSecret, Map<String, String> bizParams) throws Exception {
        java.util.Map<String, String> params = new java.util.HashMap<String, String>();
        // 1. 系统参数
        params.put("SignatureMethod", "HMAC-SHA1");
        //防止重放攻击
        params.put("SignatureNonce", java.util.UUID.randomUUID().toString());
        params.put("AccessKeyId", accessKeyId);
        params.put("SignatureVersion", "1.0");
        // 更新时间戳
        params.put("Timestamp", DF.format(new java.util.Date()));
        params.put("Format", "JSON");
        // 2. 业务API参数
        params.put("RegionId", "cn-shanghai");
        params.put("Version", API_VERSION);
        params.put("Action", action);
        params.put("OrgId", "");
        params.put("OrgName", "");
        if (bizParams != null && !bizParams.isEmpty()) {
            params.putAll(bizParams);
        }
        // 3. 去除签名关键字Key
        params.remove("Signature");
        // 4. 参数KEY排序
        java.util.TreeMap<String, String> sortParams = new java.util.TreeMap<String, String>();
        sortParams.putAll(params);
        // 5. 构造待签名的字符串
        java.util.Iterator<String> it = sortParams.keySet().iterator();
        StringBuilder sortQueryStringTmp = new StringBuilder();
        while (it.hasNext()) {
            String key = it.next();
            sortQueryStringTmp.append("&").append(specialUrlEncode(key)).append("=").append(specialUrlEncode(params.get(key)));
        }
        // 去除第一个多余的&符号
        String sortedQueryString = sortQueryStringTmp.substring(1);
        StringBuilder stringToSign = new StringBuilder();
        stringToSign.append(API_HTTP_METHOD).append("&");
        stringToSign.append(specialUrlEncode("/")).append("&");
        stringToSign.append(specialUrlEncode(sortedQueryString));
        String sign = sign(accessSecret + "&", stringToSign.toString());
        // 6. 签名最后也要做特殊URL编码
        String signature = specialUrlEncode(sign);
        System.out.println(params.get("SignatureNonce"));
        System.out.println("\r\n=========\r\n");
        System.out.println(params.get("Timestamp"));
        System.out.println("\r\n=========\r\n");
        System.out.println(sortedQueryString);
        System.out.println("\r\n=========\r\n");
        System.out.println(stringToSign);
        System.out.println("\r\n=========\r\n");
        System.out.println(sign);
        System.out.println("\r\n=========\r\n");
        System.out.println(signature);
        System.out.println("\r\n=========\r\n");
        // 最终生成出合法请求的URL
        System.out.println("http://" + API_ENDPOINT + "/?Signature=" + signature + sortQueryStringTmp);

        // 添加直接做post请求的方法
        try {
            // 使用生成的 URL 创建POST请求
            URIBuilder builder = new URIBuilder("http://" + API_ENDPOINT + "/?Signature=" + signature + sortQueryStringTmp);
            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            HttpClient httpclient = HttpClients.createDefault();
            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                try (InputStream inputStream = entity.getContent()) {
                    // 使用BufferedReader读取InputStream的内容
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder result = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }
                    // 将读取到的内容解析为JSON对象
                    System.out.println("皮肤检测的结果集" + result);
                    JSONObject jsonObject = new JSONObject(result.toString());
                    return jsonObject;
                } catch (IOException e) {
                    // 处理IOException，根据需要抛出异常或者进行其他处理
                    throw new Exception("处理实体内容时出现IOException", e);
                }
            } else {
                // 处理实体为null的情况，根据需要抛出异常或者返回null
                throw new Exception("实体为null");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * @return java.lang.String
     * @Author djj
     * @Description //// 签名最后做特殊URL编码
     * @Date 9:40 2024/1/29
     * @Param [value]
     **/
    public static String specialUrlEncode(String value) throws Exception {
        return java.net.URLEncoder.encode(value, "UTF-8").
                replace("+", "%20").
                replace("*", "%2A").replace("%7E", "~");
    }

    /**
     * @return java.lang.String
     * @Author djj
     * @Description //签名
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
