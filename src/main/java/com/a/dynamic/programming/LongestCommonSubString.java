package com.a.dynamic.programming;

import java.util.Arrays;

//http://algorithms.tutorialhorizon.com/dynamic-programming-longest-common-substring/
/*
Objective: Given two string sequences write an algorithm to find, find the length of longest substring present in both of them.
Example:
String A = "tutorialhorizon";
String B = "dynamictutorialProgramming";
Output: Length of Longest Common Substring: 8 ("tutorial")

Base Cases: If any of the string is null then LCS will be 0.
Check if ith character in one string A is equal to jth character in string B
Case 1: both characters are same
LCS[i][j] = 1 + LCS[i-1][j-1] (add 1 to the result and remove the last character from both the strings and check the result for the smaller string.)
Case 2: both characters are not same.
LCS[i][j] = 0
At the end, traverse the matrix and find the maximum element in it, This will the length of Longest Common Substring.
 */
public class LongestCommonSubString {

	public static void main(String args[]) {
		String A = "tutorialhorizon";
		String B = "dynamictutorialProgramming";		
		System.out.println("LCS length : " + longestCommonSubString(A.toCharArray(), B.toCharArray()));
	}

	public static int longestCommonSubString(char[] a, char[] b){
		int solution[][] = new int[a.length+1][b.length+1];
		
		//Enter zero
		for(int i = 0; i<=b.length; i++){
			solution[0][i] = 0; 
		}
		
		for(int i = 0; i<=a.length; i++){
			solution[i][0] = 0; 
		}
		
		for(int i=1; i<=a.length; i++){
			for(int j=1; j<=b.length; j++){
				if(a[i-1] == b[j-1]){
					//Add Value from UPPER Diagonal CELL +1 for every match 
					solution[i][j] = solution[i-1][j-1]+1;
				}else{
					solution[i][j] = 0;
				}
			}
		}
		
		int result = -1;
		for(int i=0; i<=a.length; i++){
			for(int j=0; j<=b.length; j++){
				if(result < solution[i][j]){
					result = solution[i][j];
				}
			}
		}
		//System.out.println(Arrays.deepToString(solution));
		return result;
	}

}

/*  This is What the OUTPUT LOOKS LIKE 
	[[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], 
	 [0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], 
	 [0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], 
	 [0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], 
	 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0], 
	 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0], 
	 [0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0], 
	 [0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0], 
	 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], 
	 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], 
	 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0], 
	 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0], 
	 [0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0], 
	 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], 
	 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0], 
	 [0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0]]
	 LCS length : 8
*/