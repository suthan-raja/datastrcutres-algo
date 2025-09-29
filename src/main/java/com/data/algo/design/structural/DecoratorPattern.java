package com.data.algo.design.structural;

interface Coffee {
    String getDescription();
    double getCost();
}

class SimpleCoffee implements Coffee {

    @Override
    public String getDescription() {
        return "Normal Coffee";
    }

    @Override
    public double getCost() {
        return 5.0;
    }
}

// 3. Decorator ( Coffee )
abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;
    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }

}

// 4. Concrete Decorator
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }
    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.0;
    }
}

// 5. Concrete Decorator ( SUGAR )
class SugarDecorator extends CoffeeDecorator {

    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Sugar";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.0;
    }
}
public class DecoratorPattern {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " => $" + coffee.getCost());

        coffee = new MilkDecorator(coffee); // Add Milk
        System.out.println(coffee.getDescription() + " => $" + coffee.getCost());

        coffee = new SugarDecorator(coffee); // Add Sugar
        System.out.println(coffee.getDescription() + " => $" + coffee.getCost());
    }
}
