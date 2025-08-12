package com.data.algo.something;

import org.springframework.stereotype.Service;

@Service
public class ServiceA {
    public ServiceA() {
        System.out.println("[ServiceA] Constructor");
    }
    public void doWork() {
        System.out.println("[ServiceA] Doing work");
    }
}
