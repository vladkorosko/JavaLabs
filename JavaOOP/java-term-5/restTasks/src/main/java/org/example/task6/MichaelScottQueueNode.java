package org.example.task6;

import java.util.concurrent.atomic.AtomicReference;

public class MichaelScottQueueNode<T> {
    public T data;
    public AtomicReference<MichaelScottQueueNode<T>> next = new AtomicReference<>();

    public MichaelScottQueueNode(T data) {
        this.data = data;
    }

    public MichaelScottQueueNode() {}
}
