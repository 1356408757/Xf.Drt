package com.trust.xfyl.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Redis配置类，用于配置连接到Redis服务器的相关属性。
 * 通过注解@ConfigurationProperties指明此配置类对应的属性文件前缀为redis，
 * 即配置文件中所有以redis开头的属性都会被这个类接收并绑定。
 *
 * @author Bay-max
 * @configuration 注解表明这是一个配置类，等同于Spring XML配置文件中的<beans>标签。
 * @data 注解提供了getter和setter方法，以及其他方便的自动生成代码的功能，使得这个类更易使用。
 * @date 2024/4/22 14:01
 **/
@Configuration
@ConfigurationProperties(prefix = "redis")
@Data
public class RedisConfig {
    // Redis服务器的主机名或IP地址
    private String host;

    // Redis服务器的端口号
    private Integer port;

    // 连接Redis服务器所需的密码
    private String password;
}
