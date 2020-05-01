package com.cloudplatform.examplebusiness.swaggertodoc.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName:Response
 * @Description:
 * @Author: WuDG
 * @Date:2020/3/30 16:36
 * @Version: V1.0
 * @since: JDK 1.8
 **/
@Data
public class Response implements Serializable{

    /**
     * 返回参数
     */
    private String description;

    /**
     * 参数名
     */
    private String name;

    /**
     * 备注
     */
    private String remark;
}