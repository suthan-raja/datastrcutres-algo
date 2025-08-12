package com.data.algo.something;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class LifecycleBean implements InitializingBean {

    public LifecycleBean() {
        System.out.println("[LifecycleBean] Constructor");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("[LifecycleBean] @PostConstruct called");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("[LifecycleBean] afterPropertiesSet() called");
    }
}
