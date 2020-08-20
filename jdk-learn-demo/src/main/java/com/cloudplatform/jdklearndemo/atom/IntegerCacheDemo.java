package com.cloudplatform.jdklearndemo.atom;

import java.util.Objects;

/**
 * @ClassName:IntegerCacheDemo
 * @Description:
 * @Author: WuDG
 * @Date:2020/5/12 18:07
 * @Version: V1.0
 * @since: JDK 1.8
 **/
public class IntegerCacheDemo {
    public static void main(String[] args) {
        test();
    }

    /**
     * 静态测试方法
     */
    public static void test() {
        Integer a = Integer.valueOf(111);
        Integer b = 111;
        Integer c = 129;
        Integer d = 129;
        System.out.println(a.equals(b));
        System.out.println(Objects.equals(c, d));
        System.out.println(Integer.MAX_VALUE + 1);

    }
}
