package com.trust.xfyl.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * 数据库sqlSession配置类
 *
 * @author LENOVO
 */

@Configuration
public class SessionFactoryConfiguration {
    private final DataSource dataSource;
    /**
     * mybatis mapper文件所在路径
     */
    @Value("${mybatis.mapper-locations}")
    private String mapperPath;
    /**
     * mybatis-config.xml配置文件的路径
     */
    @Value("${mybatis.mybatis-config-file}")
    private String mybatisConfigFilePath;
    /**
     * 实体类所在的package
     */
    @Value("${mybatis.type-aliases-package}")
    private String entityPackage;

    public SessionFactoryConfiguration(@Qualifier("dataSource") DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * @return org.mybatis.spring.SqlSessionFactoryBean
     * @Author djj
     * @Description //TODO
     * @Date 15:58 2024/1/25
     * @Param []
     **/
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // 扫描mybatis配置文件
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));
        // 扫描相关mapper文件
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath));
        // 调用dataSource
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 映射实体类
        sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);
        return sqlSessionFactoryBean;
    }

}


