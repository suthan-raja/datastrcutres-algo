package com.data.algo.relation;

import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<Integer> isMajor = s -> s >= 18;
        Predicate<Integer> isMinor = s -> s <= 18;
        System.out.println("S is a Major ( 19 ) : "+ isMajor.test(19));
    }
}
