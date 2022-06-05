package com.algorithms.tutorialhorizon.array;

//http://www.ideserve.co.in/learn/find-a-peak-element-in-an-array
//https://www.youtube.com/watch?v=a7D77DdhlFc
	
/*
 Objective : In this article we will discuss an algorithm to Find a peak element in a Given Array. 
 We will see the recursion techniques to solve this problem.

Peak Element: peak element is the element which is greater than or equal to both of its neighbors.

Approach: (Binary Search)

1. Initialize start = 0, end = array.length - 1
2. Repeat following steps till peak element is found:
   a). Find mid = (start+end)/2
   b). If array[mid] is peak element, return array[mid]
   c). Else if array[mid-1] > array[mid], find peak in left half of array
       set end = mid - 1
   d). Else find peak in right half of array
       set start = mid + 1
 */
//Time Complexity: O(log n)
public class PeakElementInArray {

    public static Integer findPeakElement(int [] arr){
    	
    	if(arr == null || arr.length == 0){
    		return null;
    	}
    	int n = arr.length;
    	int start = 0;
    	int end = n -1;
    	
    	while(start <= end){
    		int mid = (int)Math.ceil(start+end/2);
    		
    		if((mid == 0 || arr[mid-1] <= arr[mid]) && (mid == n-1 || arr[mid] >= arr[mid+1])){
    			return mid;
    		}else if(mid > 0 && arr[mid-1] > arr[mid]){
    			end = mid-1;
    		}else{
    			start = mid+1;
    		}
    	}
    	return null;
    	
 
    }

	// Driver method
	public static void main(String[] args) {
		int[] arr = { 1,4,3,6,7,5};  // output : 4
		// int[] arr = { 15, 20, 25, 35, 45, 50, 60 }; // output NULL NO INDEX
		int peakIndex = findPeakElement(arr);
		System.out.println("PeakIndex is:"+peakIndex+" with value of peak point:"+arr[peakIndex]);
	}
}
