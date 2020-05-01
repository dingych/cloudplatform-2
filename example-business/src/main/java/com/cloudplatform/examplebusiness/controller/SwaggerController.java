package com.cloudplatform.examplebusiness.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName:SwaggerController
 * @Description:
 * @Author: WuDG
 * @Date:2020/3/30 12:11
 * @Version: V1.0
 * @since: JDK 1.8
 **/
@Api(value = "swagger", description = "swagger接口",tags = {"swagger路径接口"})
@Controller
@Slf4j
public class SwaggerController {

    @ApiOperation(value = "swagger api页面", notes = "跳转到swagger页面",response = String.class)
    @RequestMapping(value = "/swagger",method = RequestMethod.GET)
    public String index() {
        log.info("swagger-ui.html");
        return "redirect:swagger-ui.html";
    }
}
