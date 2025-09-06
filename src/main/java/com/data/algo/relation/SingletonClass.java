package com.data.algo.relation;

public class SingletonClass {

    private SingletonClass(){

    }

    private final static SingletonClass instance = new SingletonClass();

    public static SingletonClass getInstance(){
        return instance;
    }
}

class SingletonExample {
    SingletonClass s1 = SingletonClass.getInstance();
    SingletonClass s2 = SingletonClass.getInstance();

    public static void main(String[] args) {
        SingletonClass s1 = SingletonClass.getInstance();
        SingletonClass s2 = SingletonClass.getInstance();

        System.out.println(s1==s2);
    }
}
