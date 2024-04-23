package com.trust.xfyl.entity.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
/**
 * @author Bay-max
 * @date 2024/4/22 14:01
 **/
@Configuration
@ConfigurationProperties(prefix = "wechat")
@Data
public class WxConfig {
    private String appId;;
    private String appSecret;
}
