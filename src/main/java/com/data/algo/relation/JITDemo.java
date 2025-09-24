package com.data.algo.relation;

import java.util.ArrayList;
import java.util.List;

final class ParentCass {
    static class Rowdy {
        void greet() {
            System.out.println("Static nested class here!");
        }
    }
}

class ParentCass2 {
    private String message = "Non-static inner class here!";

    class Rowdy2 {
        void greet() {
            System.out.println(message);
        }
    }
}

public class JITDemo {
    public static void main(String[] args) throws Exception {
        // Static nested class usage
        ParentCass parentCass = new ParentCass();
        ParentCass.Rowdy rowdy = new ParentCass.Rowdy();
        rowdy.greet();

        // Non-static inner class usage
        ParentCass2 parent = new ParentCass2();
        ParentCass2.Rowdy2 rowdy2 = new ParentCass2().new Rowdy2();
        rowdy2.greet();


        Thread th = new Thread(new Runnable() {
            public void run() {
                try {
                    wait(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        /*try{
            int s = 10/0;
        }catch(Exception e){
            throw e;
        }finally {
            throw new Exception("Lara Laru Lorry");
        }*/

        List<String> agu = new ArrayList<String>();
        for(String j : agu){
            agu.add("2");
        }
    }
}
