package com.trust.xfyl.util;

import com.aliyun.imageprocess20200320.Client;
import com.aliyun.imageprocess20200320.models.RunMedQARequest;
import com.aliyun.imageprocess20200320.models.RunMedQAResponse;
import com.aliyun.imageprocess20200320.models.RunMedQAResponseBody;
import com.aliyun.tea.TeaException;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.teautil.models.RuntimeOptions;
import com.trust.xfyl.entity.dto.SampleDto;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Objects;

/**
 * TODO 调用阿里医学智能的接口
 *
 * @Description
 * @author Bay-max
 * @date 2024/4/22 15:39
 **/

@Slf4j
public class Sample {

    private static final Client client;

    static {
        try {
            client = createClient();
        } catch (Exception e) {
            log.error("Failed to initialize the client", e);
            throw new RuntimeException("Unable to initialize the Aliyun Image Process client", e);
        }
    }

    private static Client createClient() throws Exception {
        Config config = new Config()
                .setAccessKeyId(getEnvVariable("ALIBABA_CLOUD_ACCESS_KEY_ID"))
                .setAccessKeySecret(getEnvVariable("ALIBABA_CLOUD_ACCESS_KEY_SECRET"));
        config.endpoint = "imageprocess.cn-shanghai.aliyuncs.com";
        return new Client(config);
    }

    private static String getEnvVariable(String name) {
        String value = System.getenv(name);
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Environment variable '" + name + "' must be set");
        }
        return value;
    }

    /**
     * 构建请求参数，根据SampleDto中的信息决定是否上传图片或文本问题。
     *
     * @param sampleDto 包含会话ID、问题类型、答案文本和图片URL的对象
     * @return 构建好的RunMedQARequest对象
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
     * 执行智能医疗问答API调用，并处理响应结果。
     *
     * @param sampleDto 包含请求信息的对象
     * @return 根据请求生成的Data部分，适配前端格式后返回
     * @throws RuntimeException 当API调用失败时抛出异常
     */
    public static RunMedQAResponseBody.RunMedQAResponseBodyData executeMedicalQuestionAndAnswer(SampleDto sampleDto) throws Exception {
        RuntimeOptions runtime = new RuntimeOptions();
        RunMedQARequest request = buildRunMedQaRequest(sampleDto);

        try {
            RunMedQAResponse response = client.runMedQAWithOptions(request, runtime);
            RunMedQAResponseBody body = response.getBody();
            log.info("Status code: {}", response.getStatusCode());
            log.info("RequestId: {}", body.getRequestId());
            log.info("Response data: {}", body.getData());
            return body.getData();
        } catch (TeaException teaError) {
            log.error("TeaException occurred: {}", teaError.getMessage());
            if (teaError.getData() != null && teaError.getData().containsKey("Recommend")) {
                log.error("Recommendation: {}", teaError.getData().get("Recommend"));
            }
            throw new RuntimeException("Failed to execute Medical Question and Answer API due to TeaException", teaError);
        }
    }
}