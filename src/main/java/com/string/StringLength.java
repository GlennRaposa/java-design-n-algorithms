package com.string;

public class StringLength {
	
	
	public int length(String str){
		char[] array = str.toCharArray();
		int count = 0;
		for(int i=0; i<array.length; i++){
			count++;
		}
		return count;
	}

	public static void main(String args[]) {
		StringLength strLength = new StringLength();
		int count = strLength.length("three");
		System.out.println(count);
	}

}
