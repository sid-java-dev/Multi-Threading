package com.multiThreading.sync;

public class MultiThreadingExampleSync {
    public static void main(String[] args) {
        SyncExample obj=new SyncExample();
        Thread t1=new Thread(()->{
            obj.greet("Hello");
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
               obj.greet("World");
            }
        });
        t1.start();
        t2.start();
    }
}
class SyncExample{
    public  void greet(String message){
        synchronized (this){
            System.out.print("["+message);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("]");
        }
    }
}
