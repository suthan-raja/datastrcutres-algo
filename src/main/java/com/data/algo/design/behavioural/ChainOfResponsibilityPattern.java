package com.data.algo.design.behavioural;

// 1. Handler
abstract class Approver {
    protected Approver nextApprover;
    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }
    public abstract void processRequest(PurchaseRequest request);
}

// 2. Concrete Handlers
class TeamLead extends Approver {
    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.amount <= 1000) {
            System.out.println("TeamLead approved purchase of $" + request.amount);
        } else if (nextApprover != null) {
            nextApprover.processRequest(request);
        }
    }
}

class Manager extends Approver {
    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.amount <= 5000) {
            System.out.println("Manager approved purchase of $" + request.amount);
        } else if (nextApprover != null) {
            nextApprover.processRequest(request);
        }
    }
}

class Director extends Approver {
    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.amount <= 20000) {
            System.out.println("Director approved purchase of $" + request.amount);
        } else {
            System.out.println("Purchase request of $" + request.amount + " requires CEO approval!");
        }
    }
}

class PurchaseRequest {
    int amount;
    String purpose;

    public PurchaseRequest(int amount, String purpose) {
        this.amount = amount;
        this.purpose = purpose;
    }
}

public class ChainOfResponsibilityPattern {
    public static void main(String[] args) {
        Approver teamLead = new TeamLead();
        Approver manager = new Manager();
        Approver director = new Director();

        // Create chain: TeamLead → Manager → Director
        teamLead.setNextApprover(manager);
        manager.setNextApprover(director);

        // Test requests
        PurchaseRequest r1 = new PurchaseRequest(500, "Office Supplies");
        PurchaseRequest r2 = new PurchaseRequest(3000, "New Laptops");
        PurchaseRequest r3 = new PurchaseRequest(15000, "New Server");
        PurchaseRequest r4 = new PurchaseRequest(50000, "Company Car");

        teamLead.processRequest(r1);
        teamLead.processRequest(r2);
        teamLead.processRequest(r3);
        teamLead.processRequest(r4);
    }
}
