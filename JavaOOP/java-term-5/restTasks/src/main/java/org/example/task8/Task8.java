package org.example.task8;

import java.util.ArrayList;

public class Task8 {
    public static void main(String[] args) throws InterruptedException {
        //TestClass.simulation();
        MyReentrantLock lock = new MyReentrantLock();
        TestClass m = new TestClass();

        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            threads.add(new Thread(() -> {
                for (int j = 0; j < 100000; ++j) {
                    try {
                        lock.lock();
                        m.inc();
                        lock.unlock();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));
            threads.get(i).start();
        }

        for (int i = 0; i < 5; ++i) {
            threads.get(i).join();
        }
        System.out.println(m.getData());
    }
}
