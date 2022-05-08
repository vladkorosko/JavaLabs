package org.example.task7;

import java.util.concurrent.BrokenBarrierException;

public class MyCyclicBarrier {

    private int threadsAmount;
    private int waitingThreads;
    private Runnable cyclicBarrierEvent;
    private boolean isBroken = false;

    public MyCyclicBarrier(int threadsAmount, Runnable cyclicBarrierEvent) {
        this.threadsAmount = threadsAmount;
        this.waitingThreads = 0;
        this.cyclicBarrierEvent = cyclicBarrierEvent;
    }

    public MyCyclicBarrier(int threadsAmount) {
        this.threadsAmount = threadsAmount;
        this.waitingThreads = 0;
        this.cyclicBarrierEvent = null;
    }

    public synchronized void await() throws InterruptedException, BrokenBarrierException {
        if (isBroken)
            throw new BrokenBarrierException();

        waitingThreads++;

        if (waitingThreads != threadsAmount) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                isBroken = true;
                throw e;
            }
        } else {
            waitingThreads = 0;
            notifyAll();
            if (cyclicBarrierEvent != null)
                cyclicBarrierEvent.run();
        }
    }
}