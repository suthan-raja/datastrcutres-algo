package com.data.algo.multithreading;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        String test = "INDIA";
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < test.length(); i++) {
            if (map.containsKey(test.charAt(i))) {
                map.put(test.charAt(i), map.get(test.charAt(i)) + 1);
            } else {
                map.put(test.charAt(i), 1);
            }
        }
        System.out.println(map);
    }
}
