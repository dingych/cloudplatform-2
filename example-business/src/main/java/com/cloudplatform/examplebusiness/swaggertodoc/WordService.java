package com.cloudplatform.examplebusiness.swaggertodoc;

/**
 * @ClassName:WordService
 * @Description:
 * @Author: WuDG
 * @Date:2020/3/30 16:42
 * @Version: V1.0
 * @since: JDK 1.8
 **/
import java.util.Map;

/**
 * Created by XiuYin.Cui on 2018/1/12.
 */
public interface WordService {

    Map<String,Object> tableList(String swaggerUrl);
}
