package com.cloudplatform.jdklearndemo.list_op;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName:Main
 * @Description:
 * @Author: WuDG
 * @Date:2020/4/27 9:05
 * @Version: V1.0
 * @since: JDK 1.8
 **/
public class Main {
    public static void main(String[] args) {
        List<Integer> lists = Arrays.asList(1,2,null,4);
        System.out.println(lists);
        for(int i=0;i<lists.size();i++){
            if(i == 2){
                lists.remove(lists.get(i));
            }
        }
        System.out.println(lists);
    }
}
