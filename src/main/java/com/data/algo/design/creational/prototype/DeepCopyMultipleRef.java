package com.data.algo.design.creational.prototype;

import java.io.Serializable;

class AddressDee implements Serializable {
    String city;
    String street;
    AddressDee(String city, String street) {
        this.city = city;
        this.street = street;
    }

    @Override
    public String toString() {
        return "AddressDee{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}

class Qualification implements Serializable{
    String sslc;
    String hsc;
    Qualification(String sslc, String hsc) {
        this.sslc = sslc;
        this.hsc = hsc;
    }

    @Override
    public String toString() {
        return "Qualification{" +
                "sslc='" + sslc + '\'' +
                ", hsc='" + hsc + '\'' +
                '}';
    }
}

class EmployeeDeep implements Cloneable {
    String name;
    AddressDee address;
    Qualification qualification;
    EmployeeDeep(String name, AddressDee address, Qualification qualification) {
        this.name = name;
        this.address = address;
        this.qualification = qualification;
    }

    protected EmployeeDeep clone() throws CloneNotSupportedException {
        EmployeeDeep employee = (EmployeeDeep) super.clone();
        employee.address = new AddressDee(this.address.city, this.address.street);
        employee.qualification = new Qualification(this.qualification.sslc, this.qualification.hsc);
        return employee;
    }

    @Override
    public String toString() {
        return "EmployeeDeep{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", qualification=" + qualification +
                '}';
    }
}

public class DeepCopyMultipleRef {
    public static void main(String[] args) throws CloneNotSupportedException {
        AddressDee addressDee = new AddressDee("Tirunelveli", "Nethaji Street");
        Qualification qualification = new Qualification("SHSS",  "SHSS");
        EmployeeDeep employeeDeep = new EmployeeDeep("SUTHAN", addressDee, qualification);
        System.out.println(employeeDeep);

        EmployeeDeep employeeDeep1 = employeeDeep.clone();
        employeeDeep1.name = "Raja";
        System.out.println(employeeDeep1);
    }
}
