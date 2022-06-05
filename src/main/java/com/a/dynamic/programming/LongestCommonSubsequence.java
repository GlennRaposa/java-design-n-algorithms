package com.a.dynamic.programming;
//http://algorithms.tutorialhorizon.com/dynamic-programming-longest-common-subsequence/

import java.util.Arrays;

/*
 * Recursion:

Start comparing strings in reverse order one character at a time.

Now we have 2 cases -

--- Need to Proof Optimal-sub structure Exists 

case1 : Both characters are same
add 1 to the result and remove the last character from both the strings and make recursive call to the modified strings.

cas2 : Both characters are different
Remove the last character of String 1 and make a recursive call and remove the last character from String 2 and make a recursive 
and then return the max from returns of both recursive calls. see exam�ple below

Formula : Same as edit distance

Cij = c(i,0) = 0; //base case if B is null then LCS of A,B=0
      c(0,j) = 0; //base case if A is null then LCS of A,B=0
      ci-1,j-1+1 when aj==bj [when n-1 characters in each set is a match]
      Math.Max(C(i-1,j) , C(i,j-1)) 
      
 */
public class LongestCommonSubsequence {

	public static int find(char[] A, char[] B) {
		int[][] solution = new int[A.length + 1][B.length + 1];

		// base case if A is null then LCS of A,B=0
		for (int i = 0; i <= B.length; i++) {
			solution[0][i] = 0;
		}

		// base case if B is null then LCS of A,B=0
		for (int i = 0; i <= B.length; i++) {
			solution[i][0] = 0;
		}

		for (int i = 1; i <= A.length; i++) {

			for (int j = 1; j <= B.length; j++) {

				if (A[i - 1] == B[j - 1]) {
					//if characters match add value from UPPER - TOP Left Diagonal CELL + 1 to the current computational cell
					solution[i][j] = solution[i - 1][j - 1] + 1;
				}
				else {
					//Find max value of either upper/TOP cells[i-1] OR LEFT Cell.  
					solution[i][j] = Math.max(solution[i - 1][j], solution[i][j - 1]);
				}

			}
		}
		System.out.println(Arrays.deepToString(solution));
		return solution[A.length][B.length];

	}

	public static void main(String[] args) {
		String A = "ZYXWXWZY";
		String B = "WXYXZZ";
		System.out.println("LCS :" + find(A.toCharArray(), B.toCharArray()));
	}
    /*
     OUTPUT LOOKS LIKE THIS
     [
		 [0, 0, 0, 0, 0, 0, 0], 
		 [0, 0, 0, 0, 0, 1, 1], 
		 [0, 0, 0, 1, 1, 1, 1], 
		 [0, 0, 1, 1, 2, 2, 2], 
		 [0, 1, 1, 1, 2, 2, 2], 
		 [0, 1, 2, 2, 2, 2, 2], 
		 [0, 1, 2, 2, 2, 2, 2], 
		 [0, 1, 2, 2, 2, 3, 3], 
		 [0, 1, 2, 3, 3, 3, 3]
		]
		LCS :3
     */
}
