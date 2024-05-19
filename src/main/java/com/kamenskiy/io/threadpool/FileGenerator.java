package com.kamenskiy.io.threadpool;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.*;
import java.util.concurrent.*;

public class FileGenerator implements Callable {
    @Override
    public List<String> call() throws Exception {
        String threadName = Thread.currentThread().getName();
        List<String> fileList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            String fileName = threadName + "_" + i + ".txt";
            fileList.add(fileName);

            try (OutputStream out = new FileOutputStream(fileName);
                 BufferedOutputStream buf = new BufferedOutputStream(out)) {
                buf.write(("Java Guru" + i).getBytes());
                buf.flush();
                System.out.println("Поток "+threadName + " записал в файл: " + fileName);
            }
        }
        Thread.sleep(1000);
        return fileList;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Set<Future<List<String>>> futures = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            Callable<List<String>> lesson = new FileGenerator();
            Future<List<String>> future = pool.submit(lesson);
            futures.add(future);
        }

        Set<String> fileNames = new HashSet<>();
        for (Future<List<String>> future : futures) {
            fileNames.addAll(future.get());
        }
        pool.shutdown();
        System.out.println((long) fileNames.size());
        System.out.println("Список созданных файлов: " + fileNames);
    }
}
