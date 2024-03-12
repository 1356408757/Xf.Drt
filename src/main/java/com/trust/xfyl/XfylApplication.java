package com.trust.xfyl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;




/**
 * @author LENOVO
 */
@EnableScheduling
@EnableSwagger2
@SpringBootApplication(scanBasePackages = "com.trust.xfyl")
public class XfylApplication { 
    public static void main(String[] args) {
        SpringApplication.run(XfylApplication.class, args);
    }

}
