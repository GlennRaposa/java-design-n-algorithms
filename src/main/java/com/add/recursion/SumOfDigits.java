package com.add.recursion;

public class SumOfDigits {

	public static void main(String args[]){
		int num = sumOfDigits(123);
		System.out.println("Addition=----------"+num);
	}
	
	public  static int sumOfDigits(int num){
		if(num/10 == 0){
			return (num);
		}else{
			System.out.println("num%10="+num%10+" num/10="+num/10);
			return(num%10 + sumOfDigits(num/10));
		}
	}
}
