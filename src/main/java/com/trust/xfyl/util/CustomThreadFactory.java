package com.trust.xfyl.util;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ThreadFactory;

/**
 * TODO\\ CustomThreadFactory 实现 ThreadFactory
 *
 * @Description
 * @Param  runnable
 * @Author Bay-max
 * @Date 2024/3/1 14:22
 **/
class CustomThreadFactory implements ThreadFactory {
    private static int threadCount = 1;

    @Override
    public Thread newThread(@NotNull Runnable runnable) {
        Thread thread = new Thread(runnable, "CustomThread-" + threadCount);
        threadCount++;
        return thread;
    }
}
