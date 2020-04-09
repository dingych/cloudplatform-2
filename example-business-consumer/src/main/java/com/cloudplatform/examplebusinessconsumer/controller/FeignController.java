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
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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
public class FeignController {
    private static Logger log = Logger.getLogger(FeignController.class);
    @Autowired
    private ExampleFeign exampleFeign;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/businessOne")
    public R businessOne(@RequestParam("id") Integer id){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("business");
        log.info("负载均衡:"+serviceInstance.getServiceId()+","+ serviceInstance.getHost()+","+ serviceInstance.getPort());
        return exampleFeign.selectOne(id);
    }
}
