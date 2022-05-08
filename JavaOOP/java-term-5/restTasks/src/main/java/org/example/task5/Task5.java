package org.example.task5;

import java.util.ArrayList;

public class Task5 {

    public static void main(String[] args) throws InterruptedException {

        SkipList skipList = new SkipList(15);
        ArrayList<Thread> threads = new ArrayList<>();
        for(int i = 0; i < 1000; ++i) {
            threads.add(new Thread(()->{
                for (int j = 0; j < 1000; ++j) {
                    skipList.add(j);
                }
            }));
            threads.get(i).start();
        }
        for (int i = 0; i < 1000; ++i) {
            threads.get(i).join();
        }
        ArrayList<Thread> threads2 = new ArrayList<>();
        for (int i = 0; i < 500; ++i) {
            threads2.add(new Thread(()-> {
                for (int j = 0; j < 500; ++j) {
                    skipList.remove(j);
                }
            }));
            threads2.get(i).start();
        }
        for (int i = 0; i < 500; ++i) {
            threads2.get(i).join();
        }
        System.out.println(skipList);
    }

}
