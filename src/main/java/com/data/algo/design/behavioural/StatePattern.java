package com.data.algo.design.behavioural;

interface State {
    void insertCoin();
    void pressButton();
}

class NoCoinState implements State {
    private VendingMachine machine;
    public NoCoinState(VendingMachine machine) { this.machine = machine; }

    @Override
    public void insertCoin() {
        System.out.println("Coin inserted.");
        machine.setState(machine.getHasCoinState());
    }

    @Override
    public void pressButton() {
        System.out.println("Insert coin first!");
    }
}

class HasCoinState implements State {
    private VendingMachine machine;

    public HasCoinState(VendingMachine machine) { this.machine = machine; }

    @Override
    public void insertCoin() {
        System.out.println("Coin already inserted.");
    }

    @Override
    public void pressButton() {
        System.out.println("Dispensing item...");
        machine.setState(machine.getNoCoinState());
    }
}

// 3. Context
class VendingMachine {
    private State noCoinState;
    private State hasCoinState;
    private State state;

    public VendingMachine() {
        noCoinState = new NoCoinState(this);
        hasCoinState = new HasCoinState(this);
        state = noCoinState; // initial state
    }

    public void setState(State state) { this.state = state; }
    public State getNoCoinState() { return noCoinState; }
    public State getHasCoinState() { return hasCoinState; }

    public void insertCoin() { state.insertCoin(); }
    public void pressButton() { state.pressButton(); }

}

public class StatePattern {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();

        machine.pressButton();      // No coin
        machine.insertCoin();       // Insert coin
        machine.insertCoin();       // Already inserted
        machine.pressButton();      // Dispense item
        machine.pressButton();      // No coin
    }
}
