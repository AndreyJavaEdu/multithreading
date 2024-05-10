package com.kamenskiy.io;

public class JoinExample extends Thread{
    public JoinExample(String name) {
        super(name);
    }

    @Override
    public void run() {
        String currentThread = Thread.currentThread().getName();
        for (int i = 1; i < 10; i++) {
            System.out.println(currentThread + " is running: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Thread is completed: " + currentThread);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new JoinExample("A");
        Thread thread2 = new JoinExample("B");
        Thread thread3 = new JoinExample("C");

        thread1.start();
        thread1.join();
        thread2.start();
        thread3.start();
    }
}
