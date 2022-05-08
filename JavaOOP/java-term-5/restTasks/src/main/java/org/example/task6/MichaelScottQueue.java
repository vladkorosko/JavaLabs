package org.example.task6;

import java.util.concurrent.atomic.AtomicReference;

public class MichaelScottQueue<T> {
    private final AtomicReference<MichaelScottQueueNode<T>> head;
    private final AtomicReference<MichaelScottQueueNode<T>> tail;

    public MichaelScottQueue(){
        MichaelScottQueueNode<T> first = new MichaelScottQueueNode<>();
        head = new AtomicReference<>(first);
        tail = new AtomicReference<>(first);
    }

    public void enqueue(T data){
        MichaelScottQueueNode<T> node = new MichaelScottQueueNode<>(data);
        MichaelScottQueueNode<T> currentTail;
        MichaelScottQueueNode<T> currentNext;
        while(true){
            currentTail = this.tail.get();
            currentNext = currentTail.next.get();
            if(currentTail == this.tail.get()){
                if(currentNext == null){
                    if(currentTail.next.compareAndSet(null, node)) {
                        break;
                    }
                } else {
                    this.tail.compareAndSet(currentTail, currentNext);
                }
            }
        }
        this.tail.compareAndSet(currentTail, node);
    }

    public T dequeue(){
        MichaelScottQueueNode<T> currentHead;
        MichaelScottQueueNode<T> currentTail;
        MichaelScottQueueNode<T> currentHeadNext;
        T data;

        while (true){
            currentHead = this.head.get();
            currentTail = this.tail.get();
            currentHeadNext = currentHead.next.get();

            if(currentHead == head.get()){
                if(currentHead == currentTail){
                    if(currentHeadNext == null){
                        return null;
                    }
                    this.tail.compareAndSet(currentTail, currentHeadNext);
                } else {
                    data = currentHeadNext.data;
                    if(head.compareAndSet(currentHead, currentHeadNext)){
                        break;
                    }
                }
            }
        }
        return data;
    }
}
