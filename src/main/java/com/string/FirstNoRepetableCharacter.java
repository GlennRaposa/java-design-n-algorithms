package com.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNoRepetableCharacter {
	
	public static void main(String args[]){
		String str = "aabbcddeeffg";
		System.out.println("First Non Repetable ::"+getFirstNonRepeatingCharacterLinearOptimized(str));
	}
	
	//TIME O(n)  SPACE O(1)
	public static Character getFirstNonRepeatingCharacterLinearOptimized(String string) {
        if(string == null || string.length() == 0) {
            return null;
        }
         
        int n = string.length();
        int[] charIdx = new int[256];   // Index of non repeating characters. If repeating, then index = -2
        // Initialize character index of all characters to -1
        for(int i = 0; i < 256; i++) {
            charIdx[i] = -1;
        }
         
        for(int i = 0; i < n; i++) {
            if(charIdx[string.charAt(i)] == -1) {
                // character seen first time
                charIdx[string.charAt(i)] = i;
            } else {
                // Repeated character
                charIdx[string.charAt(i)] = -2;
            }
        }
        
        System.out.println(Arrays.toString(charIdx));
        int minIdx = n; // Index of first non repeating character
        for(int i = 0; i < 256; i++) {
            if(charIdx[i] >= 0 && 
                    minIdx > charIdx[i]) {
                minIdx = charIdx[i];
            }
        }
        return (minIdx >= 0 && minIdx < n) ? string.charAt(minIdx) : null;
    }
	
	
	
	
	//TIME O(n)  SPACE O(n)
	public static Character printFirstNoNRepetable(String str){
		if(str == null || str.trim().length() ==0){
			return null;
		}

		Queue<Character> repetable = new LinkedList<Character>();
		Queue<Character> nonRepetable = new LinkedList<Character>();
		
		char[] charArr = str.toCharArray();
		
		for(int i =0; i<charArr.length; i++){
			
			if(nonRepetable.contains(charArr[i])){
			      nonRepetable.remove(charArr[i]);
			      repetable.add(charArr[i]);
			}else{
				nonRepetable.add(charArr[i]);
			}
			
		}
		System.out.println(nonRepetable.size());
		
		return nonRepetable.poll();
	}

}
