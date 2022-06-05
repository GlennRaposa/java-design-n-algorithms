package com.string;

import java.util.HashMap;
import java.util.Map;

/*
 * http://www.programcreek.com/2014/05/leetcode-isomorphic-strings-java/
 Two words are called isomorphic if the letters in one word can be remapped to get the second word. 
 Remapping a letter means replacing all occurrences of it with another letter. The ordering of the letters remains unchanged. 
 No two letters may map to the same letter, but a letter may map to itself.
 For example, the words "abca" and "zbxz" are isomorphic because we can map 'a' to 'z', 'b' to 'b' and 'c' to 'x'. 
 */
public class IsomorphicStrings {

	public static void main(String args[]){
		System.out.println("isomorphic(abca, zbxz) : "+isomorphic("abca", "zbxz")); //Match
		System.out.println("isomorphic(foo, bar) : "+isomorphic("foo", "bar"));  // Not a match 
		System.out.println("isomorphic(fot, bar) : "+isomorphic("fot", "bar"));  // Match 
	}
	
	public static boolean isomorphic(String s, String t) {
		if(s == null || t == null || s.length() != t.length()){
			return false;
		}else if(s.trim().length() == 0 && t.trim().length() == 0){
			return true;
		}
		Map<Character, Character> map = new HashMap<Character, Character>();
		for(int i = 0;i<s.length(); i++){
			if(map.containsKey(s.charAt(i))){
				if(map.get(s.charAt(i)) != t.charAt(i)){
					return false;
				}
			}else{
				// For example, the words "abca" and "zbxz" are isomorphic because we can map 'a' to 'z', 'b' to 'b' and 'c' to 'x'. 
				map.put(s.charAt(i), t.charAt(i));
			}
		}
		
		return true;
	}
}
