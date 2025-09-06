package com.data.algo.relation;

import java.util.ArrayList;
import java.util.List;

public class FailFastIterator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        for(String str : list){
            System.out.println(str);
//            list.remove(str);
            list.add("F");
        }
    }
}
