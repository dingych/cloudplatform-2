package com.cloudplatform.examplebusiness.swaggertodoc.pojo;

import lombok.Data;

import java.util.List;

/**
 * @ClassName:Table
 * @Description:
 * @Author: WuDG
 * @Date:2020/3/30 16:35
 * @Version: V1.0
 * @since: JDK 1.8
 **/

/**
 * Created by XiuYin.Cui on 2018/1/11.
 */
@Data
public class Table {

    /**
     * 大标题
     */
    private String title;
    /**
     * 小标题
     */
    private String tag;
    /**
     * url
     */
    private String url;

    /**
     * 描述
     */
    private String description;

    /**
     * 请求参数格式
     */
    private String requestForm;

    /**
     * 响应参数格式
     */
    private String responseForm;

    /**
     * 请求方式
     */
    private String requestType;

    /**
     * 请求体
     */
    private List<Request> requestList;

    /**
     * 返回体
     */
    private List<Response> responseList;

    /**
     * 请求参数
     */
    private String requestParam;

    /**
     * 返回参数
     */
    private String responseParam;

    /**
     * 返回属性列表
     */
    private ModelAttr modelAttr = new ModelAttr();
}