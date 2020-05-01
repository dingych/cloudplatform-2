package com.cloudplatform.smsservice.controller;

import com.alibaba.fastjson.JSON;
import com.cloudplatform.common.utils.JsonUtils;
import com.cloudplatform.common.utils.R;
import com.cloudplatform.common.utils.ValidateCodeUtils;
import com.cloudplatform.smsservice.dto.SmsDto;
import com.cloudplatform.smsservice.enums.SmsSignEnum;
import com.cloudplatform.smsservice.enums.SmsTemplateEnum;
import com.cloudplatform.smsservice.utils.SmsHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController()
@RequestMapping("/sms")
@Slf4j
public class SmsController {

    @Autowired
    private SmsHelper smsHelper;

    @PostMapping("sendSms")
    public R sendSms(@RequestBody SmsDto smsDto) {
        //获取6位随机验证码
        Integer code = ValidateCodeUtils.generateValidateCode(6);
        String templateName = SmsTemplateEnum.getValue(smsDto.getTemplate()).getCode();
        String signName = SmsSignEnum.getValue(smsDto.getSystem()).getSignName();
        //将验证码存入redis，失效时间为五分钟
        Map<String, Integer> map = new HashMap<>(16);
        map.put("code", code);
        smsHelper.sendMessage(smsDto.getPhone(), signName, templateName, JsonUtils.toString(map));
        return R.ok();
    }
}
