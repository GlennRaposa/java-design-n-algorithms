package com.algorithms.tutorialhorizon.array;
/*
Objective : You have been asked to Write an algorithm Find a Missing Number From a Sequence of Consecutive Numbers

Input:  Array, arrA[] with a missing number and Range

Output : missing number

Approach:

Approach is very simple, Add all the given numbers say S
Calculate sum of N numbers by formula n(n+1)/2 , say N
Find missing number m = N-S

Example : suppose array given is  {1,2,3,4,5,6,8,9,10} and range is 10.

So N will be sum of 1 to 10  = 10(10+1)/2 = 55

S will be sum of all the array elements which is = 48

So missing number will be = 55–48 = 7

*/
public class FindMissingNumber {
	int sum;
	int sum_n;
	
	public static void main(String args[]){
		FindMissingNumber fnum = new FindMissingNumber();
		int [] arrA = {1,2,3,4,5,7,8,9,10};
		System.out.println(fnum.missingNumber(arrA, 10));
	}
	
	
	public  int missingNumber(int[] arr, int n){
		sum_n = n *(n+1)/2;
		for(int i=0; i<arr.length;i++){
			sum +=arr[i]; 
		}
		System.out.println("SUM_N:"+sum_n+" sum:"+sum);
		return sum_n-sum;
	}
}
