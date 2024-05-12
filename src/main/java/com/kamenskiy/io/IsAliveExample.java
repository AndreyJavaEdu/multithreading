package com.kamenskiy.io;

public class IsAliveExample {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new RunnableExample("1");
        Thread thread = new Thread(runnable);
        System.out.println("Поток перед стартом isAlive: "+ thread.isAlive());
        thread.start();
        System.out.println("Поток после старта isAlive: "+ thread.isAlive());
        thread.join();
        System.out.println("Поток после завершения работы: "+ thread.isAlive());
    }
}
