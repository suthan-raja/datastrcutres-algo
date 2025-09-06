package com.data.algo.relation;

public class CustomUtility {
    private CustomUtility() {

    }

    public static int add(int a, int b) {
        return a + b;
    }
}

class UtilityClass {
    public static void main(String[] args) {
        System.out.println(CustomUtility.add(1, 2));
    }
}
