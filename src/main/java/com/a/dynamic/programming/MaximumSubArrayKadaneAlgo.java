package com.a.dynamic.programming;

import java.util.ArrayList;
import java.util.List;

//http://algorithms.tutorialhorizon.com/kadanes-algorithm-maximum-subarray-problem/

/*
start:
    max_so_far = 0
    max_ending_here = 0

loop i= 0 to n
  (i) max_ending_here = max_ending_here + a[i]
  (ii) if(max_ending_here < 0)
            max_ending_here = 0
  (iii) if(max_so_far < max_ending_here)
            max_so_far = max_ending_here
return max_so_far
 */
public class MaximumSubArrayKadaneAlgo {
	
	List<Integer> list = new ArrayList<Integer>();
	
	public int maxSubArray(int[] arr){
		int max_so_far = 0;
		int max_ending_here = 0;
		
		for(int i=0; i<arr.length;i++){
			max_ending_here = max_ending_here + arr[i];
			if(max_ending_here < 0){
				max_ending_here = 0;
			}
			if(max_so_far < max_ending_here){
				list.add(arr[i]);
				max_so_far = max_ending_here;
			}
		}
		return 	max_so_far;
	}
	
	
	public int KandaneModify(int[] arrA) {
		int max_ending_here = arrA[0];
		int max_so_far = arrA[0];
		
		for(int i=0;i<arrA.length;i++){
			max_ending_here = Math.max(arrA[i], max_ending_here+arrA[i]);
			max_so_far = Math.max(max_so_far, max_ending_here);
		}
		
		return max_so_far;
	}
	
	
	public static void main(String args[]){
		MaximumSubArrayKadaneAlgo a = new MaximumSubArrayKadaneAlgo();
		int arrA[] = { 1, 2, -3, -4, 2, 7, -2, 3 };
		System.out.println("Maximum subarray is  "+a.maxSubArray(arrA));
		System.out.println("List of Integers  "+a.list);
		int arrB[] = { -2, -3, -4, -2, -7, -2, -3,-11 };
		System.out.println("Maximum Subarray when all elements are negative : " + a.KandaneModify(arrB));
	}

}
