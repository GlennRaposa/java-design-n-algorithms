package com.sorting;

import java.util.Arrays;

public class BubbleSort {
	
	public static void main(String args[]){
		int input[] = {4,2,9,6,23,12,34,0,1};
		int result[] = sort(input);
		System.out.print("Sorted Result :: "+Arrays.toString(result));
		
	}
	 
	 public static int[] sort(int[] a){
		  
		 for(int i=0; i<a.length; i++ ){
			 boolean flag = false;
			 for(int j=i+1; j<a.length; j++){
				 if(a[i] > a[j]){
					 //swap
					 int temp = a[i];
					 a[i] = a[j];
					 a[j] = temp;
					 flag = true;
				 }
			 }
			 if(!flag){
				 break;
			 }
		 }
		 return a;
	 }
	 

	 
}