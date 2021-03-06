package com.cloudplatform.basebusinessserver.config;

/**
 * @ClassName:Swagger2
 * @Description:
 * @Author: WuDG
 * @Date:2020/3/30 12:01
 * @Version: V1.0
 * @since: JDK 1.8
 **/
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cloudplatform.examplebusinessconsumer"))
                .paths(PathSelectors.any())
                .build();
    }



    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("WUDG 后台服务接口API，公众号:nizhou0518")
                .description("各类接口信息")
                .termsOfServiceUrl("http://localhost:8042/swagger-ui.html")
                .version("1.0")
                .build();
    }

}