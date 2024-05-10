package com.kamenskiy.io;

import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main thread started");
        RunnableEx runnable = new RunnableEx();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("_____________________________________");
        ThreadExample threadExample = new ThreadExample();
        threadExample.start();
        System.out.println("____________________________________");
        Callable<Integer> callable = new CallableExample();

        System.out.println("Main thread ended");
    }
}