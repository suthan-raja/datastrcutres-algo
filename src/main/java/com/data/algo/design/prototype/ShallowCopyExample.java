package com.data.algo.design.prototype;

class Address {
    String city;
    Address(String city) { this.city = city; }
}

class Person implements Cloneable {
    String name;
    Address address;

    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();  // shallow copy
    }

    @Override
    public String toString() {
        return name + " lives in " + address.city;
    }
}

public class ShallowCopyExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address addr = new Address("New York");
        Person p1 = new Person("John", addr);

        Person p2 = (Person) p1.clone(); // shallow copy
        p2.name = "Mike";
        p2.address.city = "Los Angeles"; // modifies shared object

        System.out.println(p1); // John lives in Los Angeles
        System.out.println(p2); // Mike lives in Los Angeles
    }
}
