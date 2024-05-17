package com.kamenskiy.io.consumer_producer;

public class Consumer implements Runnable{
    private Store store;

    public Consumer(Store store) {

        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            store.get();
        }
    }
}
