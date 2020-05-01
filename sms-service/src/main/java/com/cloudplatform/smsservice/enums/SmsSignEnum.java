package com.cloudplatform.smsservice.enums;

import lombok.Getter;

@Getter
public enum SmsSignEnum {

    Mentor("Matrix天演"),
    undefined("100");

    private String signName;

    SmsSignEnum(String signName){
        this.signName = signName;
    }

    public static SmsSignEnum getValue(String name){
        for(SmsSignEnum sms : values()){
            if(sms.name().equals(name)){
                return sms;
            }
        }
        return undefined;
    }

}
