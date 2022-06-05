package com.hackerrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MissingWord {

	public static void main(String args[]){
		String s1 = "I am using hackerrank to improve programming";
		String s2 = "I am hackerrank to improve programming";
		System.out.println(missingWords(s1, s2));
		
		//Variation of the same with a number array
		int array1[] = { 1, 2, 3, 4, 5 };
		int array2[] = { 1, 2, 4, 5 };
		System.out.println(missingValue(array1, array2));
		
	}
	
	public static Set<?> missingWords(String s1, String s2) {
			
		    Set<String> missing = new HashSet<String>();
			String[] a = s1.split(" ");
			String[] b = s2.split(" ");
			
			for(int i=0, j=0; i < a.length; i++){
				if(!a[i].equals(b[j])) {
					missing.add(a[i]);
				} else {
					j++;
				}
			}
			
			return missing;
	}
	
	
	public static ArrayList<Integer> missingValue(int[] a, int[] b) {
		
	    ArrayList<Integer> missing = new ArrayList<Integer>();
		
		for(int i=0, j=0; i < a.length; i++){
			if(a[i] !=(b[j])) {
				missing.add(a[i]);
			} else {
				j++;
			}
		}
		
		return missing;
}
	
}
