package com.data.algo.relation;

class Animal {
    protected Animal() {  // only accessible by subclasses or same package
        System.out.println("Animal constructor");
    }
}

class Dog extends Animal {
    public Dog() {
        super(); // ✅ allowed
        System.out.println("Dog constructor");
    }
}

public class Test {
    public static void main(String[] args) {
        // Animal a = new Animal(); ❌ Not allowed outside package
        Dog d = new Dog(); // ✅ Works
    }
}
