package com.cloudplatform.cloudconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 *@description: 配置中心
 *@author: WuDG
 *@time: 2020/4/8 21:07
 *
 */

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class CloudConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigApplication.class, args);
    }

}
