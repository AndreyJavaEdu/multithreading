package com.kamenskiy.io;

public class SleepExample extends Thread {
    public SleepExample(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i < 4; i++) {
            System.out.println("Поток с именем " + Thread.currentThread().getName() + " вывел: " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static void main(String[] args) {
        Thread tread1 = new SleepExample("Rick");
        Thread tread2 = new SleepExample("Marta");
        Thread tread3 = new SleepExample("Igor");
        tread1.start();
        tread2.start();
        tread3.start();
    }
}
