package com.data.algo.relation;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class Product {
    String name;
    double price;
    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() { return name; }
    public double getPrice() { return price; }
}

public class FunctionalInterfacesExample {
    public static void main(String[] args) {
        // 1. Supplier → Provides initial data
        Supplier<List<Product>> productSupplier = () -> Arrays.asList(
            new Product("Laptop", 1200),
            new Product("Mouse", 25),
            new Product("Keyboard", 75),
            new Product("Monitor", 300),
            new Product("USB Cable", 10)
        );

        // 2. Predicate → Expensive product filter
        Predicate<Product> isExpensive = p -> p.getPrice() > 100;

        // 3. Function → Transform product into discount message
        Function<Product, String> discountMessage = p -> 
            "Special Offer: " + p.getName() + " now at $" + (p.getPrice() * 0.9);

        // 4. Consumer → Print final result
        Consumer<String> printer = msg -> System.out.println(msg);

        // Stream pipeline using all four
        productSupplier.get().stream()       // Supplier provides data
            .filter(isExpensive)             // Predicate filters expensive products
            .map(discountMessage)            // Function transforms product → string
            .forEach(printer);               // Consumer prints result
    }
}
