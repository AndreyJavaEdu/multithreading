package com.kamenskiy.io.deadlock;

public class Deadlock {
    static public class Friend {
        String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s " + "bower me!%n", this.name, bower.getName());
            bower.bowBack(this);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s " + " has bowed back to me!%n", this.name, bower.getName());
        }
    }

    public static void main(String[] args) {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread1 start");
                alphonse.bow(gaston);
                System.out.println("Thread1 end");

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread2 start");
                gaston.bow(alphonse);
                System.out.println("Thread2 end");
            }
        }).start();
    }
}
