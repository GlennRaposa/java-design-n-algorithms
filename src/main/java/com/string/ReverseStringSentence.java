package com.string;

import java.util.Arrays;

public class ReverseStringSentence {

	 public static void main(String aargs[]){
		 String str = "the sky is blue";
		 System.out.println("Reverse_Using_Buffer::"+process(str));
		 
		 char[] charStr = str.toCharArray();
		 reverse(charStr);
		 System.out.println("Reverse :"+Arrays.toString(charStr));
	 }
	 

	 //Correction Solution :: Time O(n) Space O(1)
	 public static void reverse(char[] s){
		 int i = 0;
		 //First Pass : Reverses words till last space ' ' but now blue is left [e, h, t,  , y, k, s,  , s, i,  , b, l, u, e]
		 for(int j=0; j<s.length; j++){
			 if(s[j] == ' '){
				 reverse(s,i,j-1);
				 i = j+1;
			 }
		 }
		 
		 //Second pass reverses blue :[e, h, t,  , y, k, s,  , s, i,  , e, u, l, b]
		 reverse(s,i,s.length-1);
		 
		 /*third pass reverses  TO 	Each Index is going to flip
		 [e, h, t,  , y, k, s,  , s, i,  , e, u, l, b]
		 [b, h, t,  , y, k, s,  , s, i,  , e, u, l, e]
		 [b, l, t,  , y, k, s,  , s, i,  , e, u, h, e]
		*/
		 reverse(s,0,s.length-1);
		 
	 }
	 
	 public static void reverse(char[] s, int left, int right){
		 while(left<right){
			 char temp = s[left];
			 s[left] = s[right];
			 s[right] = temp;
			 left++;
			 right--;
		 }
	 }
	 
	 
	 //Time O(n)  space O(n) 
	 public static String process(String sentence){
		 if(sentence == null || sentence.trim().length() == 0){
			 return null;
		 }
		 StringBuffer buf = new StringBuffer();
		 String[] arrayofWords = sentence.split(" ");
		 for(int i = arrayofWords.length -1; i>=0; i--){
			 buf.append(arrayofWords[i]);
			 if(i != 0){
				 buf.append(" ");
			 }
		 }
		 return buf.toString();
	 }
}
