 package com.algorithms.tutorialhorizon.array;

import java.util.Arrays;

/*
 * Algorithm: sort integer array containing 0 & 1 in java (example):

	Take two indexes low and high [Shown in Fig 2]
	low will points to lowest position of an array (index = 0)
	high will points to highest position of an array (index = array’s length – 1)
	Start incrementing low index till we find element value = 1
	Stops incrementing as soon as we found 1
	Start decrementing the high index till we find element value = 0
	Stops decrementing as soon as we found 0
	Now swap the values pointed by low and high index ( 1 and 0)
	After swapping, 0 will come in left side of array and 1 will be come in right side of array
	After performing above algorithm, whole array will be sorted in O(n) times.
 */

public class SortArrayHaving0And1 {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 0, 1, 0, 1, 0 };
		sortArray(arr);
		System.out.println("Sorted array is:"+Arrays.toString(arr));
	}
	
	private static void sortArray(int[] arr) {
		
		int low = 0;
		int high = arr.length - 1;
		
		while(low < high) {
			//increment till we find 1
			while(arr[low] == 0 && low < high)
				low ++;
			
			//decrement till we find 0
			while(arr[high] == 1 && low < high)
				high--;
			
			if(low < high) {
				//Swap or simply put 0 or 1
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
				low ++;
				high--;
			}
		}
		return;
	}
}
