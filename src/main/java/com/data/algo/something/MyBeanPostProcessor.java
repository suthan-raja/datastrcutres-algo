package com.data.algo.something;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("serviceA") || beanName.equals("serviceB")){
            System.out.println("[BeanPostProcessor - BeforeInit] " + beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("serviceA") || beanName.equals("serviceB")){
            System.out.println("[BeanPostProcessor - AfterInit] " + beanName);
        }
        return bean;
    }


}
