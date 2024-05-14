package com.trust.xfyl.model.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @author Bay-max
 * @date 2024/4/22 14:01
 **/
@Data
@ToString
public class CompletionResponseDTO {
    /**
     * session id for chat history
     */
    private String sessionId;

    /**
     * content type, default is text
     */
    private String contentType;

    /**
     * completion result
     */
    private String content;
}
