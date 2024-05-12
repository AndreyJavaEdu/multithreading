package com.kamenskiy.io.wait_notify;

public class Notifier implements Runnable {
   private final Messager msg;
   public Notifier(Messager m) {
       this.msg = m;
   }

    @Override
    public void run() {
       String currentThreadName = Thread.currentThread().getName();
        System.out.println(currentThreadName + ": Notifier started");

        try {
            Thread.sleep(1000);
            synchronized (msg){
                msg.setMessage("Поток отработал: " + currentThreadName);
                System.out.println("Notifier ended");
                msg.notify();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
