package com.cloudplatform.examplebusinessconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *
 *@description: 简单业务服务消费者
 *@author: WuDG
 *@time: 2020/4/9 12:29
 *
 */

@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = { "com.cloudplatform.examplebusinessconsumer.feign" })

public class ExampleBusinessConsumerApplication {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(ExampleBusinessConsumerApplication.class, args);
    }

}
