package com.data.algo.multithreading;

public class DeadLock {
    public static void main(String[] args) {
        final String r1 = "Resource1";
        final String r2 = "Resource2";

        Thread t1 = new Thread(() -> {
            synchronized (r1){
                try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
                synchronized (r2){
                    System.out.println("T1 Finished");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (r2){
                try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
                synchronized (r1){
                    System.out.println("T2 Finished");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
