package com.data.algo.relation;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<Integer> supplier = () -> new Random().nextInt(100);
        System.out.println(supplier.get());
        System.out.println(supplier.get());
    }
}
