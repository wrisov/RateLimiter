package org.example.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class UserBucketCreator {
    Map<Integer, SlidingWindow> bucket;
    public UserBucketCreator(int id){
        this.bucket = new HashMap<>();
        bucket.put(id,new SlidingWindow(1, 10));
    }

    void accessApplication(int id){
        if(bucket.get(id).grantAccess()){
            System.out.println(Thread.currentThread().getName()+" -> able to access");
        } else {
            System.out.println(Thread.currentThread().getName()+" -> 429 too many requests");
        }
    }
}
