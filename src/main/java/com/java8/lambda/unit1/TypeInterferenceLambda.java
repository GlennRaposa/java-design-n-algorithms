package com.java8.lambda.unit1;

public class TypeInterferenceLambda {
	
	public static void main(String args[]){
		printLambda(s -> s.length());
	}
	
	public static void printLambda(StringLengthLambda l){
		System.out.println(l.getLength("HELLO STRING LEN LAMBDA"));
	}
	
	interface StringLengthLambda{
		 int getLength(String s);
	}

}
