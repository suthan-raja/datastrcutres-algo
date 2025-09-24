package com.data.algo.design.prototype;

public class Employee implements Cloneable {

    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", age=" + age + "]";
    }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }


}

class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee original = new Employee("Suthan", 23);
        System.out.println(original.toString());

        Employee copy = (Employee) original.clone();
        System.out.println(copy.toString());

        System.out.println(copy);
        copy.setName("King");
        System.out.println(copy);
        System.out.println(original);
    }
}
