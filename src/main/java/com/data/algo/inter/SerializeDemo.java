package com.data.algo.inter;

import java.io.*;

class PersonS implements Serializable {
    private String name;
    private int age;
    private transient String password;
    
    PersonS(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }
}

public class SerializeDemo {
    public static void main(String[] args) throws Exception {
        PersonS p = new PersonS("Suthan", 25, "kingkong");

        // Serialization: write object to file
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.dat"));
        oos.writeObject(p);
        oos.close();

        // Deserialization: read object from file
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.dat"));
        PersonS p2 = (PersonS) ois.readObject();
        ois.close();

        System.out.println("Name: " + p2.getName() + ", Age: " + p2.getAge() + ", Password: " + p2.getPassword());
    }
}
