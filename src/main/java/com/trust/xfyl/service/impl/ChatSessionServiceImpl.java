package com.trust.xfyl.service.impl;

import com.trust.xfyl.config.AppConfig;
import com.trust.xfyl.model.po.ChatMessage;
import com.trust.xfyl.service.CacheManager;
import com.trust.xfyl.service.ChatSessionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 * 聊天会话服务的实现类，负责管理用户的聊天会话
 * @author Bay-max
 * @date 2024/4/22 15:37
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class ChatSessionServiceImpl implements ChatSessionService {
    private static final String CACHE_PREFIX = "chat_session:"; // 缓存键的前缀

    @Resource
    private AppConfig appConfig; // 应用配置

    @Resource
    private CacheManager cacheManager; // 缓存管理器

    /**
     * 获取指定会话ID的聊天会话记录
     * @param sessionId 会话ID
     * @return 聊天会话记录的队列
     */
    @Override
    public Deque<ChatMessage> getChatSessions(String sessionId) {
        String key = getCacheKey(sessionId); // 生成缓存键
        return cacheManager.get(key); // 从缓存中获取会话记录
    }

    /**
     * 保存指定会话ID的聊天会话记录
     * @param sessionId 会话ID
     * @param chatMessages 聊天会话记录的队列
     */
    @Override
    public void saveChatSessions(String sessionId, Deque<ChatMessage> chatMessages) {
        String key = getCacheKey(sessionId); // 生成缓存键
        // 将会话记录保存到缓存中
        cacheManager.put(key, chatMessages, 30, TimeUnit.DAYS);
    }

    /**
     * 添加一条聊天消息到指定的会话中
     * @param sessionId 会话ID
     * @param message 要添加的聊天消息
     */
    @Override
    public void saveChatMessage(String sessionId, ChatMessage message) {
        Deque<ChatMessage> chatMessages = getChatSessions(sessionId); // 获取会话记录
        if (chatMessages == null) {
            chatMessages = new ArrayDeque<>(); // 如果会话记录为空，则新建一个队列
        } else if (chatMessages.size() > appConfig.getSessionMaxMessages()) {
            chatMessages.poll(); // 如果会话记录超过最大数量，则移除最旧的消息
        }

        chatMessages.offer(message); // 添加新消息
        saveChatSessions(sessionId, chatMessages); // 保存更新后的会话记录
    }

    /**
     * 生成缓存键
     * @param key 原始键
     * @return 加了前缀的缓存键
     */
    private String getCacheKey(String key) {
        return CACHE_PREFIX + key; // 返回加上前缀的键
    }
}
