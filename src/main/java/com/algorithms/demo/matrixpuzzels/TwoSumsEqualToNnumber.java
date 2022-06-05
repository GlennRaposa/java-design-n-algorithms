package com.algorithms.demo.matrixpuzzels;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * Input : {2,7,11,15};  target : 9
 * Output : {2,7}
 * 
 * consideration 
 * Is the array sorted ? we can break it into a sub-array to traverse  only values that are lower current target
 * If not sorted then sort the Array to reduce n*m calls
 * do they have to be first two number or any two_number 
 *   
 * Approach 
 * Add first number with every other number in the array [outer_for Inner_for O(n)2] store in a local variable and compare
 * if two number match lets break the target into two number O(n*m). 
 * with the first number 
 */

public class TwoSumsEqualToNnumber {
	
	public static void main(String args[]){
		int[] a = {1,2,7,8,11,15};
		int number = 9;
		
		//int a[] = { 1, 2, 3, 4, 5, 16, 17, 18, 19, 249 };
		//int number = 253;
		
		System.out.println(sumOfTwo(a, number));
	}
	
	public static ArrayList<String> sumOfTwo(int[]nums, int target){
		ArrayList<String> list = new ArrayList<String>();
		//TODO
		//1.Validation check 
		if(nums == null || nums.length < 2 || target == 0){
			return null;
		}
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<nums.length; i++){
			if(map.containsKey(nums[i])){
				list.add("("+map.get(nums[i])+","+nums[i]+")");
			}else{
				map.put(target-nums[i], nums[i]);
			}
		}
		return list;
	}
	
}
