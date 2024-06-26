package com.trust.xfyl.service;

import com.trust.xfyl.model.po.ChatMessage;

import java.util.Deque;

/**
 * 对话历史会话管理
 * @author Bay-max
 * @date 2024/4/22 15:37
 **/
public interface ChatSessionService {
    /**
     * 获取对话历史记录
     *
     * @param sessionId 会话标识
     * @return 对话历史记录
     */
    Deque<ChatMessage> getChatSessions(String sessionId);

    /**
     * 保存对话历史记录
     *
     * @param sessionId 会话标识
     * @param chatMessages 对话历史记录
     */
    void saveChatSessions(String sessionId, Deque<ChatMessage> chatMessages);

    /**
     * 新增对话历史
     *
     * @param sessionId 会话标识
     * @param message   对话记录
     */
    void saveChatMessage(String sessionId, ChatMessage message);
}
