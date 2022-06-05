package com.algorithms.tutorialhorizon.array;
/*
 * 
 //http://www.makeinjava.com/dutch-national-flag-problem-sort-array-containing-0s-1s-2s/
  
 Algorithm: sort an integer array containing 0,1 & 2 using java

	Maintain three indexes low = 0, mid = 0 and high = array length – 1
	low, mid and high represents 0s, 1s and 2s respectively.
	Start iterating from mid to high
	If found 0 at mid index then swap it with low
	If found 1 at mid index (It is at it’s right place) then its fine let us increment it.
	If found 2 at mid index, swap it with high.
	At the end of iteration, we will get the sorted or segregated array.
 */
import java.util.Arrays;

public class Segregate01And2 {

	private static void segregateArray(int[] arr) {

		int low = 0, mid = 0;
		int high = arr.length - 1;

		while (mid <= high) {

			if (arr[mid] == 0) {
				swap(arr, low, mid);
				low++;
				mid++;

			} else if (arr[mid] == 1) {
				mid++;
			} else if (arr[mid] == 2) {
				swap(arr, mid, high);
				high--;
			}
		}
	}

	private static void swap(int[] arr, int from, int to) {
		int temp = arr[from];
		arr[from] = arr[to];
		arr[to] = temp;
	}
	
	public static void main(String[] args) {
		int[] example1 = { 0, 1, 2, 1, 2, 1, 0 };
		segregateArray(example1);
		System.out.println("Example 1 segregated array is : " + Arrays.toString(example1));
	}

}
