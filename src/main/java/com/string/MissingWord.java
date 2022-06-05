package com.string;

import java.util.ArrayList;

public class MissingWord {

	public static void main(String args[]){
		String s1 = "I am using hackerrank to improve programming";
		String s2 = "I am hackerrank to improve programming";
		System.out.println(missingWords(s1, s2));
	}
	
	public static ArrayList<String> missingWords(String s1, String s2) {
			
		    ArrayList<String> missing = new ArrayList<String>();
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
	
}
