package com.binarysearch;

public class BinarySearchIterative {
	
	public static void main(String args[]){
		
		int[] a = {2,6,13,21,36,47,63,81,97};
		int index = binarySearch(a, a.length, 81);
		System.out.println("index ::"+index);
		
	}
	
	public static int binarySearch(int[] a, int arrlength, int value){
		
		int start = 0;
		int end = arrlength -1;
		while(start <=end){ //loop divides value n...n/2...n/4....1
			int mid = (start+end)/2;
			//case1: if a[mid] == x
			//case2: if a[mid] > x
			//case3: if a[mid] < x
			if(a[mid] == value){
				return mid;
			}else if(a[mid] > value){
				//go left
				end = mid-1;
			}else if(a[mid] < value){
				start = mid+1;
			}
		}
		return -1;
		
	}

}
