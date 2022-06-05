package com.algorithms.tutorialhorizon.array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindKthLargestElement {
	
	public static void main(String args[]){
		int[] num = {3,2,1,5,6,4};
		int k = 2;
		
		System.out.println("Using Array Sort :"+findKthElement(num, k));
		System.out.println("\n \n");
		System.out.println("Using Min Heap ::"+findKthElementUsingMinHeap(num, k));
		
	}
	
	//Best Solution O(nlog(k))
	/*
	 * We can use a min heap to solve this problem. The heap stores the top k elements. 
	 * Whenever the size is greater than k, delete the min. Time complexity is O(nlog(k)). 
	 * Space complexity is O(k) for storing the top k numbers.
	 */
	public static int findKthElementUsingMinHeap(int[] num, int k){
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for(int i : num){
			System.out.println("Inserted: "+i);
			q.offer(i);
			if(q.size() > k){
				System.out.println("Removed: "+q.peek());
				q.poll();
			}
		}
		System.out.println("Q size: "+q.size());
		return q.peek();
	}
	
	
	
	//Time is O(nlog(n))
	public static int findKthElement(int[] num, int k){
		Arrays.sort(num);
		System.out.println(Arrays.toString(num));
		return num[num.length-k];
	}

}
