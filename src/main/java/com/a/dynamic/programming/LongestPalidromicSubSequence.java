package com.a.dynamic.programming;

import java.util.Arrays;

/*
 * http://algorithms.tutorialhorizon.com/longest-palindromic-subsequence/
 * 
 * What is Longest Palindromic Subsequence: A longest palindromic subsequence is a sequence that appears in the same relative order, 
 * but not necessarily contiguous(not sub�string) and palindrome in nature( means the subsequence will read same from the front and back.
 * Example:
   String A = " AABCDEBAZ";
   Longest Palindromic subsequence: ABCBA or ABDBA or ABEBA
   
   Dynamic Programming Optimal Substructure:

   Given Sequence A[0�.n-1]....LPS[0�.n-1] be the longest palindromic subsequence of the given sequence.

   Check the first and the last characters of the sequence. Now there are two possibilities, 
   either both the characters same or distinct. We will have to handle both the case.
     case1: If both characters are same, add 2 to the result and remove both the characters and 
            solve the problem for the remaining subsequence .
            LPS[i][j] = 2 + LPS[i-1, j-1]
            
     case2 : If both characters are different, then solve the problem twice, ignore the first character 
     (keep the last character)and solve the remaining subsequence and then ignore the last character (keep the first character) 
     and solve it and pick the best out of two results.        
            MAX(LPS[i+1,j], LPS[i, j-1])
            
    Recusion Cases:
     LPS[i, i]	=	1	 -- Every single character is a palindrome by itself of length 1
     LPS[i, j]	=	2	 -- if j=i+1, sequence has only 2 characters
     LPS[i, j]	=	2 + LPS[i-1, j-1]   -- If first and last characters are same
     LPS[i, j]	=	MAX(LPS[i+1,j], LPS[i, j-1]) --If first and last characters are not same        
     
     
 */
public class LongestPalidromicSubSequence {
	public int findPalindrome(String A){
		char [] chars = A.toCharArray();  //Convery string to character array..
		int [][]solution = new int[chars.length][chars.length]; 
		//LP[i][j] - length of palindrome from ith index to jth index
		// all the characters in the string are palindrome by itself of length 1.
		//So all LP[i][i] =  1 
		for(int i=0;i<chars.length;i++){
			solution[i][i] = 1;			
		}
		// Build the table. Note that the lower diagonal values of table are
        // useless and not filled in the process. The values are filled in a
        // manner similar to Matrix Chain Multiplication DP solution
		for(int sublen = 2;sublen<=chars.length;sublen++){
			for(int i=0;i<=solution.length-sublen;i++){
				int j = i+sublen-1;
				//case1: if string has only 2 characters in this case checks AA and is called only once
				if(chars[i]==chars[j] && sublen==2){
					solution[i][j] = 2;
				}//case2 : if first and last character is same 
				else if(chars[i]==chars[j]){
					solution[i][j] = solution[i+1][j-1]+2;
				}//case3: if first and last character is different then copy value of max last computed
				else{
					solution[i][j] = Math.max(solution[i+1][j],solution[i][j-1]);
				}
			}
		}
		System.out.println(Arrays.deepToString(solution));
		return solution[0][solution.length-1];
		
	}
	
	public static void main(String arg[]){
		String strA = "AABCDEBAZ";
		LongestPalidromicSubSequence i = new LongestPalidromicSubSequence();
		int x = i.findPalindrome(strA);
		System.out.println("Length of Longest Palindrome in '" + strA + "' is " + x);
	}
}
