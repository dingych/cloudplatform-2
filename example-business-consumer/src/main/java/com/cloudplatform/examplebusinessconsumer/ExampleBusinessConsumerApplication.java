package com.cloudplatform.examplebusinessconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = { "com.cloudplatform.examplebusinessconsumer.feign" })
public class ExampleBusinessConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleBusinessConsumerApplication.class, args);
    }

}
