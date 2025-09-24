package com.data.algo.relation;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindNonRepeatingCharacters {
    public static void main(String[] args) {
        String java = "gsa king king".trim();

        LinkedHashMap<Character, Integer> first = new LinkedHashMap<>();
        for (int i = 0; i < java.length(); i++) {
            if (java.charAt(i) == 32) {
                continue;
            }
            if (first.containsKey(java.charAt(i))) {
                first.put(java.charAt(i), first.get(java.charAt(i)) + 1);
            } else {
                first.put(java.charAt(i), 1);
            }
        }

        for (Map.Entry<Character, Integer> val : first.entrySet()) {
            if (val.getValue() == 1) {
                System.out.println(val.getKey());
//                break;
            }
        }

        String str = "ava";

        Stream<Character> charS = str.chars()
                .mapToObj(c -> (char) c);

        Optional<Character> s = charS
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(ss -> ss.getValue() == 1).map(Map.Entry::getKey).findFirst();

        s.ifPresentOrElse(System.out::println, () -> System.out.println(" NOT FOUND"));


        //        java.chars().mapToObj(j -> (char)j).
        /*for (int i = 0; i < java.length(); i++) {
            for (int j = i + 1; j < java.length(); j++) {
                boolean found = false;
                if(java.charAt(i) == java.charAt(j)) {
                    found = true;
                    break;

                }
                if(!found) {
                    System.out.println(java.charAt(i));
                }

            }
        }*/
    }
}
