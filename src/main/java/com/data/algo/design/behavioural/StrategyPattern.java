package com.data.algo.design.behavioural;

// 1. Strategy Pattern
interface PaymentStrategy {
    void pay(int amount);
}

// 2. Concrete Strategies
class CreditCard implements PaymentStrategy {
    private String cardNumber;

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + "$ paid with Credit Card " + cardNumber);
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;
    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + "$ paid via PayPal using " + email);
    }
}

// 3. Context
class ShoppingCart {
    protected PaymentStrategy paymentStrategy;
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        // Pay with credit card
        cart.setPaymentStrategy(new CreditCard("1234-5678-9012-3456"));
        cart.checkout(500);

        // Pay with PayPal
        cart.setPaymentStrategy(new PayPalPayment("user@example.com"));
        cart.checkout(300);
    }
}
