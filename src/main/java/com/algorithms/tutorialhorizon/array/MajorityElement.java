package com.algorithms.tutorialhorizon.array;
/*
 * if its sorted array you could use binary search for first and last occurance. 
   in this case its not a sorted array and thus we need to use the below algo
 * http://www.ideserve.co.in/learn/find-majority-element-in-an-array
 * Moores Voting algorithm [This is a two step process.]
    1. Get an element occurring most of the time in the array. 
       This phase will make sure that if there is a majority element then it will return that only.
       
    2. Check if the element obtained from above step is majority element.
 */
import java.util.Arrays;

public class MajorityElement {

	public static Integer getMajorityElement(int[] arr){
		if(arr == null || arr.length == 0){
			return null;
		}
		Integer canadiate = null;
		int count = 0;
		//This Condition Marks counter on multiples 
		for(int i =0; i<arr.length; i++){
			if(count ==0){
				canadiate = arr[i];
				count = 1;
				continue;
			}else{
				if(canadiate == arr[i]){
					count++;
				}else{
					count--;
				}
			}
		}
		//if no multiples then return null
		if(count == 0){
			return null;
		}
		//find if counter count is greater than half of its length
		for(int i=0; i<arr.length; i++){
			if(canadiate == arr[i]){
				count++;
			}
		}
		
		return (count > arr.length/2) ? canadiate : null;
		
	}

	public static void main(String[] args) {

		int[] array = { 2, 6, 2, 2, 6, 2, 2, 8, 2, 1 };
		System.out.println(Arrays.toString(array) + " \nMajority Element: "
				+ getMajorityElement(array));

	}
}