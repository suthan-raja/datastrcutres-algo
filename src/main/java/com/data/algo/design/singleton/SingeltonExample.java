package com.data.algo.design.singleton;

public class SingeltonExample {

    private static SingeltonExample instance;

    private SingeltonExample() {

    }

    public static SingeltonExample getInstance() {
        if(instance == null) {
            instance = new SingeltonExample();
        }
        return instance;
    }
}

class Example {
    public static void main(String[] args) {
        SingeltonExample singeltonExample = SingeltonExample.getInstance();
        System.out.println(singeltonExample);
        SingeltonExample singeltonExample2 = SingeltonExample.getInstance();
        System.out.println(singeltonExample2);

        if(singeltonExample == singeltonExample2) {
            System.out.println("SingeltonExample == singeltonExample2");
        }
    }
}


