package com.multiThreading.create_thread_extend;

public class MultiThreadingExample {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        t1.start();
        Thread.sleep(3000);
        for(int i=0;i<5;i++){
            System.out.println("Main Thread");
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i<5; i++) {
            System.out.println("child Thread");
        }
    }

}
