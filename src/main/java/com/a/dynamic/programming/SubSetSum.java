package com.a.dynamic.programming;
/*
 * https://www.youtube.com/watch?v=5td2QH-x5ck
 * http://algorithms.tutorialhorizon.com/dynamic-programming-subset-sum-problem/
 * http://www.ideserve.co.in/learn/subset-sum-dynamic-programming
 * Objective: Given a set of positive integers, and a value sum S, find out if there exist 
 *             a subset in array whose sum is equal to given sum S.
 *  
 * Example : int[] A = { 3, 2, 7, 1}, S = 6
			Output: True, subset is (3, 2, 1}
			
	Approach: Dynamic Pro�gram�ming (Bottom-Up)

	Base Cases:
	
	If no elements in the set then we can�t make any subset except for 0.
	If sum needed is 0 then by returning the empty subset we can make the subset with sum 0.
	
	Given � Set = arrA[], 
	        Size = n, 
	        sum = S
	
	Now for every element in the set we have 2 options, either we include it or exclude it.
	for any ith element�
	If include it => S = S-arrA[i], n=n-1
	If exclude it => S, n=n-1.
	Recursive Equation:
	
	Base Cases:
	SubsetSum(arrA, n, S)= false, if sum > 0 and n == 0
	SubsetSum(arrA, n, S)= true, if sum == 0 (return empty set)
	
	Rest Cases
	SubsetSum(arrA, n, S) = SubsetSum(arrA, n-1, S)|| SubsetSum(arrA, n-1, S-arrA[n-1])		
	
	 How to track the elements.
     Start from the bottom-right cor�ner and back�track and check from the True is coming.
	 If value in the cell above if false that means cur�rent cell has become true after includ�ing the cur�rent ele�ment. \
	 So include the cur�rent ele�ment and check for the sum = sum � cur�rent element.
 */
public class SubSetSum {
	
	public static void main(String[] args) {
		int[] A = { 3, 2, 7, 1};
		System.out.println("\nFrom DP: " + subSetDP(A, 6) );
	}
	
	public static boolean subSetDP(int[] A, int sum) {
		boolean[][] solution = new boolean[A.length + 1][sum + 1];		
		// if sum is not zero and subset a[] is 0, we can't make it 
		for(int i=1;i<=sum;i++){
			solution[0][i]=false;
		}
		
		// if sum is 0 the we can make the empty subset to make sum 0
		for(int i=0;i<=A.length;i++){
			solution[i][0]=true;
		}
		//
		for(int i=1;i<=A.length;i++){
			for(int j=1;j<=sum;j++){				
				//first copy the data from the top
				solution[i][j] = solution[i-1][j];
				
				//forward the truth values and see if element can be substracted from sum
				if(solution[i][j]==false && j>=A[i-1])
					//take truth value if first is true || else take it from cell by minus'ing sum-a[i-1] cell 
					solution[i][j] = solution[i][j] || solution[i-1][j-A[i-1]];				
			}
		}		
		return solution[A.length][sum];
	}
}
