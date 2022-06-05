package com.a.dynamic.programming;

import java.util.Arrays;

//http://algorithms.tutorialhorizon.com/dynamic-programming-edit-distance-problem/


/*
 * Let’s say given strings are s1 and s2 with lengths m and n respectively.

case 1: last characters are same , ignore the last character.
Recur­sively solve for m-1, n-1

case 2: last characters are not same then try all the possible operations recursively.
Insert a character into s1 (same as last character in string s2 so that last character in both the strings are same): now s1 length will be m+1, s2 length : n, ignore the last character and Recursively solve for m, n-1.

Remove the last character from string s1. now s1 length will be m-1, s2 length : n, Recursively solve for m-1, n.

Replace last character into s1 (same as last character in string s2 so that last char­ac­ter in both the strings are same): s1 length will be m, s2 length : n, ignore the last char­ac­ter and Recur­sively solve for m-1, n-1.
Choose the min­i­mum of ( a, b, c).
 */
public class EditDistance {
	
	public static int editDistance(String s1, String s2){
		//2D array for Memoization
		int[][] solution = new int[s1.length()+1][s2.length()+1];
		
		//base case
        //If any of the string if empty then number of operations
        //needed would be equal to the length of other string
        //(Either all characters will be removed or inserted)
		
		/*
		 * FORMULA
		 * 
		 * c(i,0) = i*DELETION
		 * c(0,j) = j*INSERTION
		 * 
		 * C(i,j) = min {
		 *            c(i-1,j)+DELETION,
		 *            c(i,j-1)+INSERTION
		 *            c(i-1,j-1)+SUBSTUTION
		 *            c(i-1,j-1)+COPY
		 *          }
		 */
		for(int i=0;i<s2.length();i++){
			solution[0][i] = i;  //C(0,i) = i*D
		}
		
		for(int i=0;i<s1.length();i++){
			solution[i][0] = i; //C(i,0) = i*I
		}
		
		int m = s1.length();
		int n = s2.length();
		
		for(int i = 1; i<=m;i++){
			for(int j=1; j<=n; j++){
				
				if(s1.charAt(i-1) ==s2.charAt(j-1)){
					solution[i][j] = solution[i-1][j-1];
				}else{
					//Find minimum value of all diagonals cells in the 2D array to populate this value + 1
					solution[i][j] = 1+ Math.min(solution[i][j-1],Math.min(solution[i-1][j],solution[i-1][j-1]));
				}
			}
		}
		System.out.println(Arrays.deepToString(solution));
		return solution[s1.length()][s2.length()];
	}
	
	public static void main(String[] args) {
        String s1 = "horizon";
        String s2 = "horizontal";
        System.out.println("Minimum Edit Distance -(DP): " + editDistance(s1, s2));
    }
	
	/*
	 [[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0], 
	 [1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 1], 
	 [2, 1, 0, 1, 2, 3, 4, 5, 6, 7, 2], 
	 [3, 2, 1, 0, 1, 2, 3, 4, 5, 6, 3], 
	 [4, 3, 2, 1, 0, 1, 2, 3, 4, 5, 4], 
	 [5, 4, 3, 2, 1, 0, 1, 2, 3, 4, 5], 
	 [6, 5, 4, 3, 2, 1, 0, 1, 2, 3, 4], 
	 [0, 1, 2, 3, 3, 2, 1, 0, 1, 2, 3]]
	 Minimum Edit Distance -(DP): 3
	*/
}
