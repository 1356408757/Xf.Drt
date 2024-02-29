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
        String accessKeyId = "LTAI5tBDwYcXRACEzdXfvyMi";
        String accessSecret = "wTJRuVbKPFPwnEwhH2BvvNCtLGvSzV";
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
        String url = "https://drt-oss-disk.oss-cn-shanghai.aliyuncs.com/src/image/202402271021-10918-4e65a871000748a683942dbaf7d353ed.jpg?Expires=1709004077&OSSAccessKeyId=STS.NTjEj2aLCMmHnpZAPMiCjQdVv&Signature=7YePSZ3zh0es73bCMfs7H7Pt84M%3D&security-token=CAISzwJ1q6Ft5B2yfSjIr5ffDtCGjJNi%2Bq%2BjbFbrpVAYZcxGvqH9lDz2IHhMeHZtCO4ct%2Fk%2FnWxY6foTlqJIRoReREvCUcZr8sy%2FKLoN1dOT1fau5Jko1bdpcAr6UmwNta2%2FSuH9S8ynJJXJQlvYlyh17KLnfDG5JTKMOoGIjpgVGLZyWRKjPwJbGPBcJAZptK1%2FMmDKZ9mgLjnggGfbEDBd2GxGhHh49L60z%2BCF9xPalyea8OIOoJnrKZXWRqsaNZxkAdCux740JOiT3DRMrh9R7%2BJ6jbdHvizdtZbfYS5Y6A7UNPHPoJ89bl11fLR%2FHLVf6fT9jv4%2FtuHIi8O16W4UZrkLCniEHdj9mpKbQLL5DLtjK%2BanYUaq%2B8uUK5z4vzkjZX8mLw5Qc7IjUCQoUUBzF2CEcPb6qAmWMlj%2FGrLnyqgz1oFu01jz4cooq495ySBZuxqAASspY7iyAVzVfMeRTeEqmCrAQP4j3anq0tPruv0USK%2B3mRgsRQoNfKkjwITPHYVqqjGNurIKQdEhoJ4rH70mmcwP0b9g9Ew%2BGlZPBZJu6GTj8pnZuUYH4B%2B0ls%2Fj6iOkVMkg4Z2L2vVzHTC4GTrJkefWd5soSR7qo0rVRObEhzZPIAA%3D";
        String fileUrl = AliFileUrlUtils.getFileUrl(accessKeyId, accessSecret, url);
        params.put("Url", fileUrl);
        // API Action，能力名称，请参考具体算法文档详情页中的Action参数，
        String action = "DetectSkinDisease";
        JSONObject execute = AliSkinUtils.execute(action, accessKeyId, accessSecret, params);
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
