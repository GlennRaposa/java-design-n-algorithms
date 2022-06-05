package com.a.dynamic.programming;

import java.util.HashMap;

/*
 You are given a large string. You need to cut the string into chunks such that each substring that you get is a palindrome.
 Remem\ber that each 1 length string is always a palindrome. You need to find the minimum number of cuts that you need to 
 make such that each substring is a palindrome.
 
 String x = "xabaay"
	5 cuts makes all the substrings palindrome : x, a, b, a, a, y
	4 cuts makes all the substrings palindrome : x, a, b, aa, y
	3 cuts makes all the substrings palindrome : x, aba, a, y
	Output: 3 cuts
	
 ---------------Using Recursion ----------------
	We need to try all the cuts which makes all the sub­strings palin­drome and then we will choose the min­i­mum num­ber of cuts required.
	Check if entire string is palin­drome, if yes then return 0 ( no cuts required).
	If step 1 fails means it’s not a palin­drome then split the string into two parts in every pos­si­ble way 
	(ex: String is “xaab” then all pos­si­ble splits are “x, aab” , “xa, ab”, “xaa, b”) 
	and solve these two parts recur­sively till sub­string not found to be a palin­drome. 
	Each time you make a split, add 1 to num­ber of cuts.
	Choose the min­i­mum cuts in step 2.
	See the dia­gram for more understanding.	
	
------------Using Dynamic Programming -------------------
	As we have see in the dia­gram above many prob­lems are solved repeat­edly. So we can apply the Top-down approach.
	We will use Hash Map and store the solu­tion of sub prob­lems. So every time we make a cut, we check whether 
	we have already solved the sub prob­lem by check­ing its entry in Hash Map, if yes then use it and if not then solve 
	it and store it in HashMap for future use.
	Now this way every prob­lem will be solved only once. Time Com­plex­ity will be num­ber of sub prob­lems so it will O(N2).

 */
public class PalidromeSplitDP {
	static HashMap<String,Integer> solutions = new HashMap<String, Integer>();
    //1. Hash Map and store the solution of sub problems.
	//2. iterate over the length of the word
	//3  Split the string into leftPart and rightPart and recursively solve each part
	//4. cuts  = Math.min(1+ leftSolution  + rightSolution,cuts);

	public int splitDP(String x){
		if(x=="" || isPalindrome(x)){
//			System.out.println(x);
			return 0;
		}else{
			int cuts = Integer.MAX_VALUE;
			for (int i = 1; i <x.length() ; i++) {
					int leftSolution =0;
					int rightSolution = 0;
					String leftPart = x.substring(0,i);
					String rightPart = x.substring(i,x.length());
					if(solutions.containsKey(leftPart)){
						leftSolution = solutions.get(leftPart);
					}else{
						leftSolution = splitDP(leftPart);
						solutions.put(leftPart,leftSolution);
					}
				if(solutions.containsKey(rightPart)){
					rightSolution = solutions.get(rightPart);
				}else{
					rightSolution = splitDP(rightPart);
					solutions.put(rightPart,rightSolution);
				}
				cuts  = Math.min(1+ leftSolution  + rightSolution,cuts);
			}
			return cuts;
		}
	}
    //Simple solution but NOT the best TIME_COMPLEXITY 
	public int splitRecursion(String x){
		if(x=="" || isPalindrome(x)){
//			System.out.println(x);
			return 0;
		}else{
			int cuts = Integer.MAX_VALUE;
			for (int i = 1; i <x.length() ; i++) {
				cuts  = Math.min(1+ splitRecursion(x.substring(0, i)) + splitRecursion(x.substring(i, x.length())),cuts);
			}
			return cuts;
		}
	}
	public boolean isPalindrome(String s){
		int n = s.length();
		  for (int i=0;i<(n / 2) + 1;++i) {
		     if (s.charAt(i) != s.charAt(n - i - 1)) {
		         return false;
		     }
		  }
		  return true;
	}

	public static void main(String[] args) {
		String a = "cdcdddcdadcdcdcd";
		PalidromeSplitDP s = new PalidromeSplitDP();
		long startTime = System.currentTimeMillis();
		System.out.println("Recursion- Cuts Required: " + s.splitRecursion(a));
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("Recursion- Time Taken(ms): " + elapsedTime);
		startTime = System.currentTimeMillis();
		System.out.println("Dynamic Programming- Cuts Required: "+  s.splitDP(a));
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("Dynamic Programming- Time Taken(ms): " + elapsedTime);

	}
	

}
