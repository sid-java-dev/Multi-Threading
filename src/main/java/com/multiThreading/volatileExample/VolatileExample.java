package com.multiThreading.volatileExample;

public class VolatileExample {

    volatile boolean keepRunning = true;

    public static void main(String[] args) {
        VolatileExample obj = new VolatileExample();
        obj.startRunning();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        obj.stopRunning();
    }

    public void startRunning() {
        new Thread(() -> {
            System.out.println("Calling start method is Running...");
            System.out.println("KeepRunning value is: " + keepRunning);
            while (keepRunning) {
                //Running
            }
            System.out.println("stop Running..");
        }).start();
    }

    public void stopRunning() {
        new Thread(() -> {
            System.out.println("calling stopRunning method is Running..");
            keepRunning = false;
            System.out.println("keep Running value is :" + keepRunning);
        }).start();
    }
}

