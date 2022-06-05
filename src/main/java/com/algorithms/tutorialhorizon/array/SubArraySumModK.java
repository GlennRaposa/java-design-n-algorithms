package com.algorithms.tutorialhorizon.array;

public class SubArraySumModK {
	
	//1. use a cache array increment the counter 
	public static int countSubarrays(int[] nums, int k) {
	    int[] cache = new int[k];
	    cache[0]++;
	    int s = 0, counter = 0;
	    for (int i = 0; i < nums.length; i++) {
	        s = ((s + nums[i]) % k + k) % k;
	        counter += cache[s];
	        cache[s]++;
	    }

	    return counter;
	}
	
	public static void main(String args[]){
		int a[] = {4, 5, 0, -2, -3, 1}; 
		int k = 5;
		int result = countSubarrays(a, k);
		System.out.println("okay "+result);
		
	}
	
}
