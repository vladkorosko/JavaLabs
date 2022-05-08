package org.example.task10;

public class Task10 {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool pool = new MyThreadPool(16);
        for (int i = 0; i < 16; ++i) {
            int finalI = i;
            pool.execute(() -> {
                try {
                    Thread.sleep((finalI % 4)*500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(finalI);
            });
        }
        pool.stop();
    }
}
