package com.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* http://www.ideserve.co.in/learn/anagram-pattern-search
   http://www.geeksforgeeks.org/anagram-substring-search-search-permutations/

   Code from : http://www.zrzahid.com/find-anagram-of-a-string-in-another-string/
*/
//NEED TO READ THIS AGAIN 
//http://www.zrzahid.com/find-anagram-of-a-string-in-another-string/
public class AnagramSubStringPatternSearch {
	
	public static void main(String args[]){
		String str1 = "ideserve";
		String pattern = "veer";
		
		System.out.println(findAnagramicSubString(str1, pattern));
	}
	
	private static int primes[] = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

	public static Set<String> findAnagramicSubString(final String str, final String pattern) {
	    final String word = str.toLowerCase();
	    final String anagramPattern = pattern.toLowerCase();
	    final Set<String> substrings = new HashSet<String>();

	    long needleKey = 1;
	    for (int i = 0; i < anagramPattern.length(); i++) {
	        needleKey *= primes[anagramPattern.charAt(i) - 'a'];
	    }

	    final Map<Long, Integer> map = new HashMap();

	    long value = 1;
	    for (int i = 0; i < word.length(); i++) {
	        value *= primes[word.charAt(i) - 'a'];
	        if (value % needleKey == 0 && map.containsKey(value / needleKey)) {
	            substrings.add(word.substring(i - anagramPattern.length() + 1, i + 1));
	        }

	        map.put(value, i);
	    }

	    substrings.remove(anagramPattern);
	    return substrings;
	}
}
