package com.cloudplatform.examplebusinessconsumer.config;/**
 * @ClassName:FeignBeanFactoryPostProcessor
 * @Description:
 * @Author: WuDG
 * @Date:2020/4/9 9:41
 * @Version: V1.0
 * @since: JDK 1.8
 **/
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
/**
 *
 *@description: 解决未知名bug的配置
 *@author: WuDG
 *@time: 2020/4/9 9:52
 *
 */
@Component
public class FeignBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition bd = beanFactory.getBeanDefinition("feignContext");
        bd.setDependsOn("eurekaServiceRegistry", "inetUtils");
    }

}