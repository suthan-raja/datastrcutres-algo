package com.data.algo.relation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Fruit{
    public String name() { return "Fruit"; }
//    public String jj() { return null; }
}

class Apple extends Fruit{
    public String name() { return "Apple"; }
    public String jj() { return "Apple"; }
}

class GreenApple extends Apple{
    public String name() { return "GreenApple"; }
}

class Graphs extends Fruit{
    public String name() { return "Graphe"; }
}

class Watermelon extends Fruit{
    public String name() { return "Watermelon"; }
}

public class ExtendsGeneric {
    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple(), new Apple(), new Apple(), new Apple());
        List<Graphs> graphs = Arrays.asList(new Graphs(), new Graphs());
        List<Watermelon> watermelons = Arrays.asList(new Watermelon(), new Watermelon(), new Watermelon(), new Watermelon());
        Apple s = new Apple();
        Fruit sj = new Fruit();
        List<Fruit>  g = Arrays.asList(s, sj);
        printBaskets(g);



        Fruit fs = new Apple();
        fs.name();
        ((Apple)fs).jj();

//        printBaskets(apples);
    }

    static void printBaskets(List<? extends Fruit> values){
//        values.add(new Apple());
//        values.add(new GreenApple());
//        values.add(null);
        for(Fruit f : values){
            System.out.println(f.name());
//            System.out.println(f.);
        }

    }

    static void addBaskets(List<? super Fruit> values){
        values.add(new Apple());
        values.add(new GreenApple());
        values.add(new Watermelon());
    }
}
