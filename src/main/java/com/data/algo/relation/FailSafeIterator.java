package com.data.algo.relation;

import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeIterator {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        for(String str : list){
            System.out.println(str);
            list.add("F");
        }

//        Collections.syn

        System.out.println(list);
    }
}
