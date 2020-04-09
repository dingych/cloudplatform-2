package com.cloudplatform.examplebusinessconsumer.feign;

import com.cloudplatform.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName:ExampleFeign
 * @Description: Feign远程接口调用案例
 * @Author: WuDG
 * @Date:2020/4/9 9:15
 * @Version: V1.0
 * @since: JDK 1.8
 **/

@FeignClient(value = "business")
public interface ExampleFeign {
    /**
     * feign调用负载均衡测试
     * @param id
     * @return
     */
    @RequestMapping(value = "/tbBuUser/selectOne")
    R selectOne(@RequestParam("id") Integer id);
}
