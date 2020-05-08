package com.cloudplatform.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName:HelloController
 * @Description:
 * @Author: WuDG
 * @Date:2020/5/7 9:11
 * @Version: V1.0
 * @since: JDK 1.8
 **/
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
