package com.data.algo.inter;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Testi {
    public static void main(String[] args) {

        String input = "avaV articles are Awesome".toLowerCase();

        LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        for(int i =0; i < input.length(); i++){
            if(map.containsKey(input.charAt(i))){
                map.put(input.charAt(i), map.get(input.charAt(i)) + 1);
            }else{
                map.put(input.charAt(i), 1);
            }
        }
        boolean isGetted = false;
        for(Map.Entry<Character, Integer> map1 : map.entrySet()){
            if(!isGetted && map1.getValue() == 1){
                System.out.print(map1.getKey() + " ");
                isGetted = true;
            }
        }



    }
}
