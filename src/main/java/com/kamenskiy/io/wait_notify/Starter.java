package com.kamenskiy.io.wait_notify;

public class Starter {
    public static void main(String[] args) {
        Messager msg = new Messager("обработать");
        Waiter waiter = new Waiter(msg);
        Waiter waiter1 = new Waiter(msg);

        new Thread(waiter, "Waiter").start();
        new Thread(waiter1, "Waiter1").start();

        Notifier notifier = new Notifier(msg);
        new Thread(notifier, "Notifier").start();
        System.out.println("Стартовали все потоки!!!");
    }
}
