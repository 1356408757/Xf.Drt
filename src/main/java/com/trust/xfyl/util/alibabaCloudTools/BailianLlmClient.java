package com.trust.xfyl.util.alibabaCloudTools;

import com.aliyun.broadscope.bailian.sdk.AccessTokenClient;
import com.aliyun.broadscope.bailian.sdk.ApplicationClient;
import com.aliyun.broadscope.bailian.sdk.models.CompletionsRequest;
import com.aliyun.broadscope.bailian.sdk.models.CompletionsResponse;
import com.aliyun.broadscope.bailian.sdk.models.ConnectOptions;
import com.trust.xfyl.config.LlmConfig;
import com.trust.xfyl.model.dto.CompletionRequestDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 调用阿里云百炼大模型服务的客户端类
 *
 * @author Bay-max
 * @date 2024/4/22 15:39
 **/
@Component
public class BailianLlmClient {

    @Resource
    // 配置大模型所需的访问信息
    private LlmConfig llmConfig;
    // 用于获取访问令牌的客户端
    private AccessTokenClient accessTokenClient;

    /**
     * 初始化客户端，配置访问令牌
     */
    @PostConstruct
    public void init() {
        // 从配置中读取访问阿里云百炼所需要的凭证信息
        String accessKeyId = llmConfig.getAccessKeyId();
        String accessKeySecret = llmConfig.getAccessKeySecret();
        String agentKey = llmConfig.getAgentKey();

        // 初始化AccessTokenClient
        accessTokenClient = new AccessTokenClient(accessKeyId, accessKeySecret, agentKey);
    }

    /**
     * 向大模型发送请求，并以流（Flux）的形式获取响应结果
     *
     * @param completionRequest 包含大模型请求内容的DTO
     * @return 返回大模型响应结果的流
     */
    public Flux<CompletionsResponse> createStreamCompletion(CompletionRequestDTO completionRequest) {
        // 获取访问令牌
        String token = accessTokenClient.getToken();
        // 超时设置，单位为毫秒
        int timeout = llmConfig.getTimeout() * 1000;
        // 构建应用客户端
        ApplicationClient client = ApplicationClient.builder()
                .token(token)
                .connectOptions(new ConnectOptions(timeout, timeout, timeout))
                .build();

        // 准备模型请求参数
        String requestId = completionRequest.getRequestId(); // 请求ID
        String prompt = completionRequest.getContent(); // 提示信息
        CompletionsRequest request = new CompletionsRequest()
                .setRequestId(requestId)
                .setPrompt(prompt)
                .setAppId(llmConfig.getAppId()) // 应用ID
                .setDocReferenceType("indexed")
                .setHasThoughts(true); // 是否包含思考过程

        // 如果有会话历史，添加到请求中
        if (!CollectionUtils.isEmpty(completionRequest.getChatMessages())) {
            // 处理会话历史信息
            List<CompletionsRequest.ChatQaPair> history = completionRequest.getChatMessages().stream().map(item ->
                            new CompletionsRequest.ChatQaPair(item.getUser(), item.getAssistant()))
                    .collect(Collectors.toList());
            request.setHistory(history);
        }

        // 发送请求并获取流式响应
        return client.streamCompletions(request);
    }
}
