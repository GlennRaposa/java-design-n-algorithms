package com.algorithms.demo.lambda.unit2;

import java.util.function.BiConsumer;

public class ExceptionHandlingLabmdaExample {
	
	public static void main(String[] args){
		int[] someNumbers = {1,2,3,4};
		int key = 0;
		
		process(someNumbers, key,wrapperLambda((v,k)->System.out.println(v/k)));
		
	}

	private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer){
		for(int i : someNumbers){
			consumer.accept(i, key);
		}
	}
	
	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer){
		return (v,k) ->{
			try{
				consumer.accept(v, k);
			}catch(Exception e){
				System.out.println("Exception caught in wrapper Lambda");
			}
		};
	}
}
