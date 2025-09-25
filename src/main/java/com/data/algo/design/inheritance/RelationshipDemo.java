package com.data.algo.design.inheritance;

import java.util.ArrayList;
import java.util.List;

// -------- Inheritance (is-a) --------
class TeacherRelation {
    String name;
    TeacherRelation(String name){
        this.name = name;
    }

    void teach(StudentRelation student){ // Association ( uses - a )
        System.out.println(name + " is teaching "+student.name);
    }
}

class MathTeacherRelation extends TeacherRelation{
    MathTeacherRelation(String name){
        super(name);
    }

    void explainFormula() {
        System.out.println(name + " explains a math formula.");
    }


}

// -------- Association --------
class StudentRelation{
    String name;
    StudentRelation(String name){
        this.name = name;
    }
}

class DepartmentRelation {
    String deptName;
    List<TeacherRelation> teacherRelations;

    DepartmentRelation(String name, List<TeacherRelation> teacherRelations){
        this.deptName = name;
        this.teacherRelations = teacherRelations;
    }

    void showTeachers() {
        System.out.println("Department: " + deptName);
        for (TeacherRelation t : teacherRelations) {
            System.out.println("Teacher: " + t.name);
        }
    }
}

// -------- Composition (has-a strong) --------
class School {
    String schoolName;
    private List<DepartmentRelation> departmentRelations;

    School(String name){
        this.schoolName = name;
        this.departmentRelations = new ArrayList<>();
    }

    void addDepartment(DepartmentRelation departmentRelation){
        departmentRelations.add(departmentRelation);
    }

    void showDepartments() {
        System.out.println("School: " + schoolName);
        for (DepartmentRelation d : departmentRelations) {
            d.showTeachers();
        }
    }
}

public class RelationshipDemo {
    public static void main(String[] args) {
        // Students
        StudentRelation s1 = new StudentRelation("John");
        StudentRelation s2 = new StudentRelation("Jane");

        // Teachers
        TeacherRelation t1 = new TeacherRelation("Teacher");
        MathTeacherRelation t2 = new MathTeacherRelation("Math");


        // Association: Teacher teaches Student
        t1.teach(s1);
        t2.teach(s2);
        t2.explainFormula();

        // Aggregation: Department has Teachers
        List<TeacherRelation> teacherRelations = List.of(t1,t2);
        DepartmentRelation departmentRelation = new DepartmentRelation("Computer Science", teacherRelations);

        // Composition: School has Departments
        School school = new School("Math University");
        school.addDepartment(departmentRelation);
        school.showDepartments();
    }
}
