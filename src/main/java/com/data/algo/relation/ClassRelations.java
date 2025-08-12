package com.data.algo.relation;

class Uncle {

    String name = "";

    void land() {
        System.out.println("Uncle land");
    }

    class Aunt {

        Aunt() {
            Uncle.this.name = "Blue";
        }

        void land() {
            System.out.println("Aunt land");
        }
    }

}

class GrandParent {

    static class GrandMother {

        //        name = "";
        void land() {
            System.out.println("GrandMother");
        }
    }

    String name;

    void land() {
        System.out.println("GrandParent land");
    }
}

class Parent {

    String name = "Parent ";

    void land() {
        System.out.println("Parent land");
    }

}

class Child extends Parent {

    String name = "Child ";

    void land() {
        System.out.println("Child land");
    }

}


public class ClassRelations {

    public static void main(String[] args) {

        System.out.println("=========================================================");

        Uncle uncle = new Uncle();

        Uncle.Aunt aunt = uncle.new Aunt();

        aunt.land();

        System.out.println("=========================================================");

        GrandParent.GrandMother gp = new GrandParent.GrandMother();

        gp.land();

        System.out.println("=========================================================");

        System.out.println("\t \t \t  Parent Component ");

        Parent parent = new Parent();

        System.out.println(parent.name);

        parent.land();

        System.out.println("=========================================================");

        System.out.println("\t \t \t  Parent compile Time and Child Runtime ");

        Parent child = new Child();

        System.out.println(child.name);

        child.land();

        System.out.println("========================================================");

        System.out.println("\t \t \t \t \t \t Child ");

        Child child2 = new Child();

        System.out.println(child2.name);

        child2.land();


    }
}
