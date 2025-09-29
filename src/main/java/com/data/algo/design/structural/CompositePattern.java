package com.data.algo.design.structural;

import java.util.ArrayList;
import java.util.List;

// composite
interface EmployeeManagement {
    void showDetails();
}

class Employee implements EmployeeManagement {

    private String name;
    private int salary;
    private String role;

    public Employee(String name,int salary, String role) {
        this.name = name;
        this.salary = salary;
        this.role = role;
    }

    @Override
    public void showDetails() {
        System.out.println("Name: " + name + ", Salary: " + salary + ", Role: " + role);
    }
}

// composite
class Manager implements EmployeeManagement {
    private String name;
    private int salary;
    private String role;
    private List<EmployeeManagement> employees;
    public Manager(String name, int salary, String role) {
        this.name = name;
        this.salary = salary;
        this.role = role;
        employees = new ArrayList<EmployeeManagement>();
    }

    public void  add(EmployeeManagement employee) {
        employees.add(employee);
    }

    public void remove(EmployeeManagement employee) {
        employees.remove(employee);
    }

    @Override
    public void showDetails() {
        System.out.println("Manager: " + name + " | Role: " + role);
        for (EmployeeManagement emp : employees) {
            emp.showDetails(); // recursion
        }
    }
}

public class CompositePattern {
    public static void main(String[] args) {
        EmployeeManagement emp1 = new Employee("sad",12,"sd");
        EmployeeManagement emp2 = new Employee("sad",12,"sd");
        EmployeeManagement emp3 = new Employee("sad",12,"sd");

        Manager manager = new Manager("sad",1221,"sd");
        manager.add(emp1);
        manager.add(emp2);

        Manager generalManager = new Manager("sad",123,"sd");
        generalManager.add(emp3);
        generalManager.add(manager);

        generalManager.showDetails();

    }
}
