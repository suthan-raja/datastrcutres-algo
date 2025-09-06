package com.data.algo.relation;


public class Car {
    void engine(){
        System.out.println("Engine is running");
    }

    static void staticEngine(){
        System.out.println("Static Engine is running");
    }
}

class Mustang extends Car {
    void engine(){
        System.out.println("Mustang Engine is running");
    }

    static void staticEngine(){
        System.out.println("Mustang Static Engine is running");
    }

    int errorFinally(){
        try{
            return 100/0;
        }finally{
            return 0;
        }
    }

    public static void main(String[] args){
        /*Mustang m = new Mustang();
        m.engine();
        m.staticEngine();

        Car mus = new Mustang(); // mus . parent() ( COMPILE TIME ) _ mus.child()_ RUN_TIME
        mus.engine();
        mus.staticEngine();

        Mustang.staticEngine();*/

        Mustang mustang = new Mustang();
        System.out.println("FINAL: "+mustang.errorFinally());
    }
}
