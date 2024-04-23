package com.trust.xfyl.config;


import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger 接口文档配置类
 * @author Bay-max
 * @date 2024/4/22 14:01
 **/

@EnableSwagger2
@Configuration
public class SwaggerConfig extends WebMvcConfigurationSupport {


    //配置扫描的api控制包路径 这里配置的是你后端框架controller类对应的路径

    private static final String BASE_PACKAGE = "com.trust.xfyl.controller";


    //服务器路径 代码部署服务的路径，选添，可以不写

    private static final String SERVICE_URL = "xxxxxxxxx";

    /**
     * @return springfox.documentation.spring.web.plugins.Docket
     * @Author djj
     * @Description //TODO
     * @Date 15:59 2024/1/25
     * @Param []
     **/
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()

                // 设置扫描基础包
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))

                // 扫描使用Api注解的控制器
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build()

                //添加登录认证
                //这里下面两行代码已经相关下面包可以注释掉，这里是配置的Swagger文档登录验证，需要在application.yml文件中进行相关的配置，配置信息见后面详细情况
                /*  .securitySchemes(securitySchemes())*/
                .securityContexts(securityContexts());

    }

    @Bean
    public RequestMappingInfoHandlerMapping requestMapping() {
        return new RequestMappingHandlerMapping();
    }

    /**
     * @return springfox.documentation.service.ApiInfo
     * @Author djj
     * @Description //TODO
     * @Date 15:59 2024/1/25
     * @Param []
     **/
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()

                // 页面标题(自由发挥)
                .title("信芙醫療")

                // API描述
                .description("接口文檔-api")

                // 创建路径
                .termsOfServiceUrl(SERVICE_URL)
                .version("1.0.0")
                .build();


    }


    /**
     * @Author djj
     * @Description 解决 swagger 静态资源 404问题
     * @Date 15:58 2024/1/25
     * @Param [registry]
     **/
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {

        // 解决静态资源无法访问
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");

        // 解决swagger无法访问
        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        // 解决swagger的js文件无法访问
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        // 解决swagger-bootstrap 无法访问
        registry.addResourceHandler("doc.html").
                addResourceLocations("classpath:/META-INF/resources/");
    }

    /**
     * @return java.util.List<springfox.documentation.service.ApiKey>
     * @Author djj
     * @Description //TODO
     * @Date 15:58 2024/1/25
     * @Param []
     **/
    private List<ApiKey> securitySchemes() {
        //设置请求头信息
        List<ApiKey> result = new ArrayList<>();
        ApiKey apiKey = new ApiKey("Authorization", "Authorization", "header");
        result.add(apiKey);
        return result;
    }

    /**
     * @return java.util.List<springfox.documentation.spi.service.contexts.SecurityContext>
     * @Author djj
     * @Description //TODO
     * @Date 15:58 2024/1/25
     * @Param []
     **/
    private List<SecurityContext> securityContexts() {
        //设置需要登录认证的路径
        List<SecurityContext> result = new ArrayList<>();

        // 所有请求路径
        result.add(getContextByPath("/.*"));
        return result;
    }

    /**
     * @return springfox.documentation.spi.service.contexts.SecurityContext
     * @Author djj
     * @Description //TODO
     * @Date 15:58 2024/1/25
     * @Param [pathRegex]
     **/
    private SecurityContext getContextByPath(String pathRegex) {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex(pathRegex))
                .build();
    }

    /**
     * @return java.util.List<springfox.documentation.service.SecurityReference>
     * @Author djj
     * @Description //TODO
     * @Date 15:58 2024/1/25
     * @Param []
     **/
    private List<SecurityReference> defaultAuth() {
        List<SecurityReference> result = new ArrayList<>();
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        result.add(new SecurityReference("Authorization", authorizationScopes));
        return result;
    }


}

