package com.data.algo.relation;

import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> consumer = (x) -> System.out.println("Hello, "+ x);
        consumer.accept("world");
    }
}
