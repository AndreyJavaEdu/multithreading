package com.kamenskiy.io.retrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock locker = new ReentrantLock();
        CommonResource res = new CommonResource();
        for (int i = 0; i < 6; i++) {
            Thread thread = new Thread(new CountThread(locker, res), "Thread " + i);
            thread.start();

        }
    }
}

class CommonResource {
    int x = 0;

    public int getX() {
        return x;
    }
}

class CountThread implements Runnable {
    private ReentrantLock locker;
    private CommonResource res;

    public CountThread(ReentrantLock locker, CommonResource res) {
        this.locker = locker;
        this.res = res;
    }


    @Override
    public void run() {
        locker.lock();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
                res.x++;
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            locker.unlock();
        }
    }
}
