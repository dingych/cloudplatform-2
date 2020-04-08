package com.cloudplatform.examplebusiness;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.cloudplatform.examplebusiness.dao.*")
public class ExampleBusinessApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleBusinessApplication.class, args);
    }

}
