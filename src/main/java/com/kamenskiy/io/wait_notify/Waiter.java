package com.kamenskiy.io.wait_notify;

import java.util.Objects;

public class Waiter implements Runnable {
    private final Messager msg;

    public Waiter(Messager messager) {
        this.msg = messager;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Поток " + threadName + " начал работу! Текущее сообщение: " + msg.getMessage());
        synchronized (msg) {
            System.out.println("поток "+ threadName +":" + System.currentTimeMillis());
            System.out.println("Поток " + threadName + " ждет метода notify");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                msg.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        System.out.println("Поток " + threadName + " продолжил выполнение после сработки метода notify во время: " + System.currentTimeMillis());
        System.out.println("Поток " + threadName + " сообщение: "+ msg.getMessage());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Waiter waiter = (Waiter) o;
        return Objects.equals(msg, waiter.msg);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(msg);
    }
}
