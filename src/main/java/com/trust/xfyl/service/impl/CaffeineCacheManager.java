package com.trust.xfyl.service.impl;

import com.github.benmanes.caffeine.cache.Cache;
import com.trust.xfyl.service.CacheManager;

import java.util.concurrent.TimeUnit;

/**
 * Caffeine缓存管理器实现类，封装了Caffeine的缓存操作
 *
 * @author Bay-max
 * @date 2024/4/22 14:01
 **/
public class CaffeineCacheManager implements CacheManager {
    // Caffeine缓存实例
    private final Cache<Object, Object> cache;

    /**
     * 构造函数
     *
     * @param cache Caffeine缓存实例
     */
    public CaffeineCacheManager(Cache<Object, Object> cache) {
        this.cache = cache;
    }

    /**
     * 将键值对存入缓存
     *
     * @param key   缓存的键
     * @param value 缓存的值
     * @param <V>   缓存值的类型
     */
    @Override
    public <V> void put(String key, V value) {
        cache.put(key, value);
    }

    /**
     * 将键值对存入缓存，并设定生存时间
     *
     * @param key        缓存的键
     * @param value      缓存的值
     * @param timeToLive 缓存的生存时间
     * @param timeUnit   时间单位
     * @param <V>        缓存值的类型
     */
    @Override
    public <V> void put(String key, V value, long timeToLive, TimeUnit timeUnit) {
        cache.put(key, value);
    }

    /**
     * 通过键获取缓存的值
     *
     * @param key 缓存的键
     * @param <V> 缓存值的类型
     * @return 缓存的值，如果不存在则返回null
     */
    @SuppressWarnings("unchecked")
    @Override
    public <V> V get(String key) {
        return (V) cache.getIfPresent(key);
    }

    /**
     * 通过键删除缓存条目
     *
     * @param key 缓存的键
     * @return 删除操作是否成功
     */
    @Override
    public boolean delete(String key) {
        cache.invalidate(key);
        return true;
    }
}
