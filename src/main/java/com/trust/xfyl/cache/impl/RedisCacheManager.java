package com.trust.xfyl.cache.impl;

import com.trust.xfyl.cache.CacheManager;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;

/**
 * Redis缓存管理器实现类，用于操作Redis缓存
 * @author Bay-max
 * @date 2024/4/22 14:01
 **/
public class RedisCacheManager implements CacheManager {
    private final RedissonClient redissonClient; // Redisson客户端，用于连接和操作Redis

    /**
     * RedisCacheManager构造函数
     * @param redissonClient Redisson客户端实例
     */
    public RedisCacheManager(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    /**
     * 将值存储到缓存中
     * @param key 缓存的键
     * @param value 缓存的值
     * @param <V> 值的类型
     */
    @Override
    public <V> void put(String key, V value) {
        redissonClient.getBucket(key).set(value);
    }

    /**
     * 将值存储到缓存中，并设置生存时间
     * @param key 缓存的键
     * @param value 缓存的值
     * @param timeToLive 缓存的生存时间
     * @param timeUnit 时间单位
     * @param <V> 值的类型
     */
    @Override
    public <V> void put(String key, V value, long timeToLive, TimeUnit timeUnit) {
        RBucket<V> bucket = redissonClient.getBucket(key);
        bucket.set(value, timeToLive, timeUnit);
    }

    /**
     * 从缓存中获取值
     * @param key 缓存的键
     * @param <V> 值的类型
     * @return 缓存的值，如果不存在则返回null
     */
    @Override
    public <V> V get(String key) {
        RBucket<V> bucket = redissonClient.getBucket(key);
        return bucket.get();
    }

    /**
     * 从缓存中删除键值对
     * @param key 缓存的键
     * @return 如果删除成功则返回true，否则返回false
     */
    @Override
    public boolean delete(String key) {
        return redissonClient.getBucket(key).delete();
    }
}
