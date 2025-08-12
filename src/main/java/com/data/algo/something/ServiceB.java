package com.data.algo.something;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceB {
    private final ServiceA serviceA;

    @Autowired
    public ServiceB(ServiceA serviceA) {
        System.out.println("[ServiceB] Constructor - Autowired ServiceA");
        this.serviceA = serviceA;
    }
}
