package com.sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String args[]){
		int input[] = {23,42,4,16,8,15};
		
		//int result[] = sort_ascending(input);
		int result[] = sort_asc(input);
		System.out.print("Selection Sort Result :: "+Arrays.toString(result));
	}
	
	public static int[] sort_asc(int[] a){
		for(int i=0; i<a.length; i++){
			int next = a[i];
			int j = i;
			while(j>0 && a[j-1] > next){
				a[j] = a[j-1];
				  
				j--;
			}
			a[j] = next; 
		}
		return a;
	}
	
	
	public static int[] sort_ascending(int[] a){
		//Start ant 1 as we are moving the first element in the sorted portion 
		for(int i =1; i<a.length;i++ ){
			// keeping track of our place in the unsorted array
			int next = a[i];  //next represents the number we are moving into the sorted portion 
			int j = i; //j is the index into the unsorted portion
			
			while( j> 0 && a[j-1] > next){
				a[j] = a[j-1];
				j--;
			}
			a[j] = next;
			
		}
		return a;
	}
	
	
	public static int[] sort_decending(int[] a){
		//Start ant 1 as we are moving the first element in the sorted portion 
		for(int i =1; i<a.length;i++ ){
			// keeping track of our place in the unsorted array
			int next = a[i];  //next represents the number we are moving into the sorted portion 
			int j = i; //j is the index into the unsorted portion
			
			while( j> 0 && a[j-1] < next){
				a[j] = a[j-1];
				j--;
			}
			a[j] = next;
			
		}
		return a;
	}
	
}
