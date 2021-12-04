package org.example.task3;

import lombok.Getter;

import java.util.List;

@Getter
public class MyThreadInfo {
    private final List<Thread> threads;

    public MyThreadInfo(Thread... threads) {
        this.threads = List.of(threads);
    }
}
