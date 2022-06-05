package com.add.recursion;

/*
 * Use Recursion to Calculate SUm
 * Sum of 5 = 1+2+3+4+5
 * S(n) = value of sum from 1 to N
 * S(n) = S(n-1) + n
 */
public class CalculateSumFrom1ToN {
    
	public static void main(String args[]){
		int sum = sum(5);
		System.out.println("Sum Value ----"+sum);
	}
	public static int sum(int number){
		if(number == 1){
			return 1;
		}else{
			return sum(number-1) + number;
		}
	}
}
