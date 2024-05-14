/*
package com.trust.xfyl;

import com.aliyun.oss.OSS;
import com.aliyuncs.exceptions.ClientException;
import com.trust.xfyl.entity.ResultVO;
import com.trust.xfyl.util.alUtilts.AliFileUrlUtils;
import com.trust.xfyl.util.alUtilts.AliSkinUtils;
import com.trust.xfyl.util.alUtilts.StsServiceSample;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.trust.xfyl.util.alUtilts.AliSkinUtils.DF;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class StsServiceSampleTest {

    @Mock
    private OSS ossClient;

    //TODO 测试阿里云oss对象存储文件上传


    @Test
    public void testUploadFiles() throws IOException, ClientException {
        // 创建要上传的文件列表
        List<MultipartFile> files = new ArrayList<>();
        File file1 = new File("D:\\image\\微信图片_20240520112301.jpg");
        File file2 = new File("D:\\image\\微信图片_20240520111741.jpg");

        MockMultipartFile mockFile1 = new MockMultipartFile(
                "file",
                file1.getName(),
                "image/jfif",
                new FileInputStream(file1)
        );
        files.add(mockFile1);

        MockMultipartFile mockFile2 = new MockMultipartFile(
                "file",
                file2.getName(),
                "image/png",
                new FileInputStream(file2)
        );
        files.add(mockFile2);

        // 调用上传文件方法
        ResultVO result = StsServiceSample.uploadFiles(files);

        // 断言上传结果
        assertNotNull(result);
        assertEquals(0, result.getStatus());
        assertEquals("success", result.getMsg());
        assertNotNull(result.getData());

        // 打印上传成功的文件链接
        ResultVO result1 = StsServiceSample.uploadFiles(files);
        List<Map<String, Object>> dataList = (List<Map<String, Object>>) result1.getData();
        for (Map<String, Object> fileMap : dataList) {
            for (Map.Entry<String, Object> entry : fileMap.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                System.out.println("Key: " + key + ", Value: " + value);
            }
        }

    }


    @Test
    void download() throws Throwable {
        StsServiceSample.download();

    }

    @Test
    void ossTest() throws Throwable {
        StsServiceSample.ossTest();

    }


    //TODO 测试阿里云oss对象存储跟阿里皮肤检测接口逻辑对接的方法；

    @Test
    void getFileUrl() throws Throwable {
        String accessKeyId = System.getenv("ALIBABA_CLOUD_ACCESS_KEY_ID");
        String keySecret = System.getenv("ALIBABA_CLOUD_ACCESS_KEY_SECRET");
        String url = "https://drt-oss-disk.oss-cn-shanghai.aliyuncs.com/src/image/202405201546-15763-c4cd0d5ea4c340ce883b1b5356ea4a41.jpg?Expires=1716194775&OSSAccessKeyId=STS.NUXkqF8nezaoqeBs1P1b4Rkv6&Signature=j8PczEnWRcr1ZmKQmDTCLKOjHng%3D&security-token=CAISnAN1q6Ft5B2yfSjIr5btIMvy1bFEzaOEc0PzlzEFPe0Yva7d1Dz2IHhMeHZtCO4ct%2Fk%2FnWxY6foTlqJIRoReREvCUcZr8syiK9Ng8tOT1fau5Jko1bdpcAr6UmwNta2%2FSuH9S8ynJJXJQlvYlyh17KLnfDG5JTKMOoGIjpgVGLZyWRKjPwJbGPBcJAZptK1%2FMmDKZ9mgLjnggGfbEDBd2GxGhHh49L60z%2BCF9xPalyea8OIOoJnrKZXWRqsaNZxkAdCux740JOiT3DRMrh9R7%2BJ6jbdHvizdtZbfYS5Y6A7UNPHPoJ89bl11fLR%2FHLVf6fT9jv4%2FtuHIi8O16W4UZrkLCniEHdj9mpKbQLL5DLtjK%2BanYUaq%2B8uUK5z4vzkjZX8mLw5Qc7IjUCQoUUBzF2CEcPb6qAmWMlj%2FGrLnyqgz1oFu01jz4cooq495ySBZu8xxGOjfDytAX3Z%2BtQRqgryb1Za7nXnTpqdH4PSSfZEvSFLSx3n2fAdOoL85QXNQCT2oxC7hlwvxcBwktahZUPBs1w2OJwDnExfw4i98GoABEBUH2BwDwqYmVSsNiTWdTj2Xi0aCMg4acts3%2FkLD8uXOs3BulEBixrAaM%2BCH32jnBK5kkjxYJjqe8ydMxvbq%2BWmrqLIY9tatrs6odyKkE7ZXJ9PBWc%2BAlpZawSlWP71XE8n2Rs1DDJ4zUGIojQj7W7jxlKi7Jcz47KHhBHcKQeEgAA%3D%3D";
        DF.setTimeZone(new java.util.SimpleTimeZone(0, "GMT"));
        // 业务参数名字是大驼峰
        Map<String, String> params = new HashMap<>();
        // 注意，使用签名机制调用，
        // 文件参数目前仅支持上海OSS链接，
        // 可参考https://help.aliyun.com/document_detail/175142.html文档将文件放入上海OSS中。
        // 如果是其他情况（如本地文件或者其他链接），
        // 请先显式地转换成上海OSS链接，可参考https://help.aliyun.com/document_detail/155645.html文档中的方式二，
        // 但该方案不支持web前端环境直接调用。 /tmp/bankCard.png
        params.put("Url", url);
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
        System.out.println("RequestId========获取的结果集Id=============================================================" + execute.get("RequestId"));
        System.out.println("ImageQuality===图像质量========================================================" + imageQuality);
        System.out.println("BodyPart===受伤部位============================================================" + bodyPart);
        System.out.println("Results===结果集===============================================================" + results);
        System.out.println("ResultsEnglish===英文结果集=====================================================" + resultsEnglish);
        System.out.println("ImageType===图片类型============================================================" + imageType);


    }
}
*/
