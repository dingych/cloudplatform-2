package com.cloudplatform.common.utils.excel;

/**
 * @ClassName:DemoData
 * @Description:
 * @Author: WuDG
 * @Date:2020/5/12 14:29
 * @Version: V1.0
 * @since: JDK 1.8
 **/

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 基础数据类
 *
 * @author Jiaju Zhuang
 **/
@Data
public class DemoData {
    @ExcelProperty("字符串标题")
    private String string;
    @ExcelProperty("日期标题")
    private Date date;
    @ExcelProperty("数字标题")
    private Double doubleData;
    /**
     * 忽略这个字段
     */
    @ExcelIgnore
    private String ignore;
}
