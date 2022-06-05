package com.algorithms.tutorialhorizon.array;
import java.util.Arrays;

import com.a.dynamic.programming.ChildClimbingSteps;

public class ReverseAnArray {

	 public static void main(String args[]){
		 int[] arr = {1,2,3,4,5,6};
		 int order = 2;
		 rotate(arr, order);
		 System.out.println(Arrays.toString(arr));
	 }
	 
	 public static void rotate(int[] a, int order){
		 if(a == null|| a.length ==0 || order < 0){
			 throw new IllegalArgumentException("Illegal argument!");
		 }
		 if(order > a.length){
			 order = order %a.length;
		 }
		 
         int pivot = a.length - order;
         
          reverse(a,0,pivot-1);
          System.out.println("first reverse till pivot :"+Arrays.toString(a));
          reverse(a,pivot, a.length-1);
          System.out.println("second reverse pivot to end :"+Arrays.toString(a));
          reverse(a,0,a.length-1);
          System.out.println("third reverse start to end :"+Arrays.toString(a));
		 
	 }
	 
	 //IF we were to rverse without an order
	 //first  while {1,2,3,4,5,6} - > {6,2,3,4,5,1}
	 //second while {1,2,3,4,5,6} - > {6,5,3,4,2,1}
	 //third  while {1,2,3,4,5,6} - > {6,5,4,3,2,1}
	 public static void reverse(int[] a, int left, int right){
		 if(a == null || a.length == 0){
			 return;
		 }
		 
		 while(left <= right){
			 int temp = a[left];
			 a[left] = a[right];
			 a[right] = temp;
			 left++;
			 right --;
		 }
	 }
	 
	
}
