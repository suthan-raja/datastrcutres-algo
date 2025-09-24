package com.data.algo.design.builderPattern;

public class Pizza {
    private String dough;
    private String sauce;
    private String cheese;
    private String topping;

    Pizza(PizzaBuilder pizzaBuilder) {
        this.dough = pizzaBuilder.dough;
        this.sauce = pizzaBuilder.sauce;
        this.cheese = pizzaBuilder.cheese;
        this.topping = pizzaBuilder.topping;
    }

    @Override
    public String toString() {
        return "Pizza [dough=" + dough + ", sauce=" + sauce +
                ", cheese=" + cheese + ", topping=" + topping + "]";
    }

    static class PizzaBuilder {
        private String dough;
        private String sauce;
        private String cheese;
        private String topping;

        public PizzaBuilder(String dough, String sauce) {
            this.dough = dough;
            this.sauce = sauce;
        }

        public PizzaBuilder cheese(String cheese) {
            this.cheese = cheese;
            return this;
        }

        public PizzaBuilder topping(String topping) {
            this.topping = topping;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}

class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza.PizzaBuilder("Thin Crust", "Tomato")
                .cheese("Mozzarella")
                .topping("Pepperoni")
                .build();
        System.out.println(pizza);

        Pizza simplePizza = new Pizza.PizzaBuilder("Thick Crust", "Barbecue").build();
        System.out.println(simplePizza);
    }
}

