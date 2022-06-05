package com.string;

import java.util.Arrays;
//http://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together/
//An Anagram has the same character set arranged in a different order
public class StringAnagram {
	
	public static void main(String args[]){
		String str1 = "DOOG";
		String str2 = "GOOD";
		System.out.println("What is this ::"+checkAnagram(str1, str2));
		
	}
	
	public static boolean checkAnagram(String str1, String str2){
		
		if(str1 == null || str2 == null){
			return false;
		}if(str1.length() != str2.length()){
			return false;
		}
		
		char[] char1 = str1.toCharArray();
		char[] char2 = str2.toCharArray();
		
		Arrays.sort(char1);
		System.out.println(Arrays.toString(char1));
		Arrays.sort(char2);
		System.out.println(Arrays.toString(char2));

		if(Arrays.equals(char1,char2)){
			return true;
		}
		
		return false;
	}

}
