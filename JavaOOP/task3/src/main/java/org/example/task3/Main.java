package org.example.task3;

import lombok.SneakyThrows;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------------------------------");
        Thread subThread = new Thread(() -> {
            try {
                System.out.println("SubThread of Thread 2 started");
                System.out.println("---------------------------------");
                Thread.sleep(500);
                System.out.println("SubThread of Thread 2 finished");
                System.out.println("---------------------------------");
            } catch (InterruptedException e) {
                System.out.println("ERROR");
            }
        });

        MyThreadInfo info = new MyThreadInfo(
                new Thread(() -> {
                    try {
                        System.out.println("Thread 1 started");
                        System.out.println("---------------------------------");
                        Thread.sleep(1000);
                        System.out.println("Thread 1 finished");
                        System.out.println("---------------------------------");
                    } catch (InterruptedException e) {
                        System.out.println("ERROR");
                    }
                }),
                new Thread(() -> {
                    try {
                        System.out.println("Thread 2 started");
                        System.out.println("---------------------------------");
                        Thread.sleep(200);

                        subThread.start();
                        Thread.sleep(200);
                        System.out.println("Thread 2 finished");
                        System.out.println("---------------------------------");
                    } catch (InterruptedException e) {
                        System.out.println("ERROR");
                    }
                }),
                subThread
        );
        for (int i = 0; i < info.getThreads().size() - 1; i++) {
            info.getThreads().get(i).start();
        }
        testMethod(info);
    }

    @SneakyThrows
    public static void testMethod(MyThreadInfo info) {
        while (info.getThreads().stream().anyMatch(Thread::isAlive)) {
            info.getThreads().forEach(t -> {
                System.out.println(t.getName());
                Arrays.stream(t.getStackTrace()).forEach(System.out::println);
            });
            System.out.println("---------------------------------");
            Thread.sleep(100);
        }

    }
}
