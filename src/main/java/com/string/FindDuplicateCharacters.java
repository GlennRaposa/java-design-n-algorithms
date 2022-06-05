package com.string;

public class FindDuplicateCharacters {
	
	public static void main(String args[]){
		String str = "Programming";
		System.out.println("Find Duplicates ::"+detectDuplicate(str));
		System.out.println("Remove Duplicates ::"+removeDuplicates(str));
	}

	//Iterative Approach Time O(n) spaceo(1)
	public static int detectDuplicate(String source) {
           boolean[] foundChars = new boolean[Character.MAX_VALUE+1];
           for(int i = 0; i < source.length(); i++) {
              char currentChar = source.charAt(i);
              if(foundChars[currentChar]) return i;
              foundChars[currentChar] = true;
           }
          return -1;
	}
	
	
	//Iterative Approach Time O(n+m) 
/*	private static char findFirstDuplicateCharacter(String str)
			throws RuntimeException {

		char[] strChars = str.toCharArray();
		int len = strChars.length;

		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (strChars[i] == strChars[j]) {
					return strChars[i];
				}
			}
		}

		throw new RuntimeException(
				"There is no duplicate character in the string.");
	}
*/	
	
	// Time O(n) by using two stringbuilder objects 
/*	private static String findDuplicates(String word) {

	    StringBuilder temp = new StringBuilder();
	    StringBuilder dup = new StringBuilder();

	    for (int i = 0; i < word.length(); i++) {
	        if (temp.indexOf("" + word.charAt(i)) == -1) {
	            temp.append(word.charAt(i));
	        }else{
	        	dup.append(word.charAt(i));
	        }
	    }

	    return dup.toString();
	}*/


	private static String removeDuplicates(String word) {

	    StringBuilder temp = new StringBuilder();

	    for (int i = 0; i < word.length(); i++) {
	        if (temp.indexOf("" + word.charAt(i)) == -1) {
	            temp.append(word.charAt(i));
	        }
	    }

	    return temp.toString();
	}
	

}
