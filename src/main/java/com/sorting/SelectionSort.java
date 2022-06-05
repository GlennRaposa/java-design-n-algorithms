package com.sorting;

import java.util.Arrays;

public class SelectionSort {

	
	public static void main(String args[]){
		int input[] = {10,34,2,56,7,67,88,42};
		int result[] = sort(input);
		System.out.print("Selection Sort Result :: "+Arrays.toString(result));
		
	}
	
	//Two loops sorted and unsorted section
	//set min variable and keep swapping the unsorted side till we find min variable 
	public static int[] sort(int[] a){
		for(int i = 0; i<a.length; i++){
			int min = i;
			for(int j=i; j<a.length; j++){
				if(a[j] < a[min]){
					int temp = a[min];
					a[min] = a[j];
					a[j] = temp;
				}
			}
		}
		return a;
	}
	
}
