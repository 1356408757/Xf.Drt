package com.trust.xfyl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Xfyl应用的主入口类。此类负责启动Spring Boot应用，并启用了定时任务调度和Swagger2用于API文档。
 * 注意：为了增强安全性，应确保Swagger接口仅对授权用户可见。同时，推荐使用最新的Swagger版本。
 *
 * @author Bay-max
 * @date 2024/4/22 15:39
 * @EnableScheduling 启用定时任务调度
 * @EnableSwagger2 启用Swagger2用于API文档。建议配置合适的访问权限，避免未授权访问。
 * @SpringBootApplication 扫描包路径为"com.trust.xfyl"，启动Spring Boot应用
 */
@EnableScheduling
@EnableSwagger2
@SpringBootApplication(scanBasePackages = {"com.trust.xfyl"})
public class XfylApplication {
    private static final Logger logger = LoggerFactory.getLogger(XfylApplication.class);
    /**
     * 应用的启动入口方法。此方法使用SpringApplication.run启动Spring Boot应用。
     * 建议在应用运行时，尤其是在定时任务和其他可能抛出异常的逻辑中，加入适当的异常处理。
     *
     * @param args 命令行传入的参数
     */
    public static void main(String[] args) {

        try {
            SpringApplication.run(XfylApplication.class, args);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            System.exit(1);
        }
    }

}
