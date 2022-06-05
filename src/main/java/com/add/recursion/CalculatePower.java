package com.add.recursion;

public class CalculatePower {
   
	public static void main(String args[]){
		int num = powerOf(2, 6);
		System.out.println(num);
	}
	
	
	public static int powerOf(int x, int n){
		int temp = 1;
		if(n ==0){
			return 1;
		}	
		temp = powerOf(x,n/2);
		if(n%2 == 0){
			return (temp * temp);
		}else{
			return ( x*temp*temp);
		}
		
	}
}
