package com.cloudplatform.smsservice.dto;

import com.cloudplatform.smsservice.enums.SmsSignEnum;
import com.cloudplatform.smsservice.enums.SmsTemplateEnum;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

@Data
public class SmsDto implements Serializable {

    /**
     * 电话
     */
    private String phone;

    /**
     * 短信模板
     */
    private String template;

    /**
     * 来自于哪个系统
     */
    private String system;

    /**
     * 校验参数
     * @return
     */
    public Boolean valid(){
        if(StringUtils.isBlank(phone)){
            return false;
        }
        if(StringUtils.isBlank(template)){
            return false;
        }else{
            if(SmsTemplateEnum.undefined.getCode().equals(SmsTemplateEnum.getValue(template).getCode())){
                return false;
            }
        }
        if(StringUtils.isBlank(system)){
            return false;
        }else{
            if(SmsSignEnum.undefined.getSignName().equals(SmsSignEnum.getValue(system).getSignName())){
                return false;
            }
        }
        return true;
    }
}
