package com.trust.xfyl.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类，用于加载并处理properties文件中以"chat.app"为前缀的配置属性。
 * 该类定义了应用程序中一些关键配置的初始值，这些配置可以通过properties文件进行动态修改。
 *
 * @Configuration 标注该类为一个配置类，可以被Spring Boot作为配置源。
 * @ConfigurationProperties(prefix = "chat.app") 将该配置类绑定到properties文件中以"chat.app"为前缀的配置上。
 * @data 由Lombok提供，自动生成getter、setter、toString等方法，方便属性的访问和调试。
 */
@Configuration
@ConfigurationProperties(prefix = "chat.app")
@Data
public class AppConfig {
    // 控制台日志打印开关
    public static boolean openTrace;

    // 会话中允许的最大消息数量
    private Integer sessionMaxMessages;

    // 会话的生存时间(TTL)
    private Integer sessionTtl;

    /**
     * 设置日志打印开关。
     *
     * @param openTrace true表示开启日志打印，false表示关闭日志打印。
     */
    public void setOpenTrace(boolean openTrace) {
        AppConfig.openTrace = openTrace;
    }
}
