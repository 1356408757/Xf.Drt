package com.trust.xfyl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 异步配置类，用于配置异步任务的执行。
 * @author Bay-max
 * @date 2024/4/22 14:01
 **/
@Configuration
public class AsyncConfig implements WebMvcConfigurer {

    /**
     * 创建并配置一个线程池任务执行器。
     * @return 配置好的ThreadPoolTaskExecutor实例。
     */
    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 配置核心线程数
        executor.setCorePoolSize(2);
        // 配置最大线程数
        executor.setMaxPoolSize(5);
        // 配置队列容量
        executor.setQueueCapacity(100);
        // 配置线程名称前缀
        executor.setThreadNamePrefix("async-thread-");
        executor.initialize();
        return executor;
    }

    /**
     * 配置异步支持，将自定义的线程池任务执行器应用到异步处理中。
     * @param configurer 异步支持配置器
     */
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setTaskExecutor(taskExecutor());
    }
}
