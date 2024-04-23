package com.trust.xfyl.cache;

import java.util.concurrent.TimeUnit;

/**
 * 缓存管理器接口，提供缓存的添加、获取和删除操作。
 * @author Bay-max
 * @date 2024/4/22 14:01
 **/
public interface CacheManager {
    /**
     * 添加缓存。
     *
     * @param key   缓存的键。
     * @param value 缓存的值。
     * @param <V>   缓存值的类型。
     */
    public <V> void put(String key, V value);

    /**
     * 添加带过期时间的缓存。
     *
     * @param key        缓存的键。
     * @param value      缓存的值。
     * @param timeToLive 缓存的过期时间。
     * @param timeUnit   时间单位。
     * @param <V>        缓存值的类型。
     */
    public <V> void put(String key, V value, long timeToLive, TimeUnit timeUnit);

    /**
     * 获取缓存。
     *
     * @param key 缓存的键。
     * @param <V> 结果的类型。
     * @return 缓存的值，如果不存在则返回null。
     */
    public <V> V get(String key);

    /**
     * 删除缓存。
     *
     * @param key 缓存的键。
     * @return 如果删除成功则返回true，否则返回false。
     */
    public boolean delete(String key);
}
