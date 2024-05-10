package com.kamenskiy.io;

public class ThreadExample1 extends Thread {
    public ThreadExample1(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Thread ThreadExample1 " + this.getName() + " started");
    }

    public static void main(String[] args) {
        ThreadExample1 thread1 = new ThreadExample1("Поток 1");
        ThreadExample1 thread2 = new ThreadExample1("Поток 2");
        ThreadExample1 thread3 = new ThreadExample1("Поток 3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
