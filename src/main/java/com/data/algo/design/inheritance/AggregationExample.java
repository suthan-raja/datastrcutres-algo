package com.data.algo.design.inheritance;

import java.util.List;

class TeacherAgg {
    String name;
    TeacherAgg(String name) {
        this.name = name;
    }
}

class Department {
    String name;
    List<TeacherAgg> teachers;
    Department(String name, List<TeacherAgg> teachers) {
        this.name = name;
        this.teachers = teachers;
    }

    void showTeachers(){
        for(TeacherAgg teacher : teachers){
            System.out.println(teacher.name);
        }
    }
}

public class AggregationExample {
    public static void main(String[] args) {
        TeacherAgg teacher1 = new TeacherAgg("John");
        TeacherAgg teacher2 = new TeacherAgg("Jane");
        Department department = new Department("Agu", List.of(teacher1, teacher2));
        department.showTeachers();
    }
}
