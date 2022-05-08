package org.example.task10;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class PoolThread extends Thread{
    private Queue<Runnable> taskQueue = null;
    private boolean stopped = false;

    public PoolThread(Queue<Runnable> queue) {
        taskQueue = queue;
    }

    @Override
    public void run() {
        while (!stopped) {
            Runnable runnable = taskQueue.poll();
            if (runnable != null) runnable.run();
        }
    }

    public synchronized void doStop() {
        stopped = true;
    }

    public synchronized boolean isStopped() {
        return stopped;
    }
}