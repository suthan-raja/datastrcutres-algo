package com.data.algo.inter;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestComparator {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();

        list.add(new Student(3, "Mary"));
        list.add(new Student(2, "Alex"));
        list.add(new Student(1, "John"));

        // Custom ordering: by name
        Comparator<Student> nameComparator = (s1, s2) -> s1.name.compareTo(s2.name);

//        Collections.sort(list, nameComparator); // uses compare()
        list.forEach(s -> System.out.println(s.id + " " + s.name));
    }
}
