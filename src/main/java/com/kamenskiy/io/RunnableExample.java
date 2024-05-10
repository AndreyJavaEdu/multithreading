package com.kamenskiy.io;

public class RunnableExample implements Runnable {
    private final String localName;

    public RunnableExample(String localName) {
        this.localName = localName;
    }
    public void run() {
        System.out.println("run() " + localName + " running");
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnableExample("thread1"));
        Thread thread2 = new Thread(new RunnableExample("thread2"));
        Thread thread3 = new Thread(new RunnableExample("thread3"));
        Thread thread4 = new Thread(new RunnableExample("thread4"));
        Thread thread5 = new Thread(new RunnableExample("thread5"));
        Thread thread6 = new Thread(new RunnableExample("thread6"));
        Thread thread7 = new Thread(new RunnableExample("thread7"));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
    }
}
