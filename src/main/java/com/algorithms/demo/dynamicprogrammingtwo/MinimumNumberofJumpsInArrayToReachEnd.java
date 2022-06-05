package com.algorithms.demo.dynamicprogrammingtwo;

import java.util.Arrays;

/*Ideserve : https://www.youtube.com/watch?v=iT7EmidHV4o&list=PLamzFoFxwoNgG0Q5rqfTY6ovWSTAC9mbz
 (Dynamic Programming) : http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/

  In this method, we build a jumps[] array from left to right such that jumps[i] 
  indicates the minimum number of jumps needed to reach arr[0] from arr[i]. Finally, we return jumps[n-1].
  
  formula
  for into for loop iterating each jump with the next possible jump value 
  
  if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE)
  {
	 jumps[i] = Math.min(jumps[i], jumps[j] + 1);
	 break;
   }
*/
public class MinimumNumberofJumpsInArrayToReachEnd {

	// TimeComplexity O(n) :
	// http://www.programcreek.com/2014/06/leetcode-jump-game-ii-java/
	// Good Explaination https://www.youtube.com/watch?v=haU1H4yrk74
	// http://www.gorecursion.com/algorithm/2016/11/26/greedy.html
	public int GreedyAlgoJump(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int lastReach = 0;
		int reach = 0;
		int step = 0;
		// First Run i=0;
		for (int i = 0; i <= reach && i < nums.length; i++) {
			// when last jump can not read current i, increase the step by 1
			if (i > lastReach) {
				step++;
				lastReach = reach;
			}
			// update the maximal jump
			System.out.println("i ::"+i);
			reach = Math.max(reach, nums[i] + i);
		}

		if (reach < nums.length - 1)
			return 0;

		return step;
	}
	
	
	//// TimeComplexity O(n2) - Returns minimum number of jumps to reach arr[n-1] from
	public int minJumps(int[] arr){
		int[] jumps = new int[arr.length];
		int arrSize = arr.length;
		
		if(arrSize == 0 || arr[0] == 0){
			return 0;
		}
		
		for(int i=1; i<arrSize; i++){
			jumps[i] = Integer.MAX_VALUE;
			for(int j = 0; j <i; j++){
				if(i <= j+arr[j] && jumps[j] !=Integer.MAX_VALUE){
					jumps[i] = Math.min(jumps[i], jumps[j]+1);
				}
			}
		}
		return jumps[arrSize-1];
		
	}

	// Driver program to test above function
	public static void main(String args[]) {
		MinimumNumberofJumpsInArrayToReachEnd m = new MinimumNumberofJumpsInArrayToReachEnd();
		// int arr[] = { 1, 3, 6, 1, 0, 9 };
		int arr[] = { 2, 3, 1, 1, 4 };
		// System.out.println("O(N)2_1 DP jumps to reach end ::" + m.minJumps(arr));
		 System.out.println("O(N) Linear jumps to reach end ::" + m.GreedyAlgoJump(arr));

	}
}
