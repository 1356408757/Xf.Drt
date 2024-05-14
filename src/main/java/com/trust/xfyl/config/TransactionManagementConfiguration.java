package com.trust.xfyl.config;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

/**
 * 事务配置类
 *
 * @author Bay-max
 * @date 2024/4/22 14:01
 **/
@Configuration // 表示这是一个配置类，等同于Spring XML配置文件中的<beans>标签
@EnableTransactionManagement // 启用事务管理，等同于在XML配置中使用<tx:annotation-driven/>标签
public class TransactionManagementConfiguration implements TransactionManagementConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(TransactionManagementConfiguration.class);
    private final DataSource dataSource;

    public TransactionManagementConfiguration(DataSource dataSource) {
        if (dataSource == null) {
            String errorMsg = "DataSource cannot be null. Please provide a valid DataSource.";
            logger.error(errorMsg);
            throw new IllegalArgumentException(errorMsg);
        }
        this.dataSource = dataSource;
    }

    /**
     * 返回一个平台事务管理器，用于处理基于注解的事务。
     *
     * @return PlatformTransactionManager
     **/
    @Override
    public @NotNull PlatformTransactionManager annotationDrivenTransactionManager() {
        try {
            return new DataSourceTransactionManager(dataSource);
        } catch (IllegalArgumentException | IllegalStateException e) {
            // 捕获并记录可能的异常，然后重新抛出，以便调用者能够处理
            String errorMsg = "Failed to create DataSourceTransactionManager instance.";
            logger.error(errorMsg, e);
            throw new RuntimeException(errorMsg, e);
        }
    }
}
