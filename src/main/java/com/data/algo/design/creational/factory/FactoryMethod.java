package com.data.algo.design.creational.factory;

interface Food {
    void food();
}

class Pizza implements Food {
    public void food(){
        System.out.println("Pizza");
    }
}

class Bread implements Food {
    public void food(){
        System.out.println("Bread");
    }
}

public class FactoryMethod {
    public Food getFood(String food) {
        if(food.equals("Pizza")){
            return new Pizza();
        }else{
            return new Bread();
        }
    }
}

class FactoryMain {
    public static void main(String[] args) {
        FactoryMethod fm = new FactoryMethod();
        Food food = fm.getFood("Pizza");
        food.food();

        Food food1 = fm.getFood("Bread");
        food1.food();
    }
}
