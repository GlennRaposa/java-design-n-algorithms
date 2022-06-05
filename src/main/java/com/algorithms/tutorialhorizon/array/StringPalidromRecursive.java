package com.algorithms.tutorialhorizon.array;

public class StringPalidromRecursive {

	public static void main(String args[]) {
		StringPalidromRecursive sr = new StringPalidromRecursive();
		String str = "PALODOLAP";
		String str1= "Glenn1";
		System.out.println("Should BE:"+sr.isPlaidrome(str));
		System.out.println("Should not BE:"+sr.isPlaidrome(str1));
	}

	public boolean isPlaidrome(String str) {
		if (str.length() < 2) {
			return true;
		}

		if (str.charAt(0) == str.charAt(str.length() - 1)) {
			return isPlaidrome(str.substring(1, str.length() - 1));
		}
		else {
			return false;
		}
	}
}
