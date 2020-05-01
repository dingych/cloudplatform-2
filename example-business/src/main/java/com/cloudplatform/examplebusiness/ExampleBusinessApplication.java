package com.cloudplatform.examplebusiness;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 *@description: 简单业务服务提供者
 *@author: WuDG
 *@time: 2020/4/9 12:29
 *
 */
@EnableTransactionManagement
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableSwaggerBootstrapUI
@MapperScan("com.cloudplatform.examplebusiness.dao.*")
public class ExampleBusinessApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleBusinessApplication.class, args);
    }

}
