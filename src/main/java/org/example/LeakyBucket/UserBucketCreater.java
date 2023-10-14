package org.example.LeakyBucket;

import java.util.HashMap;
import java.util.Map;

public class UserBucketCreater {
    Map<Integer,LeakyBucket> bucket;
    public UserBucketCreater(int id){
        this.bucket = new HashMap<>();
        //either user or configurable
        bucket.put(id, new LeakyBucket(10));
    }

    void accessApplication(int id){
        if(bucket.get(id).grantAccess()){
            System.out.println(Thread.currentThread().getName()+" -> Able to access the application");
        } else {
            System.out.println(Thread.currentThread().getName()+" ->429 Too many requests");
        }
    }
}
