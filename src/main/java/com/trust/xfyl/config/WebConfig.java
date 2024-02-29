package com.trust.xfyl.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/*
*
* @Author djj
* @Description //TODO
* @Date 13:23 2024/2/19
* @Param
* @return
*
*/

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

 @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:63342") // 允许的源，可以是具体的URL或通配符，比如 "*"
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 允许的方法
                .allowedHeaders("*"); // 允许的请求头
    }
}
