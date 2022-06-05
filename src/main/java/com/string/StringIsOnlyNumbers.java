package com.string;

import java.util.regex.Pattern;

public class StringIsOnlyNumbers {
	
	public static void main(String args[]){
		Pattern pattern = Pattern.compile(".*[^0-9].*");
		
		String [] inputs = {"123", "-123" , ".12", "abcd123"};
	      
	       for(String input: inputs){
	           System.out.println( "Is the Input  " + input + " is number : "
	                                + !pattern.matcher(input).matches());
	       }

	}

}
