package com.multiThreading.create_thread_runnable;

public class MultiThreadingExampleRunnable {
    public static void main(String[] args) {
        MyRunnable r = new MyRunnable();
        Thread t1 = new Thread(r);
        t1.run();
        for(int i=0;i<10;i++){
            System.out.println("main thread");
        }
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("child thread");
        }
    }

    public void start(){
        System.out.println("start");
    }
}
