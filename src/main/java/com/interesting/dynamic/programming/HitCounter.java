package a.com.interesting.dynamic.programming;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* https://discuss.leetcode.com/topic/48752/simple-java-solution-with-explanation
  I use a queue to record the information of all the hits. Each time we call the function getHits( ), 
  we have to delete the elements which hits beyond 5 mins (300).
  The result would be the length of the queue.
*/
public class HitCounter {
	
    BlockingQueue<Integer> q;
	/** Initialize your data structure here. */
    public HitCounter() {
        q = new LinkedBlockingQueue<Integer>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        q.offer(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(!q.isEmpty() && timestamp - q.peek() >= 300) {
            q.poll();
        }
        
        return q.size();
    }
    
    
}


/*
    //Another Popular Implementation
    public class HitCounter {
    private int[] times;
    private int[] hits;
    // Initialize your data structure here. 
    public HitCounter() {
        times = new int[300];
        hits = new int[300];
    }
    
    // Record a hit.@param timestamp - The current timestamp (in seconds granularity). 
    public void hit(int timestamp) {
        int index = timestamp % 300;
        if (times[index] != timestamp) {
            times[index] = timestamp;
            hits[index] = 1;
        } else {
            hits[index]++;
        }
    }
    
    // Return the number of hits in the past 5 minutes. @param timestamp - The current timestamp (in seconds granularity). 
    public int getHits(int timestamp) {
        int total = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - times[i] < 300) {
                total += hits[i];
            }
        }
        return total;
    }
}


*/