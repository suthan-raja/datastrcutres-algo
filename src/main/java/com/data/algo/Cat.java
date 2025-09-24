package com.data.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cat {
    public static void main(String[] args) {
        List<String> sds = new ArrayList<String>();
        HashMap<String, List<String>> sd = new HashMap<>();
        sd.put("agu", sds);
        sds.add("Hello");
        System.out.println(sd.get("agu"));
    }
}
