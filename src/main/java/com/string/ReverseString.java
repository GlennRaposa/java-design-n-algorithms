package com.string;

import java.util.Stack;

public class ReverseString {
	
	public static void main(String args[]){
	   String str= "GOOD";	
	   //System.out.println("TURN STRING ::"+reverseString(str));
	   //System.out.println("Use Stack STRING ::"+reverseUsingStack(str));
	   System.out.println(reverseInPLaceUsingCharacterArray(str));
	   //System.out.println("TURN STRING ::"+reverseString1(str));
	}
	
	//Best Solution Time O(n) and Space O(1)
	public static String reverseInPLaceUsingCharacterArray(String str){
        char[] arr = str.toCharArray();
        int left = 0;
        int right = arr.length -1;
		while(left < right){
			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right --;
		}
		return String.valueOf(arr);
		
	}

	//Best Solution Time O(n) and Space O(n) since we are using a string buffer to store a output
	public static String reverseString(String str){
	  int length = str.length();
	  StringBuilder builder = new StringBuilder();
	  for(int i=length-1; i>=0; i--){
		  builder.append(str.charAt(i));
	  }
	  return builder.toString();
	  
	}
	
	//Best Solution Time O(n) and Space O(n) since we are using a <STACK> to store a output
	public static String reverseUsingStack(String str){
		Stack stack = new Stack();
		StringBuffer strbuf = new StringBuffer();
		for(int i=0; i<str.length(); i++){
			stack.push(str.charAt(i));
		}
		
		for(int j=0; j<str.length(); j++){
			strbuf.append(stack.pop());
		}
		
		return strbuf.toString();
	}
	
	
	
	
	public static String reverseInPlace(String str){
		StringBuilder builder = new StringBuilder(str);
		for(int i=0; i<builder.length()/2; i++){
			char temp = builder.charAt(i);
			int othereEnd = builder.length() -i -1;
			builder.setCharAt(i, builder.charAt(othereEnd));
			builder.setCharAt(othereEnd, temp);
		}
		return builder.toString();
	}
	
	

	

}
