package com.kamenskiy.io.consumer_producer;

public class Store {
    private int item;

    public synchronized void put() {
        if (item >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        item++;
        System.out.println("Производитель добавил 1 товар. Теперь на складе: " + item);
        notify();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void get() {
        if (item < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        item--;
        System.out.println("Покупатель купил 1 товар. Теперь на складе: " + item);
        notify();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

