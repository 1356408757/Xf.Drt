package com.trust.xfyl.util;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.trust.xfyl.util.AliSkinUtils.DF;


/**
 * @Author djj
 * @Description //TODO
 * @Date 9:30 2024/2/18
 **/
public class AliyunFileUrlHandler {

    public static void main(String[] args) throws Exception {
        // 创建AccessKey ID和AccessKey Secret，请参见：https://help.aliyun.com/document_detail/175144.html
        // 如果您使用的是RAM用户的AccessKey，还需要为子账号授予权限AliyunVIAPIFullAccess，请参见：https://help.aliyun.com/document_detail/145025.html
        String accessKeyId = System.getenv("ALIBABA_CLOUD_ACCESS_KEY_ID");
        String keySecret = System.getenv("ALIBABA_CLOUD_ACCESS_KEY_SECRET");
        // 这里一定要设置GMT时区
        DF.setTimeZone(new java.util.SimpleTimeZone(0, "GMT"));
        // 业务参数名字是大驼峰
        Map<String, String> params = new HashMap<>();
        // 注意，使用签名机制调用，
        // 文件参数目前仅支持上海OSS链接，
        // 可参考https://help.aliyun.com/document_detail/175142.html文档将文件放入上海OSS中。
        // 如果是其他情况（如本地文件或者其他链接），
        // 请先显式地转换成上海OSS链接，可参考https://help.aliyun.com/document_detail/155645.html文档中的方式二，
        // 但该方案不支持web前端环境直接调用。 /tmp/bankCard.png
        String url = "https://magicpic-p.cdn.bcebos.com/atlas/4e9ac6da4a8f6bbe422102fff5710222.jpg";
        String fileUrl = AliFileUrlUtils.getFileUrl(accessKeyId, keySecret, url);
        params.put("Url", fileUrl);
        // API Action，能力名称，请参考具体算法文档详情页中的Action参数，
        String action = "DetectSkinDisease";
        JSONObject execute = AliSkinUtils.execute(action, accessKeyId, keySecret, params);
        //返回的结果集，通过getKey的方式获取里面单个参数，然后打印到控制台;
        System.out.println("execute" + "=====================================" + execute.toString());
        Object data = execute.get("Data");
        System.out.println("Data" + "=========================================" + data);
        String result = data.toString();
        JSONObject jsonObject = new JSONObject(result);
        Object imageQuality = jsonObject.get("ImageQuality");
        Object bodyPart = jsonObject.get("BodyPart");
        Object resultsEnglish = jsonObject.get("ResultsEnglish");
        Object imageType = jsonObject.get("ImageType");
        Object results = jsonObject.get("Results");
        System.out.println("FileUrl========转换后的图片地址====================================" + fileUrl);
        System.out.println("RequestId========获取的结果集Id=============================================================" + execute.get("RequestId"));
        System.out.println("ImageQuality===图像质量========================================================" + imageQuality);
        System.out.println("BodyPart===受伤部位============================================================" + bodyPart);
        System.out.println("Results===结果集===============================================================" + results);
        System.out.println("ResultsEnglish===英文结果集=====================================================" + resultsEnglish);
        System.out.println("ImageType===图片类型============================================================" + imageType);

    }

}
