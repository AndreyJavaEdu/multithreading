package com.kamenskiy.io;

import java.util.concurrent.Callable;

public class CallableExample implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        String word = "Java";
        return word.length();
    }
}
