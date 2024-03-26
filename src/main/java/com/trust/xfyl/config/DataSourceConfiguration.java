package com.trust.xfyl.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

/**
 * 数据库配置类
 *
 * @author LENOVO
 */
@Configuration
@MapperScan("com.trust.xfyl.dao")
public class DataSourceConfiguration {

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
     *
     * @return com.mchange.v2.c3p0.ComboPooledDataSource 返回一个配置好的ComboPooledDataSource实例。
     * @Author djj
     * @Description 创建数据源，配置数据库连接的驱动类、URL、用户名和密码。
     * @Date 15:57 2024/1/25
     * @Param [] 无参数。
     **/
    @Bean(name = "dataSource")
    public ComboPooledDataSource createDataSouce() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        // 配置数据库连接池的基本属性
        dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbcUsername);
        dataSource.setPassword(jdbcPassword);
        // 配置连接关闭时不自动提交，以控制事务
        dataSource.setAutoCommitOnClose(false);
        return dataSource;
    }

}