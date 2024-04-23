package com.trust.xfyl.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * TODO
 *
 * @author Bay-max
 * @date 2024/4/22 15:13
 **/

@Configuration
@ConfigurationProperties(prefix = "chat.security")
@Data
public class SecurityConfig {
    // 定义一个白名单，用于过滤非法的来源地址
    private List<String> refererWhitelist;
}

