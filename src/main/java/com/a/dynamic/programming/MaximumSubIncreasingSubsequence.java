package com.a.dynamic.programming;

import java.util.Arrays;

/*
 * Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence of the given array 
 * such that the intgers in the subsequence are sorted in increasing order. 
 * For example, if input is {1, 101, 2, 3, 100, 4, 5}, then output should be 106 (1 + 2 + 3 + 100), 
 * 
 * if the input array is {3, 4, 5, 10}, then output should be 22 (3 + 4 + 5 + 10) and
 * if the input array is {10, 5, 4, 3}, then output should be 10
 *  
 * msis(i) - Length of longest increasing subsequence which includes element A[i] as its last element. 

   msis(i) = 1 + Max j=1 to i-1 {LIS(j)} if A[i]>A[j] for 1<j<i
          =   1 if no such j exists. 
 */
public class MaximumSubIncreasingSubsequence {
	/*
	 * maxSumIS() returns the maximum sum of increasing subsequence in arr[] of size n
	 */
	static int maxSumIS(int arr[], int n) {
		int i,j, max = 0;
		int solution[] = new int[n];

		/* Initialize msis values for all indexes */
		for (i = 0; i < n; i++){
			solution[i] = arr[i];
		}

		/* Compute maximum sum values in bottom up manner */
		for (i = 1; i < n; i++)
			for (j = 0; j < i; j++)
				if (arr[i] > arr[j] && solution[i] < solution[j] + arr[i]){
					solution[i] = solution[j] + arr[i];
				}

		/* Pick maximum of all msis values */
		for (i = 0; i < n; i++){
			if (max < solution[i]){
				max = solution[i];
			}	
		}
		System.out.println("Array :"+Arrays.toString(solution));
		return max;
	}

	/* Driver program to test above function */
	public static void main(String args[]) {
		int arr[] = new int[] { 1, 101, 2, 3, 100, 4, 5 };
		int n = arr.length;
		System.out.println(
				"Sum of maximum sum increasing " + " subsequence is " + maxSumIS(arr, n));
	}
}
