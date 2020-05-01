package com.cloudplatform.netflixzuulserver.config;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:DocumentationConfig
 * @Description:
 * @Author: WuDG
 * @Date:2020/4/30 11:04
 * @Version: V1.0
 * @since: JDK 1.8
 **/
@Component
@Primary
public class DocumentationConfig implements SwaggerResourcesProvider {


    //整合每个微服务的swagger

    @Override

    public List<SwaggerResource> get() {
        List resources = new ArrayList<>();
        //一个 SwaggerResource对应一个微服务 ： 参数： 服务中文名 ， 路径：/zuul前缀/服务的routes访问路径//v2/api-docs  ； 版本
        resources.add(swaggerResource("业务消费服务", "/business-consumer/api-docs", "2.0"));
        resources.add(swaggerResource("业务服务", "/business/api-docs", "2.0"));
        return resources;

    }


    private SwaggerResource swaggerResource(String name, String location, String version) {

        SwaggerResource swaggerResource = new SwaggerResource();

        swaggerResource.setName(name);

        swaggerResource.setLocation(location);

        swaggerResource.setSwaggerVersion(version);

        return swaggerResource;

    }

}