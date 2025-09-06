package com.data.algo.relation;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<String, Integer> function = String::length;
        System.out.println(function.apply("abc"));
    }
}
