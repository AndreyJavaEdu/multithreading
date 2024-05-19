package com.kamenskiy.io.callable;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.*;

public class CallableExample implements Callable<Integer> {
    private final String name;
    public CallableExample(String name) {
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " длина слова: " + name.length());
        return Integer.valueOf(name.length());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split(" ");
        Set<Future<Integer>> set = new HashSet<>();

        for(String str : strs) {
            Future<Integer> futureStr = pool.submit(new CallableExample(str));
            set.add(futureStr);
        }
        int sum = 0;
        for(Future<Integer> futureStr : set) {
            futureStr.get();
            sum += futureStr.get();
        }
        System.out.println(sum);
        pool.shutdown();
    }
}
