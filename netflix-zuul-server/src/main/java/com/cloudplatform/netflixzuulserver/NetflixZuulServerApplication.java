package com.cloudplatform.netflixzuulserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 *
 *@description: 网关服务
 *@author: WuDG
 *@time: 2020/4/8 21:06
 *
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
public class NetflixZuulServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetflixZuulServerApplication.class, args);
    }

}
