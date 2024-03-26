package com.trust.xfyl.util;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * CustomThreadFactory 实现 ThreadFactory，用于创建具有统一命名规范的线程。
 *
 * @Description
 * @Author Bay-max
 * @Date 2024/3/1 14:22
 **/
class CustomThreadFactory implements ThreadFactory {
    private static final Logger LOGGER = Logger.getLogger(CustomThreadFactory.class.getName());
    private static final AtomicInteger THREAD_COUNT = new AtomicInteger(1);

    /**
     * 创建一个新的线程。
     *
     * @param runnable 要在新线程中执行的任务，不能为空。
     * @return 返回一个新创建的线程实例。
     */
    @Override
    public Thread newThread(@NotNull Runnable runnable) {
        // 确保 runnable 不为空
        if (runnable == null) {
            LOGGER.log(Level.SEVERE, "Runnable cannot be null");
            throw new NullPointerException("Runnable cannot be null");
        }
        return new Thread(runnable, "CustomThread-" + THREAD_COUNT.getAndIncrement());
    }

}
