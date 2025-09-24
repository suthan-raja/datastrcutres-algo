package com.data.algo.inter;

import java.util.ArrayList;
import java.util.List;

class Student implements Comparable<Student> {

    int id;
    String name;

    public Student(int i, String john) {
        this.id = i;
        this.name = john;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.id, o.id);
    }
}

public class ComparableExample {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(2, "Alex"));
        list.add(new Student(1, "John"));
        list.add(new Student(3, "Mary"));

        System.out.println(list);
    }
}
