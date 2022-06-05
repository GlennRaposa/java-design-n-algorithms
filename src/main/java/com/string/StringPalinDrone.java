package com.string;

public class StringPalinDrone {
	
	public static void main(String args[]) {
/*		System.out.println(" ONE :: "+isPalindroneRecursion("three"));
		System.out.println(" TWO :: "+isPalindroneRecursion("alpopla"));
		System.out.println(" THREE :: "+isPalindroneRecursion("FIVE"));
		System.out.println(" FOUR :: "+isPalindroneRecursion("GLEFTYUYTFELG"));*/
		
		
		System.out.println(" ONE :: "+palidrome("three"));
		System.out.println(" TWO :: "+palidrome("alpopla"));
		System.out.println(" THREE :: "+palidrome("FIVE"));
		System.out.println(" FOUR :: "+palidrome("GLEFTYUYTFELG"));
	}
	
	/*public static boolean isPalindroneRecursion(String str){
		//Base case
		 // if length is 0 or 1 then String is palindrome
		if(str.length() ==0 || str.length() ==1){
			return true;
		}
		
		 check for first and last char of String:
         * if they are same then do the same thing for a substring
         * with first and last char removed. and carry on this
         * until you string completes or condition fails
         * Function calling itself: Recursion
         
		if(str.charAt(0) == str.charAt(str.length()-1)){
			return isPalindroneRecursion(str.substring(1, str.length()-1));
		}
		return false;
	}*/

	
	//OTHER WAS TO REVERSE EXISTING STRING and Compare String Equality
	
	/*public static boolean isPalidromeIterative(String str){
		int n = str.length();
		
		for(int i=0; i<n/2; i++){
			if(str.charAt(i)!= str.charAt(n-i-1)){
				return false;
			}
		}
		return true;
		
	}*/
	
	
	public static boolean palidrome(String str){
		int length = str.length();
		for(int i=0; i<length/2; i++){
			if(str.charAt(i) != str.charAt(str.length()-1 -i)){
				return false;
			}
		}
		return true;
	}
	
}
