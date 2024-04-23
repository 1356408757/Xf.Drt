package com.trust.xfyl.entity.dto;

import com.trust.xfyl.model.ChatMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Deque;

/**
 * @author Bay-max
 * @date 2024/4/22 15:11
 **/

@EqualsAndHashCode(callSuper = true)
@Data
public class CompletionRequestDTO extends RequestBase {
    /**
     * session id
     */
    private String sessionId;

    /**
     * user action
     */
    private String userAction;

    /**
     * enum：ChatTypeEnum
     * text_chat: text chat
     * doc_chat: doc chat
     */
    private String sessionType;

    /**
     * content of prompt
     */
    private String content;

    /**
     * data id of doc
     */
    private String dataId;

    /**
     * userId of doc
     */
    private String userId;

    private Deque<ChatMessage> chatMessages;
}
