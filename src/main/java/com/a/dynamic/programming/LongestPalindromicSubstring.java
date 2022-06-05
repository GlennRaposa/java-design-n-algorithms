package com.a.dynamic.programming;
//https://github.com/IDeserve/learn/blob/master/LongestPalindromicSubstring.java
public class LongestPalindromicSubstring {
	
	public static String LPS(String s) {
		  int n = s.length();
		  int palindromeBeginsAt = 0; //index where the longest palindrome begins
		  int max_len = 1;//length of the longest palindrome
		  boolean palindrome[][] = new boolean[n][n]; //boolean table to store palindrome truth
		  
		  //CaseONE: Trivial case: single letter palindromes
		  for (int i = 0; i < n; i++) {
			  palindrome[i][i] = true;
		  }
		  
		  //caseTWO : Finding palindromes of two characters.
		  for (int i = 0; i < n-1; i++) {
		    if (s.charAt(i) == s.charAt(i+1)) {
		      palindrome[i][i+1] = true;
		      palindromeBeginsAt = i;
		      max_len = 2;
		    }
		  }
		  
		  //caseTHREE : Finding palindromes of length 3 to n and saving the longest
		  for (int sublen = 3; sublen <= n; sublen++) {
		    for (int i = 0; i < n-sublen+1; i++) {
		      int j = i+sublen-1;
		      if (s.charAt(i) == s.charAt(j) //1. The first and last characters should match 
		    	  && palindrome[i+1][j-1]) //2. Rest of the substring should be a palindrome
		      {
		    	palindrome[i][j] = true; 
		        palindromeBeginsAt = i;
		        max_len = sublen;
		      }
		    }
		  }
		  return s.substring(palindromeBeginsAt, max_len + palindromeBeginsAt);
		}

	public static void main(String args[])
	{
		System.out.println(LPS("bananas"));
	}
}