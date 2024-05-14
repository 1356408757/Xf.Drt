package com.trust.xfyl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 异步配置类，用于配置异步任务的执行。
 *
 * @author Bay-max
 * @date 2024/4/22 14:01
 **/
@Configuration
public class AsyncConfig implements WebMvcConfigurer {

    /**
     * 创建并配置一个线程池任务执行器。
     *
     * @return 配置好的ThreadPoolTaskExecutor实例。
     */
    @Bean(name = "threadPoolTaskExecutor")
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 配置核心线程数，根据实际情况调整
        executor.setCorePoolSize(5);
        // 配置最大线程数，根据实际情况调整
        executor.setMaxPoolSize(10);
        // 配置队列容量，根据实际情况调整
        executor.setQueueCapacity(200);
        // 配置线程名称前缀
        executor.setThreadNamePrefix("async-thread-");
        // 设置线程池中超出可用线程和队列容量的任务的处理策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

    /**
     * 配置异步支持，将自定义的线程池任务执行器应用到异步处理中。
     *
     * @param configurer 异步支持配置器
     */
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setTaskExecutor(taskExecutor());
    }

    /**
     * 增加了异常处理的异步执行器服务
     * @return 配置好的ExecutorService实例
     */
    @Bean
    public ExecutorService executorService() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 配置线程池参数...
        executor.initialize();
        // 返回真正的ExecutorService实例
        return executor.getThreadPoolExecutor();
    }
}
