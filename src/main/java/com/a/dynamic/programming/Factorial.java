package com.a.dynamic.programming;

public class Factorial {
	
	 public static void main(String args[]) {
	    	System.out.println("Factorial VALUE ::"+factorial(5));
	 }
	 
	 //Factorial n! = n * n-1
	 public static int factorial(int number){
		 if(number == 0 || number == 1){
			 return 1;
		 }
		 
		 return number * factorial(number -1);
		 
	 }
}
