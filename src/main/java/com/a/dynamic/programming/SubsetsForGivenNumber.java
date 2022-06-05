package com.a.dynamic.programming;
//http://algorithms.tutorialhorizon.com/print-all-possible-subsets-with-sum-equal-to-a-given-number/
/*
 * http://algorithms.tutorialhorizon.com/print-all-possible-subsets-with-sum-equal-to-a-given-number/
 * Example N=4  Output value can be [1111,112,121,13,211,22,31,4]
   
   Approach:
   This prob­lem is quite sim­i­lar to Print All Sub­sets of a given set.

    Loop through i=1 to N.
    Add i to the result and make a recursive call to (N-i).
    Base case: when n becomes 0
 */
public class SubsetsForGivenNumber {
	
	public static void print(int n, String x){
		if(n==0){
			System.out.println(x);
			return;
		}else{
			for(int i=1;i<=n;i++){
				x = x + i;				
				print(n-i,x);
				x = x.substring(0,x.length()-1);
			}
		}
	}
	public static void main(String[] args) {
		int n =4;
		print(n,"");

	}

}
