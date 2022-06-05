package com.binarysearch;

public class BinarySearchRecurisve {

	
   public static void main(String args[]){
		
		int[] a = {2,6,13,21,36,47,63,81,97};
		int index = binarySearch(a, 0,a.length-1, 63);
		System.out.println("index ::"+index);
	}
   
	public static int binarySearch(int[] a, int low, int high, int value){
		//Base Case
		if(low > high){
			return -1;
		}
		
		int mid = (low+high)/2;
		//case1: if a[mid] == x
		//case2: if a[mid] > x
		//case3: if a[mid] < x
		if(a[mid] == value){
			return mid;
		}else if(a[mid] > value){ //Go Left
			return binarySearch(a, low, mid-1, value);
			
		}else if(a[mid] < value){ //Go right
			return binarySearch(a, mid+1, high, value);
		}
	 return -1;			
	}
}
