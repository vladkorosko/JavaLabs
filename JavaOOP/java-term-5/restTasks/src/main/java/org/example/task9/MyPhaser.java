package org.example.task9;

import java.util.HashMap;
import java.util.Map;

public class MyPhaser {
    private int phase;
    private int parties;
    private int arrived;
    private int unArrived;
    Map<Integer, Runnable> onAdvance;

    public MyPhaser(int parties) {
        this.parties = parties;
        this.unArrived = parties;
        this.arrived = 0;
        onAdvance = new HashMap<>();
    }

    public int getArrived() {
        return arrived;
    }

    private boolean tryOpen() {
        if (unArrived == 0) {
            if (onAdvance.get(phase) != null) onAdvance.get(phase).run();
            arrived = 0;
            unArrived = parties;
            notifyAll();
            ++phase;
            return true;
        } else {
            return false;
        }
    }

    public synchronized void register() {
        ++parties;
        ++unArrived;
    }

    public synchronized void arrive() {
        ++arrived;
        --unArrived;
        tryOpen();
    }

    public synchronized void arriveAndDeregister() {
        --parties;
        --unArrived;
        tryOpen();
    }

    public synchronized void arriveAndAwait() throws InterruptedException {
        ++arrived;
        --unArrived;
        if (!tryOpen()) {
            this.wait();
        }
    }


}