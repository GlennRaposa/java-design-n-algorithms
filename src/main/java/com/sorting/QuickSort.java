package com.sorting;

import java.util.Arrays;
//example from :http://www.java67.com/2014/07/quicksort-algorithm-in-java-in-place-example.html
public class QuickSort {
	
	
	public static void main(String args[]){
		int[] input = { 23, 31, 1, 21, 36, 72}; 
		System.out.println("Before sorting : " + Arrays.toString(input)); 
		quickSort(input); 
		// sort the integer array using quick sort algorithm 
		System.out.println("After sorting : " + Arrays.toString(input));

	}

	//select pivot
	//partition less values to left of pivot and greater values to right of pivot
	//now recursively takle left side sub array and select a pivot 
	//now unsortedList tackle rightside sub array
	
	public static void quickSort(int[] list){
		recursiveQuickSort(list, 0, list.length-1);
	}
	
	public static void recursiveQuickSort(int[] list, int startIndex, int endIndex){
		
		int index = partition(list,  startIndex,  endIndex);
		
		//Recursively call quicksort with left part of the partation array 
		if(startIndex < index-1){
			recursiveQuickSort(list, startIndex, index-1);
		}
		
		if(endIndex > index){
			recursiveQuickSort(list,index, endIndex);
		}
		
	}
	
	public static int partition(int[] list, int left, int right){
		int pivot = list[left];
		
		while(left <= right){
			
			//search number that are less that pivot; botton up
			while(list[left] < pivot){
				left++;
			}
			//search number that is greater that pivot
			while(list[right] > pivot){
				right --;
			}
			
			//swap
			int temp = list[left];
			list[left] = list[right];
			list[right] = temp;
			
			//increment left and decrement right 
			left++;
			right --;
		}
		return left;
		
	}

}
