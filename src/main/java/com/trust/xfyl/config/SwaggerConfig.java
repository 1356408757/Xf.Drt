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
 * Swagger 接口文档配置类，用于配置Swagger的相关信息，并启用Swagger2。
 *
 * @author Bay-max
 * @date 2024/4/22 14:01
 **/
@EnableSwagger2
@Configuration
public class SwaggerConfig extends WebMvcConfigurationSupport {

    // Swagger配置常量，包括基础包路径、服务URL、Swagger UI路径等
    private static final String BASE_PACKAGE = "com.trust.xfyl.controller";
    private static final String SERVICE_URL = "http://localhost:8089/";
    private static final String SWAGGER_UI_PATH = "/swagger-ui.html";
    private static final String WEBJARS_PATH = "/webjars/**";
    private static final String DOC_HTML_PATH = "doc.html";
    private static final String CLASSPATH_STATIC = "classpath:/static/";

    /**
     * 创建REST API的Docket Bean。
     *
     * @return Docket配置实例
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 设置扫描的API基础包
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                // 扫描使用@Api注解的控制器
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build()
                // 添加登录认证配置
                // 请在application.yml中配置相关的安全信息
                /* .securitySchemes(securitySchemes())*/
                .securityContexts(securityContexts());
    }

    /**
     * 创建RequestMappingInfoHandlerMapping Bean，用于处理请求映射。
     *
     * @return RequestMappingInfoHandlerMapping实例
     */
    @Bean
    public RequestMappingInfoHandlerMapping requestMapping() {
        return new RequestMappingHandlerMapping();
    }

    /**
     * 配置Swagger的API信息。
     *
     * @return ApiInfo实例，包含API的标题、描述、版本等信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("信芙醫療")
                .description("接口文檔-api")
                .termsOfServiceUrl(SERVICE_URL)
                .version("1.0.0")
                .build();
    }

    /**
     * 配置静态资源和Swagger资源的访问路径。
     *
     * @param registry 资源注册表
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 配置静态资源访问
        registry.addResourceHandler("/**")
                .addResourceLocations(CLASSPATH_STATIC);

        // 配置Swagger UI资源访问
        registry.addResourceHandler(SWAGGER_UI_PATH)
                .addResourceLocations("classpath:/META-INF/resources/");

        // 配置Swagger的WebJars资源访问
        registry.addResourceHandler(WEBJARS_PATH)
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        // 配置Swagger Bootstrap UI资源访问
        registry.addResourceHandler(DOC_HTML_PATH)
                .addResourceLocations("classpath:/META-INF/resources/");
    }

    /**
     * 配置Swagger的请求头信息（ApiKey）。
     *
     * @return 包含请求头信息的ApiKey列表
     */
    private List<ApiKey> securitySchemes() {
        // 设置请求头中的Authorization信息
        List<ApiKey> result = new ArrayList<>();
        ApiKey apiKey = new ApiKey("Authorization", "Authorization", "header");
        result.add(apiKey);
        return result;
    }

    /**
     * 配置需要认证的路径。
     *
     * @return 安全上下文列表，指定需要认证的路径
     */
    private List<SecurityContext> securityContexts() {
        // 设置需要通过"Authorization"认证的路径
        List<SecurityContext> result = new ArrayList<>();
        result.add(getContextByPath());
        return result;
    }

    /**
     * 获取安全上下文，指定哪些路径需要认证。
     *
     * @return SecurityContext实例，包含认证信息
     */
    private SecurityContext getContextByPath() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/.*"))
                .build();
    }

    /**
     * 获取默认的认证信息。
     *
     * @return 包含认证范围的SecurityReference列表
     */
    private List<SecurityReference> defaultAuth() {
        List<SecurityReference> result = new ArrayList<>();
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        result.add(new SecurityReference("Authorization", authorizationScopes));
        return result;
    }
}
