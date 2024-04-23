package com.trust.xfyl.config;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

/**
 * 事务配置类
 * @author Bay-max
 * @date 2024/4/22 14:01
 **/
@Configuration // 表示这是一个配置类，等同于Spring XML配置文件中的<beans>标签
@EnableTransactionManagement // 启用事务管理，等同于在XML配置中使用<tx:annotation-driven/>标签

public class TransactionManagementConfiguration implements TransactionManagementConfigurer {
    private final DataSource dataSource;

    public TransactionManagementConfiguration(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * @return
     * @Author djj
     * @Description //TODO
     * @Date 16:00 2024/1/25
     * @Param
     **/
    @Override
    public @NotNull PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}

