package com.a.dynamic.programming;
/*
 http://algorithms.tutorialhorizon.com/dynamic-programming-stairs-climbing-puzzle/
 Objective: A child is climbing up a staircase with n steps, and can hop either 1 step, 2 steps, or 3 steps at a time. 
 Implement a method to count how many possible ways the child can jump up the stairs.

Example:

Number of stairs : 3

Number of ways = 4 ( {1,1,1}, {1,2}, {2,1}, {3} )
Approach:

Say child has to take n steps.
At every step the child has 3 options, to take 1 step, 2 step or 3 steps.
So if child take 1 step then find the number of ways to complete n-1 steps +1.
Similarly if child take 2 steps then find the number of ways to complete n-2 steps +1.
If child take 3 step then find the number of ways to complete n-3 steps +1.
So total number of ways to complete n steps = 
No of ways to complete (n-1)steps + No of ways to complete (n-2)steps + No of ways to complete (n-3)steps +1.
 */
public class ChildClimbingSteps {
   public static void main(String args[]){
	   ChildClimbingSteps c = new ChildClimbingSteps();
	   int num = 10;
	   int[] memoization = new int[num+1];
	   System.out.println(c.countPaths(num,memoization));
   }
   
   
   public int countPaths(int steps, int[] memo){
		//Base case
		if(steps < 0){
			return 0;
		}
		if(steps == 0){
			return 1;
		}
		if(memo[steps] == 0){
		  memo[steps] = countPaths(steps-1, memo) + countPaths(steps-2, memo) + countPaths(steps-3 , memo);
		}
		return memo[steps];
   }
}
