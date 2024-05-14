package com.trust.xfyl.util.alibabaCloudTools;

import com.aliyun.imageprocess20200320.Client;
import com.aliyun.imageprocess20200320.models.RunMedQARequest;
import com.aliyun.imageprocess20200320.models.RunMedQAResponse;
import com.aliyun.imageprocess20200320.models.RunMedQAResponseBody;
import com.aliyun.tea.TeaException;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.teautil.models.RuntimeOptions;
import com.trust.xfyl.model.dto.SampleDto;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Objects;

/**
 * 调用阿里医学智能的接口工具类
 *
 * @author Bay-max
 * @Description 提供与阿里云医学智能平台交互的功能方法
 * @date 2024/4/22 15:39
 **/
@Slf4j
public class AliMedIQAUtils {

    private static final Client client;

    static {
        try {
            // 初始化阿里云医学智能客户端
            client = createClient();
        } catch (Exception e) {
            log.error("Failed to initialize the client", e);
            throw new RuntimeException("Unable to initialize the Aliyun Image Process client", e);
        }
    }

    private static Client createClient() throws Exception {
        // 配置访问阿里云的凭证和端点
        Config config = new Config()
                .setAccessKeyId(getEnvVariable("ALIBABA_CLOUD_ACCESS_KEY_ID"))
                .setAccessKeySecret(getEnvVariable("ALIBABA_CLOUD_ACCESS_KEY_SECRET"));
        config.endpoint = "imageprocess.cn-shanghai.aliyuncs.com";
        return new Client(config);
    }

    private static String getEnvVariable(String name) {
        // 从环境变量中获取必要的配置信息
        String value = System.getenv(name);
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Environment variable '" + name + "' must be set");
        }
        return value;
    }

    /**
     * 根据SampleDto中的信息构建RunMedQARequest对象。
     * 如果session ID为空或未设置，则默认上传图片；否则，根据已有会话上传文本问题。
     *
     * @param sampleDto 包含会话ID、问题类型、答案文本和图片URL的对象
     * @return 构建好的RunMedQARequest对象，供API调用使用
     */
    private static RunMedQARequest buildRunMedQaRequest(SampleDto sampleDto) {
        RunMedQARequest request = new RunMedQARequest()
                .setOrgId("orgId")
                .setOrgName("OrgName")
                .setDepartment("皮肤科");
        if (Objects.equals(sampleDto.getSessionId(), "")) {
            sampleDto.setSessionId(null);
            sampleDto.setQuestionType("images");
        }
        if (sampleDto.getSessionId() == null) {
            // 第一次调用，上传图片
            request.setQuestionType(sampleDto.getQuestionType())
                    .setAnswerImageURLList(sampleDto.getAnswerImageList());
        } else {
            // 已有会话，设置问题类型为文本
            request.setSessionId(sampleDto.getSessionId())
                    .setQuestionType(sampleDto.getQuestionType())
                    .setAnswerTextList(Collections.singletonList(
                            new RunMedQARequest.RunMedQARequestAnswerTextList().setAnswerText(sampleDto.getAnswerText())));
        }

        return request;
    }

    /**
     * 执行智能医疗问答API调用，处理输入参数并返回处理结果。
     *
     * @param sampleDto 包含请求信息的对象，如会话ID、问题类型、答案文本和图片URL
     * @return 根据请求生成的Data部分，适配前端格式后返回
     * @throws RuntimeException 当API调用失败时抛出异常
     */
    public static RunMedQAResponseBody.RunMedQAResponseBodyData executeMedicalQuestionAndAnswer(SampleDto sampleDto) throws Exception {
        RuntimeOptions runtime = new RuntimeOptions();
        // 构建请求对象
        RunMedQARequest request = buildRunMedQaRequest(sampleDto);
        try {
            // 执行API调用，并处理响应
            RunMedQAResponse response = client.runMedQAWithOptions(request, runtime);
            RunMedQAResponseBody body = response.getBody();
            log.info("Status code: {}", response.getStatusCode());
            log.info("RequestId: {}", body.getRequestId());
            log.info("Response data: {}", body.getData());
            return body.getData();
        } catch (TeaException teaError) {
            // 处理可能出现的TeaException异常
            log.error("TeaException occurred: {}", teaError.getMessage());
            if (teaError.getData() != null && teaError.getData().containsKey("Recommend")) {
                log.error("Recommendation: {}", teaError.getData().get("Recommend"));
            }
            throw new RuntimeException("Failed to execute Medical Question and Answer API due to TeaException", teaError);
        }
    }
}
