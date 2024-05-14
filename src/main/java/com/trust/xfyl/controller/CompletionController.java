package com.trust.xfyl.controller;

import com.trust.xfyl.enums.ErrorCodeEnum;
import com.trust.xfyl.exception.BizException;
import com.trust.xfyl.handler.ChatServiceHandler;
import com.trust.xfyl.model.Result;
import com.trust.xfyl.model.dto.CompletionRequestDTO;
import com.trust.xfyl.model.dto.CompletionResponseDTO;
import com.trust.xfyl.service.ChatSessionService;
import com.trust.xfyl.util.alibabaCloudTools.BailianLlmClient;
import com.trust.xfyl.util.alibabaCloudTools.LogUtils;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 聊天对话控制器
 *
 * @author Bay-max
 * @date 2024/4/22 14:01
 **/
@Api(value = "AI问答控制器", description = "AI问答控制器", tags = "AI问答控制器")
@RestController
@RequestMapping("/v1")
public class CompletionController {
    @Resource
    private BailianLlmClient llmClient;

    @Resource
    private ChatSessionService chatSessionService;

    /**
     * 完成对话请求处理
     *
     * @param completionRequest 完成请求的DTO，包含请求内容和ID
     * @param response          HTTP响应对象，用于设置响应头
     * @return 返回一个Flux流，包含处理结果
     */
    @PostMapping(value = "/completions", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Result<CompletionResponseDTO>> complete(@RequestBody CompletionRequestDTO completionRequest,
                                                        HttpServletResponse response) {
        long startTime = System.currentTimeMillis();
        String requestId = completionRequest.getRequestId();
        LogUtils.trace(requestId, "completion", "SUCCESS", startTime, completionRequest, null);

        try {
            // 设置响应头以支持流式传输
            response.setContentType("text/event-stream");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("X-Accel-Buffering", "no");

            // 参数校验
            String content = completionRequest.getContent();
            if (StringUtils.isBlank(requestId) || StringUtils.isBlank(content)) {
                LogUtils.monitor(requestId, "CompletionController", "complete", "error",
                        startTime, completionRequest, ErrorCodeEnum.PARAMS_INVALID.getErrorMessage());
                Result<CompletionResponseDTO> error = Result.error(requestId, ErrorCodeEnum.PARAMS_INVALID);

                return Flux.just(error);
            }

            // 处理对话请求
            ChatServiceHandler handler = new ChatServiceHandler(chatSessionService, llmClient);
            Flux<Result<CompletionResponseDTO>> handle = handler.handle(completionRequest);
            return handle;
        } catch (BizException e) {
            // 业务异常处理
            LogUtils.monitor(requestId, "CompletionController", "complete", "error",
                    startTime, completionRequest, e);
            Result<CompletionResponseDTO> error = Result.error(requestId, e.getErrorCode(), e.getMessage());

            return Flux.just(error);
        } catch (Exception e) {
            // 通用异常处理
            LogUtils.monitor(requestId, "CompletionController", "complete", "error",
                    startTime, completionRequest, e);
            Result<CompletionResponseDTO> error = Result.error(requestId, ErrorCodeEnum.CREATE_COMPLETION_ERROR);

            return Flux.just(error);
        }
    }

    /**
     * 停止生成对话
     *
     * @param request 包含请求ID的DTO
     * @return 返回一个表示成功的结果
     */
    @PostMapping(value = "/stopGeneration", produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<String> stopGeneration(@RequestBody CompletionRequestDTO request) {
        Long start = System.currentTimeMillis();
        System.out.println(start + "================================");
        // 目前该方法实际上不做任何操作，可能未来用于记录停止生成的操作
        LogUtils.monitor(request.getRequestId(), "CompletionController", "stopGeneration", null, start, request, null);
        return Result.success(request.getRequestId(), request.getRequestId());
    }
}
