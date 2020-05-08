package com.cloudplatform.common.exception;

/**
 * @ClassName:BaseErrorInfoInterface
 * @Description:
 * @Author: WuDG
 * @Date:2020/5/8 9:20
 * @Version: V1.0
 * @since: JDK 1.8
 **/
public interface BaseErrorInfoInterface {
    /** 错误码*/
    String getResultCode();

    /** 错误描述*/
    String getResultMsg();
}