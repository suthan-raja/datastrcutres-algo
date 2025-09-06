package com.data.algo.relation;

interface One {
    default void hello(){
        System.out.println("Hello from One.");
    }
    
}

interface Two {
    default void hello(){
        System.out.println("Hello from Two.");
    }
}

class Three {
   public void hello(){
        System.out.println("Hello from Three.");
    }
}

public class DiamondProblem extends Three implements One, Two {
    public static void main(String[] args) {
        DiamondProblem dp = new DiamondProblem();
        dp.hello();
        new DiamondProblem().hello();
    }

    @Override
    public void hello() {
        One.super.hello();
        Two.super.hello();
    }
}
