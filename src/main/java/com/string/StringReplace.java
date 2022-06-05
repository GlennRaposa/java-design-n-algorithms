package com.string;

public class StringReplace {
	public static String replace(String oldStr, String newStr, String input) {
		StringBuilder sb = new StringBuilder();
		int i;  int prev = 0;
		
		while ((i = input.indexOf(oldStr, prev)) >= 0) {
			
			sb.append(input.substring(prev, i)).append(newStr);
			
			prev = i + oldStr.length();
		}
		
		sb.append(input.substring(prev));
		
		return sb.toString();
	}

	public static void main(String args[]) {
		String str = "ILL ME QUICK";
		System.out.println(replace("I", "O", str));
		// output: OLL ME QUOCK

		String str1 = "ILL ME QUICK";
		System.out.println(replace("ILL", "OOO", str1));
		// output : OOO ME QUICK
	}
}
