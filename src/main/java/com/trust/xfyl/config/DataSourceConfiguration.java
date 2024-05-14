package com.trust.xfyl.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

/**
 * 数据库配置类，用于配置数据源和相关属性。
 *
 * @author Bay-max
 * @date 2024/4/22 14:01
 **/
@Configuration
@MapperScan("com.trust.xfyl.dao")
public class DataSourceConfiguration {

    // 通过注入的方式获取数据库连接的配置属性
    @Value("${spring.datasource.driverClassName}")
    private String jdbcDriver;
    @Value("${spring.datasource.url}")
    private String jdbcUrl;
    @Value("${spring.datasource.username}")
    private String jdbcUsername;
    @Value("${spring.datasource.password}")
    private String jdbcPassword;

    /**
     * 创建并配置ComboPooledDataSource数据源。
     * 使用注入的数据库连接属性来配置数据源，提供数据库连接池的功能。
     *
     * @return com.mchange.v2.c3p0.ComboPooledDataSource 返回一个配置好的ComboPooledDataSource实例。
     * @author Bay-max
     * @date 2024/4/22 14:01
     **/
    @Bean(name = "dataSource")
    public ComboPooledDataSource createDataSouce() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        // 设置数据库连接池的基本属性
        // 设置驱动类名
        dataSource.setDriverClass(jdbcDriver);
        // 设置数据库连接URL
        dataSource.setJdbcUrl(jdbcUrl);
        // 设置用户名
        dataSource.setUser(jdbcUsername);
        // 设置密码
        dataSource.setPassword(jdbcPassword);
        // 配置连接关闭时不自动提交，以控制事务
        dataSource.setAutoCommitOnClose(false);
        return dataSource;
    }

}
