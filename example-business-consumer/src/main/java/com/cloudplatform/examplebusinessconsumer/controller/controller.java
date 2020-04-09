package com.cloudplatform.examplebusinessconsumer.controller;/**
 * @ClassName:controller
 * @Description:
 * @Author: WuDG
 * @Date:2020/4/9 9:32
 * @Version: V1.0
 * @since: JDK 1.8
 **/

import com.cloudplatform.common.utils.R;
import com.cloudplatform.examplebusinessconsumer.feign.ExampleFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 *@description:简单业务消费接口
 *@author: WuDG
 *@time: 2020/4/9 9:32
 *
 */
@RestController
public class controller {

    @Autowired
    private ExampleFeign exampleFeign;

    @GetMapping("/businessOne")
    public R businessOne(@RequestParam("id") Integer id){
        return exampleFeign.selectOne(id);
    }
}
