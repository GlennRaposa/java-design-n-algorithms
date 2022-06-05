package com.a.matrix.puzzels.question;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

//https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/WeightedJobSchedulingMaximumProfit.java
//https://www.youtube.com/watch?v=cr6Ip0J9izc
/*
 * 1. sort job by start time so earliest start time job is first

 * 2. For every job find the first job which does not overlap with this job
 * 3. And see if this job profit plus profit till last non overlapping job is greater
 * 4. than profit till last job.
 * 
 * C[i] = is the optimal solution from i....j 
   say C[i] is the first job profit and C(j) is the last job profit 
   sub problem C[i..k]  C[k+1...j]
   
   C[i] = Math.max(jobs[i].profit, C[i-1]);
   //if last ending job time is less than next job starting time the we can add and get max of job[j] + job[i] profit
   if(jobs[j].end <= jobs[j].start){
		C[i] = Math.max(C[i], jobs[i].profit+C[j]);
   }
    
 */

/**
 * http://www.cs.princeton.edu/courses/archive/spr05/cos423/lectures/06dynamic-programming.pdf
 * Given set of jobs with start and end interval and profit, how to maximize profit such that 
 * jobs in subset do not overlap.
 */
public class WeightedJobSchedulingMaximumProfit {

    public int maximum(Job[] jobs){
        int C[] = new int[jobs.length];
        FinishTimeComparator comparator = new FinishTimeComparator();
        Arrays.sort(jobs, comparator);
        
        C[0] = jobs[0].profit;
        for(int i=1; i < jobs.length; i++){
            C[i] = Math.max(jobs[i].profit, C[i-1]);
            for(int j=i-1; j >=0; j--){
                if(jobs[j].end <= jobs[i].start){
                    C[i] = Math.max(C[i], jobs[i].profit + C[j]);
                    break;
                }
            }
        }
        int maxVal = Integer.MIN_VALUE;
        for (int val : C) {
            if (maxVal < val) {
                maxVal = val;
            }
        }
        return maxVal;
    }
    
    public static void main(String args[]){
        Job jobs[] = new Job[6];
        jobs[0] = new Job(1,3,5);
        jobs[1] = new Job(2,5,6);
        jobs[2] = new Job(4,6,5);
        jobs[3] = new Job(6,7,4);
        jobs[4] = new Job(5,8,11);
        jobs[5] = new Job(7,9,2);
        WeightedJobSchedulingMaximumProfit mp = new WeightedJobSchedulingMaximumProfit();
        System.out.println(mp.maximum(jobs));
    }
}
class Job{
    int start;
    int end;
    int profit;
    Job(int start,int end,int profit){
        this.start= start;
        this.end = end;
        this.profit= profit;
    }
}

class FinishTimeComparator implements Comparator<Job>{

    public int compare(Job arg0, Job arg1) {
        if(arg0.end <= arg1.end){
            return -1;
        }else{
            return 1;
        }
    }
    
}