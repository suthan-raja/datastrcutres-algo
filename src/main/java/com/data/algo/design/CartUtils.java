package com.data.algo.design;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Product implements Serializable {
    String name;

    Product(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "'}";
    }
}

class Electronics extends Product {
    Electronics(String name) {
        super(name);
    }
}

class Clothing extends Product {
    Clothing(String name) {
        super(name);
    }
}

public class CartUtils {

    // 1. Restrict only Serializable Products
    public static <T extends Serializable> void saveProduct(T product){
        System.out.println("Saving product " + product);
    }

    // 2. Read Products ( Producer )
    public static void printProducts(List<? extends Product> products){
        System.out.println("----- Product List -----");
        for (Product p : products) {
            System.out.println(p);
        }
    }

    // 3. Add Product ( Consumer )
    public static void addElectronics(List<? super Product> products){
        products.add(new Electronics("Electronics"));
        products.add(new Clothing("Clothing"));
        products.add(new Product("Product"));
        System.out.println("Electronics added! "+ products);
    }

}


class MainApp {
    public static void main(String[] args) {
        Electronics electronics = new Electronics("Electronics");
        Clothing tshirt = new Clothing("Clothing");
        // 1. Save products (T extends Product & Serializable)
        CartUtils.saveProduct(electronics);
        CartUtils.saveProduct(tshirt);

        // 2. Print products (List<? extends Product>)
        List<Product> inventory = new ArrayList<>();
        inventory.add(electronics);
        inventory.add(tshirt);
        CartUtils.printProducts(inventory);

        // 3. Add electronics (List<? super Electronics>)
        List<Product> cart = new ArrayList<>();
        CartUtils.addElectronics(cart);
        CartUtils.printProducts(cart);

        List<Object> objects = new ArrayList<>();
        objects.add(electronics);
        objects.add(tshirt);
        objects.add("inventory");
        objects.add(1);
        objects.add(null);
        objects.add(0.5);
        objects.add(1l);
    }
}
