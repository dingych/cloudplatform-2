package com.cloudplatform.examplebusiness.swaggertodoc;

/**
 * @ClassName:StatusEnum
 * @Description:
 * @Author: WuDG
 * @Date:2020/3/30 17:29
 * @Version: V1.0
 * @since: JDK 1.8
 **/
public enum StatusEnum {
    /**
     * 有效
     */
    EFFECTIVE(0, "已停用"),
    /**
     * 失效
     */
    INVALID(1, "可正常使用");

    private Integer status;

    private String desc;

    StatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return status + ":" + desc;
    }}
