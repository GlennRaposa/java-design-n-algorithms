package com.add.recursion;

public class PrintAnArrayReverse {
   
	 public static void main(String args[]){
	     int[] arr = {1,2,3,4,5};
	     printArr(arr, arr.length);
	 }
	
	 public static void printArr(int[] arr, int size){
		if(size == 0){
			return;
		}else{
			System.out.println(arr[size-1]);
			printArr(arr, size-1);
		}
	 }
}
