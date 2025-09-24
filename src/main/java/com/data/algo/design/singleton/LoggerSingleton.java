package com.data.algo.design.singleton;

public class LoggerSingleton {

    private static LoggerSingleton instance;

    private LoggerSingleton() {

    }

    public static LoggerSingleton getInstance() {
        if (instance == null) {
            instance = new LoggerSingleton();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}

class Logger {
    public static void main(String[] args) {
        LoggerSingleton singleton = LoggerSingleton.getInstance();
        LoggerSingleton singleton2 = LoggerSingleton.getInstance();

        singleton.log("Application started");
        singleton2.log("Application running");

        System.out.println(singleton == singleton2);
    }
}
