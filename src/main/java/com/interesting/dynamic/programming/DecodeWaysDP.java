package a.com.interesting.dynamic.programming;

import java.util.Arrays;

//https://www.youtube.com/watch?v=aCKyFYF9_Bg
//https://www.youtube.com/watch?v=RgrCL-wU110
//http://www.gorecursion.com/algorithm/2016/11/20/1d-dynamic1.html
/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:
'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example, Given encoded message �12�, it could be decoded as �AB� (1 2) or �L� (12).

The number of ways decoding �12� is 2.

*/
public class DecodeWaysDP {
	
	private static int dp(String s){
		int n = s.length();
		int[] fn = new int[n+1];
		
		fn[0] = 1;
		fn[1] = s.charAt(0) != '0' ? 1 : 0;
		
		for(int i = 1; i<n; i++){
			if(s.charAt(i) != 0){
				fn[i+1] = fn[i];
			}
			int v = Integer.parseInt(s.substring(i-1, i+1));
			if(v >= 10 && v <= 26){
				fn[i+1] += fn[i-1];
			}
		}
		return fn[n];
	}
	
	public static void main(String args[]){
		System.out.println("BOOO_ ----: "+dp("12"));
		
	}
}
