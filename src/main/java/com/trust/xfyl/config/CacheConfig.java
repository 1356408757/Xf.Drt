package com.trust.xfyl.config;


import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.trust.xfyl.cache.CacheManager;
import com.trust.xfyl.cache.impl.CaffeineCacheManager;
import com.trust.xfyl.cache.impl.RedisCacheManager;
import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * 缓存配置类，提供根据配置文件选择使用redis或caffeine作为缓存方式的功能。
 *
 * @author yuanci
 */
@Configuration
public class CacheConfig {
    // Redis配置资源
    @Resource
    private RedisConfig redisConfig;

    // 应用配置资源
    @Resource
    private AppConfig appConfig;

    /**
     * 创建并返回Redis缓存管理器的Bean实例。
     * 仅当chat.cache.type配置为redis时被激活。
     *
     * @return RedisCacheManager Redis缓存管理器实例
     */
    @Bean
    @ConditionalOnProperty(name = "chat.cache.type", havingValue = "redis")
    public CacheManager redisCacheManager() {
        // 初始化Redisson配置
        Config config = new Config();
        config.setCodec(new JsonJacksonCodec());
        SingleServerConfig singleServerConfig = config.useSingleServer();

        // 设置Redis服务器连接配置
        int port = redisConfig.getPort() != null ? redisConfig.getPort() : 6379;
        singleServerConfig.setAddress("redis://" + redisConfig.getHost() + ":" + port);
        singleServerConfig.setConnectionPoolSize(500);
        singleServerConfig.setSubscriptionConnectionPoolSize(300);
        singleServerConfig.setSubscriptionsPerConnection(500);

        // 如果配置了密码，则设置密码
        if (StringUtils.isNotBlank(redisConfig.getPassword())) {
            singleServerConfig.setPassword(redisConfig.getPassword());
        }

        // 创建Redisson客户端并返回Redis缓存管理器
        RedissonClient redissonClient = Redisson.create(config);
        return new RedisCacheManager(redissonClient);
    }

    /**
     * 创建并返回Caffeine缓存管理器的Bean实例。
     * 仅当chat.cache.type配置为caffeine时被激活。
     *
     * @return CaffeineCacheManager Caffeine缓存管理器实例
     */
    @Bean
    @ConditionalOnProperty(name = "chat.cache.type", havingValue = "caffeine")
    public CacheManager caffeineCacheManager() {
        // 创建并配置Caffeine缓存
        Cache<Object, Object> cache = Caffeine.newBuilder()
                .expireAfterAccess(appConfig.getSessionTtl(), TimeUnit.HOURS)
                .maximumSize(100000)
                .build();

        // 返回Caffeine缓存管理器
        return new CaffeineCacheManager(cache);
    }
}

