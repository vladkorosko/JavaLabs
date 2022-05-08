package org.example.task7;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;

public class Race {
    private static final Runnable fullTeam = () -> System.out.println("Race started!");

    private static final MyCyclicBarrier barrier = new MyCyclicBarrier(5, fullTeam);

    public static void addCar(int carNumber) {
        new Thread() {
            @Override
            public void run() {
                try {
                    Random random = new Random();
                    synchronized (this) {
                        this.wait(random.nextInt(4000) + 1000);
                    }
                    System.out.println("Car " + carNumber + " is ready");
                    barrier.await();

                    synchronized (this) {
                        this.wait(random.nextInt(4000) + 3000);
                    }

                    System.out.println("Car " + carNumber + " is ready");
                    barrier.await();

                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
