package org.example.LeakyBucket;

import org.example.RateLimiter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LeakyBucket implements RateLimiter {
    /**Why blocking queue?
     * 1. fail further than size provided
     * 2.thread safe*/
    BlockingQueue<Integer> queue;

    public LeakyBucket(int capacity){
        this.queue = new LinkedBlockingQueue<>(capacity);
    }

    @Override
    public boolean grantAccess() {
        if(queue.remainingCapacity()>0){
            queue.add(1);
            return true;
        }
        return false;
    }
}
