package com.trust.xfyl.config;

import com.trust.xfyl.util.alibabaCloudTools.LogUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * 自定义跨域配置类
 * @author Bay-max
 * @date 2024/4/22 15:37
 **/
@Configuration
public class CustomizedCorsConfig {
    @Resource
    private SecurityConfig securityConfig; // 引用安全配置类

    /**
     * 创建并配置跨域过滤器
     * @return 跨域过滤器实例
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration config = new CorsConfiguration();
        // 设置允许的请求方法
        config.setAllowedMethods(Arrays.asList("POST", "OPTIONS", "GET"));
        // 设置允许的请求头
        config.setAllowedHeaders(Arrays.asList("Accept", "Content-Type", "Authorization", "x-xsrf-token", "Accept", "x-platform"));
        // 设置允许携带凭证（如cookies）
        config.setAllowCredentials(true);
        // 设置允许的来源，示例中是硬编码的几个允许来源
        config.setAllowedOrigins(securityConfig.getRefererWhitelist());
        // 将跨域配置应用到所有请求
        source.registerCorsConfiguration("/**", config);

        // 返回自定义的跨域过滤器，其中重写了doFilterInternal方法以添加监控逻辑
        return new CorsFilter(source) {
            @Override
            protected void doFilterInternal(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain) throws ServletException, IOException {
                long startTime = System.currentTimeMillis();
                super.doFilterInternal(request, response, filterChain);

                // 如果响应状态码为禁止，则记录相关监控信息
                if (response.getStatus() == HttpServletResponse.SC_FORBIDDEN) {
                    String url = request.getRequestURL().toString();
                    String origin = request.getHeader("Origin");
                    String referer = request.getHeader("Referer");
                    String userAgent = request.getHeader("User-Agent");

                    LogUtils.monitor(null, "CorsFilter", "doFilterInternal", "error", startTime, url, origin, referer, userAgent);
                }
            }
        };
    }
}