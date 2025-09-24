package com.data.algo.design.prototype;

class AddressDeep {
    String city;
    AddressDeep(String city) { this.city = city; }
}

class PersonDeep implements Cloneable {
    String name;
    AddressDeep address;

    PersonDeep(String name, AddressDeep address) {
        this.name = name;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        PersonDeep cloned = (PersonDeep) super.clone();
        cloned.address = new AddressDeep(this.address.city); // deep copy
        return cloned;
    }

    @Override
    public String toString() {
        return name + " lives in " + address.city;
    }
}

public class DeepCopyExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        AddressDeep addr = new AddressDeep("New York");
        PersonDeep p1 = new PersonDeep("John", addr);

        PersonDeep p2 = (PersonDeep) p1.clone(); // deep copy
        p2.name = "Mike";
        p2.address.city = "Los Angeles"; // does NOT affect p1

        System.out.println(p1); // John lives in New York
        System.out.println(p2); // Mike lives in Los Angeles
    }
}
