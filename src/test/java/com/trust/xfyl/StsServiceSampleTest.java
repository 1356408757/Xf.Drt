package com.trust.xfyl;

import com.aliyun.oss.OSS;
import com.aliyuncs.exceptions.ClientException;
import com.trust.xfyl.entity.ResultVO;
import com.trust.xfyl.util.AliSkinUtils;
import com.trust.xfyl.util.StsServiceSample;
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

import static com.trust.xfyl.util.AliSkinUtils.DF;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @Author djj
 * @Description//TODO 阿里oss对象存属测试类
 * @Date 21:15 2024/2/28
 * @Param
 * @return
 **/


@SpringBootTest
public class StsServiceSampleTest {

    @Mock
    private OSS ossClient;

    //TODO 测试阿里云oss对象存储文件上传


    @Test
    public void testUploadFiles() throws IOException, ClientException {
        // 创建要上传的文件列表
        List<MultipartFile> files = new ArrayList<>();
        File file1 = new File("D:\\home\\app\\uploadImg\\8a231dc9-c6de-4628-8c73-c81903edc64e.jfif");
        File file2 = new File("D:\\home\\app\\uploadImg\\13af9fa6-48c5-4540-971f-71780785868f.png");

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

    /**
     * @return void
     * @Author djj
     * @Description//TODO 测试阿里云oss下载文件的方法
     * @Date 21:15 2024/2/28
     * @Param []
     **/

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
        String accessKeyId = "LTAI5tBDwYcXRACEzdXfvyMi";
        String accessSecret = "wTJRuVbKPFPwnEwhH2BvvNCtLGvSzV";
        String url = "https://drt-oss-disk.oss-cn-shanghai.aliyuncs.com/src/image/202402271205-40589-d1f905a37fe14322a695e0210811fbdf.jpg?Expires=1709086278&OSSAccessKeyId=STS.NT6pPWgUYc61TRvA9ZyChKCbX&Signature=Qe14m7T2YOIR2RU%2FqjzigWOfM8I%3D&security-token=CAISzwJ1q6Ft5B2yfSjIr5eDO%2Brjiop41PTaVnTHpTkPdcxEpIbJujz2IHhMeHZtCO4ct%2Fk%2FnWxY6foTlqJIRoReREvCUcZr8szFZYAi1dOT1fau5Jko1bdpcAr6UmwNta2%2FSuH9S8ynJJXJQlvYlyh17KLnfDG5JTKMOoGIjpgVGLZyWRKjPwJbGPBcJAZptK1%2FMmDKZ9mgLjnggGfbEDBd2GxGhHh49L60z%2BCF9xPalyea8OIOoJnrKZXWRqsaNZxkAdCux740JOiT3DRMrh9R7%2BJ6jbdHvizdtZbfYS5Y6A7UNPHPoJ89bl11fLR%2FHLVf6fT9jv4%2FtuHIi8O16W4UZrkLCniEHdj9mpKbQLL5DLtjK%2BanYUaq%2B8uUK5z4vzkjZX8mLw5Qc7IjUCQoUUBzF2CEcPb6qAmWMlj%2FGrLnyqgz1oFu01jz4cooq495ySBZuxqAAQeogjEAPF26XoOmOKGuFOznr4b%2BRF7vaqFnlEuIU63e2HIe590kY2mR8u%2BTFMnQH0jMs43iqyYUDhz7fZfIBwxjQcOtjK2%2F8fLE5BcZL4q7iFm2DpOATCJM2KVdybwa6xu5UMbp3WA3CEbgbFA98qm8g2ZCouwR635pC3lHkN9nIAA%3D";
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
        System.out.println("RequestId========获取的结果集Id=============================================================" + execute.get("RequestId"));
        System.out.println("ImageQuality===图像质量========================================================" + imageQuality);
        System.out.println("BodyPart===受伤部位============================================================" + bodyPart);
        System.out.println("Results===结果集===============================================================" + results);
        System.out.println("ResultsEnglish===英文结果集=====================================================" + resultsEnglish);
        System.out.println("ImageType===图片类型============================================================" + imageType);


    }

}
