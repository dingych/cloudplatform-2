package com.cloudplatform.smsservice.enums;

import lombok.Getter;
/**
 *
 *@description:
 *@author: WuDG
 *@time: 2020/4/24 11:27
 *
 */
@Getter
public enum SmsTemplateEnum {

    login("SMS_186578569"),
    undefined("100");

    private String code;

    SmsTemplateEnum(String code){
        this.code = code;
    }

    public static SmsTemplateEnum getValue(String name){
        for(SmsTemplateEnum sms : values()){
            if(sms.name().equals(name)){
                return sms;
            }
        }
        return undefined;
    }
}
