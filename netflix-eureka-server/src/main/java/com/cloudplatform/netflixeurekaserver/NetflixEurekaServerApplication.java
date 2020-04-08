package com.cloudplatform.netflixeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *
 *@description: 注册中心服务
 *@author: WuDG
 *@time: 2020/4/8 21:06
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class NetflixEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetflixEurekaServerApplication.class, args);
    }

}
