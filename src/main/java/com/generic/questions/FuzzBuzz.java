package com.generic.questions;

public class FuzzBuzz {
   
	private static int FIFTEEN =15;
	private static int FIVE =5;
	private static int THREE =3;
	
	
	public static void fuzzBuzz(int number){
		if(number <= 0){
			System.out.println("INVALID NUMBER");
		}
		
		if(number % FIFTEEN == 0){
			System.out.println("FUZZ BUZZ");
		}if ( number % FIVE == 0){
			System.out.println("FUZZ ");
		}if(number % THREE== 0){
			System.out.println("BUZZ");
		}
		
	}
	
	public static void main(String[] args){
	    fuzzBuzz(35);
	}
}
