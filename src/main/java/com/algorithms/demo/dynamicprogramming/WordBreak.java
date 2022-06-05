package com.algorithms.demo.dynamicprogramming;
/*
 * http://algorithms.tutorialhorizon.com/the-word-break-problem/

Objec�tive : Given an string and a dic�tio�nary of words, find out if the input string can be bro�ken 
into a space-separated sequence of one or more dic�tio�nary words.

Example:
dictionary = ["I" , "have", "Jain", "Sumit", "am", "this", "dog"]
String = "IamSumit"
Output: "I am Sumit"

String ="thisisadog"
Output : String can't be broken

Dynamic Programming Approach:
- We will use top-down  approach.
- Before we solve it for any string check if we have already solve it.
- We can use another HashMap to store the result of already solved strings.
- When�ever any recur�sive call returns false, store that string in HashMap.
 *
 */
import java.util.HashSet;

public class WordBreak {
 
	public boolean findUsingDP(String s, HashSet<String> dict, HashSet<String> memo, StringBuffer answerBuf){
		
		if(s.length() == 0){
			System.out.println(answerBuf.toString());
			return true;
		}else if(memo.contains(s)){
			return false;
		}else{
			int index = 0;
			String word = "";
			while(index < s.length()){
				word += s.charAt(index);
				if(dict.contains(word)){
					findUsingDP(s.substring(index+1), dict, memo, answerBuf.append(word).append(" "));
				}else{
					index++;
				}
			}
		}
		return false;
		
	}
		public static void main(String[] args) {
			HashSet<String> hs = new HashSet<String>();
			hs.add("this");
			hs.add("is");
			hs.add("glenn");
			hs.add("raposo");
			hs.add("standing");
			hs.add("tall");
			String s = "glennraposoisstandingtall";
			
			WordBreak ws = new WordBreak();
			
			// create another HashSet so store the sub problems result
			HashSet<String> memoization = new HashSet<String>();
			StringBuffer strBuf = new StringBuffer();
			boolean haswords = ws.findUsingDP(s, hs, memoization, strBuf);
			if(haswords){
				System.out.println("Broken words down");
			}else{
				System.out.println("CANT BREAK words down");
			}
			
		}

}
