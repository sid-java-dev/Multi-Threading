package com.multiThreading.producer_consumer_example;

public class MultiThreadingExample {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Thread chefThread = new Thread(() -> {
            restaurant.prepareDish("Pizza");
        });
        Thread waiterThread = new Thread(() -> {
            restaurant.serveDish("Pizza");
        });
        chefThread.start();
        waiterThread.start();
    }
}

class Restaurant {
    private boolean dishReady = false;

    public synchronized void prepareDish(String dishName) {
        for (int i = 0; i < 10; i++) {
            while (dishReady) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Chef prepared " + dishName + " Iteration : " + (i + 1));
            dishReady = true;
            notify();
        }
    }

    public synchronized void serveDish(String dishName) {
        for (int i = 0; i < 10; i++) {
            while (!dishReady) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("waiter served " + dishName + " Iteration : " + (i + 1));
            dishReady = false;
            notify();
        }
    }
}
