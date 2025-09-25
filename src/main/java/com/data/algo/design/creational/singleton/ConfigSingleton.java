package com.data.algo.design.creational.singleton;

import java.util.HashMap;

public class ConfigSingleton {

    private static ConfigSingleton instance;
    private final HashMap<String, String> hashMap;

    private ConfigSingleton() {
        hashMap = new HashMap<>();
        hashMap.put("appName", "MyApplication");
        hashMap.put("version", "1.0");
        System.out.println("ConfigManager created!");
    }

    public static ConfigSingleton getInstance() {
        if (instance == null) {
            instance = new ConfigSingleton();
        }
        return instance;
    }

    public String getKey(String key) {
        return hashMap.get(key);
    }

}

class Config {
    public static void main(String[] args){
        ConfigSingleton config1 = ConfigSingleton.getInstance();
        ConfigSingleton config2 = ConfigSingleton.getInstance();
        System.out.println("App Name: " + config1.getKey("appName"));
        System.out.println("Version: " + config2.getKey("version"));
    }

}