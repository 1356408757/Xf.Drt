package com.trust.xfyl.handler;

import com.aliyun.broadscope.bailian.sdk.models.CompletionsResponse;
import com.trust.xfyl.entity.dto.CompletionRequestDTO;
import com.trust.xfyl.entity.dto.CompletionResponseDTO;
import com.trust.xfyl.entity.dto.Result;
import com.trust.xfyl.enums.ErrorCodeEnum;
import com.trust.xfyl.exception.BizException;
import com.trust.xfyl.model.ChatMessage;
import com.trust.xfyl.service.ChatSessionService;
import com.trust.xfyl.util.BailianLlmClient;
import com.trust.xfyl.util.LogUtils;
import org.apache.commons.lang3.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.security.NoSuchAlgorithmException;
import java.util.Deque;
import java.util.UUID;

/**
 * 对话服务处理类，负责处理对话请求，与聊天模型交互，并处理结果。
 * @author Bay-max
 * @date 2024/4/22 15:37
 **/
public class ChatServiceHandler {
    private final ChatSessionService chatSessionService; // 聊天会话服务
    private final BailianLlmClient llmClient; // 百炼语言模型客户端
    private CompletionRequestDTO request; // 对话请求数据
    private Long startTime; // 处理开始时间
    private String responseText; // 模型响应文本
    private boolean success; // 处理是否成功

    /**
     * 构造函数，初始化聊天会话服务和百炼客户端。
     *
     * @param chatSessionService 聊天会话服务
     * @param llmClient 百炼语言模型客户端
     */
    public ChatServiceHandler(ChatSessionService chatSessionService, BailianLlmClient llmClient) {
        this.chatSessionService = chatSessionService;
        this.llmClient = llmClient;
    }

    /**
     * 处理对话请求，与百炼语言模型进行交互，并返回流式处理结果。
     *
     * @param request 对话请求数据
     * @return 流式结果响应
     * @throws NoSuchAlgorithmException 如果遇到 NoSuchAlgorithmException 异常
     */
    public Flux<Result<CompletionResponseDTO>> handle(CompletionRequestDTO request) throws NoSuchAlgorithmException {
        this.request = request;
        this.startTime = System.currentTimeMillis();

        // 生成或获取会话ID
        String sessionId = request.getSessionId();
        if (StringUtils.isBlank(sessionId)) {
            sessionId = UUID.randomUUID().toString();
            request.setSessionId(sessionId);
        }

        // 获取并设置会话历史消息
        Deque<ChatMessage> chatMessages = chatSessionService.getChatSessions(sessionId);
        request.setChatMessages(chatMessages);

        // 向百炼语言模型发送请求并处理响应
        Flux<CompletionsResponse> flux = llmClient.createStreamCompletion(request);

        return flux.onBackpressureBuffer()
                .map(this::convertResponse)
                .onErrorResume(this::handleError)
                .doOnComplete(this::handleComplete);
    }

    /**
     * 错误处理，生成错误结果。
     *
     * @param t 异常对象
     * @return 错误结果
     */
    private Mono<Result<CompletionResponseDTO>> handleError(Throwable t) {
        String requestId = request.getRequestId();
        LogUtils.monitor(requestId, "ChatServiceHandler", "handleError", "error", startTime, request, t);

        Result<CompletionResponseDTO> error = Result.error(requestId, ErrorCodeEnum.CREATE_COMPLETION_ERROR);
        if (t instanceof BizException) {
            BizException e = (BizException) t;
            error = Result.error(requestId, e.getErrorCode(), e.getMessage());
        }

        return Mono.just(error);
    }

    /**
     * 处理完成后的逻辑，如保存对话历史。
     */
    private void handleComplete() {
        if (!success) {
            return;
        }

        String requestId = request.getRequestId();
        LogUtils.monitor(requestId, "ChatServiceHandler", "handleComplete", null, startTime, request);

        // 保存对话历史
        String userMessage = request.getContent();
        if (StringUtils.isNotBlank(userMessage) && StringUtils.isNotBlank(responseText)) {
            ChatMessage message = new ChatMessage();
            message.setUser(userMessage);
            message.setAssistant(responseText);

            String sessionId = request.getSessionId();
            chatSessionService.saveChatMessage(sessionId, message);
        }
    }

    /**
     * 转换百炼语言模型的响应为前端可接收的结果格式。
     *
     * @param response 百炼语言模型的响应
     * @return 前端可接收的结果
     */
    private Result<CompletionResponseDTO> convertResponse(CompletionsResponse response) {
        if (response == null) {
            return null;
        }

        String requestId = request.getRequestId();
        String sessionId = request.getSessionId();
        Result<CompletionResponseDTO> result = new Result<>();

        if (!response.isSuccess()) {
            throw new BizException(response.getCode(), response.getMessage());
        }

        success = true;
        if (response.getData() != null) {
            LogUtils.trace(requestId, "ChatServiceHandler", "SUCCESS", startTime, null, response);

            result.setSuccess(true);
            String responseText = response.getData().getText();

            CompletionResponseDTO responseDTO = new CompletionResponseDTO();
            responseDTO.setContentType("text");
            responseDTO.setSessionId(sessionId);
            responseDTO.setContent(responseText);
            result.setData(responseDTO);

            this.responseText = responseText;
        }

        return result;
    }
}
