package com.data.algo.design.inheritance;

class Student {
    String name;
    Student(String name){
        this.name = name;
    }
}

class Teacher {
    void getStudent(Student s){
        System.out.println(s.name);
    }
}

public class AssociationExample {
    public static void main(String[] args) {
        Student s1 = new Student("John");
        Teacher t1 = new Teacher();
        t1.getStudent(s1); // Association knows-a or uses-a
    }
}
