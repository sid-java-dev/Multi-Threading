package com.multiThreading.deadLock;

public class DeadLockExample {
    private static final Object resource1 = new Object();
    private static final Object resource2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (resource1){
                System.out.println("Thread 1 : Holding resource 1 ..");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread 1: waiting for resource 2");
                synchronized (resource2){
                    System.out.println("Thread 1 : Holding resource 1 and 2 ..");
                }
            }

        });
        Thread t2=new Thread(()->{
            synchronized (resource1){
                System.out.println("Thread 2: Holding resource 1 ..");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread 2: waiting for Resource 2..");
                synchronized (resource2){
                    System.out.println("Thread 2: Holding resource 1 and 2..");
                }
            }
        });
        t1.start();
        t2.start();
    }

}
