package com.cloudplatform.redisserver.controller;/**
 * @ClassName:RedisController
 * @Description:
 * @Author: WuDG
 * @Date:2020/4/9 21:59
 * @Version: V1.0
 * @since: JDK 1.8
 **/

import com.alibaba.fastjson.JSON;
import com.cloudplatform.redisserver.utils.RedisUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    private static Logger log = Logger.getLogger(RedisController.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/get")
    public String get(@RequestParam("key") String key){
        Object obj = redisTemplate.opsForValue().get(key);
        log.info(obj);
        return JSON.toJSONString(obj);
    }

    @GetMapping("/set")
    public String set(@RequestParam("key") String key, @RequestParam("value") String value){
        log.info("value:"+value);
        redisTemplate.opsForValue().set(key,value);
        return value;
    }
}
