package com.trust.xfyl.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

/**
 * 事务配置类，
 *
 * @author LENOVO
 */
@Configuration
@EnableTransactionManagement
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
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}

