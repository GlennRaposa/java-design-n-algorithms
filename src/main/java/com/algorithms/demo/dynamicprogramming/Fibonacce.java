 package com.algorithms.demo.dynamicprogramming;

import java.util.Map;

public class Fibonacce {

	//F(n) = F(n-1) + F(n-2)
	//1,1,2,3,5,8,13,21,34,55
    public static int fib(int number, Map<Integer,Integer> memo){
    	//Base case
    	if(number == 0 || number == 1){
    		return 1;
    	}

    	//If memo has a value then return 
    	if(memo.get(number) != null){
    		return memo.get(number);
    	}
    	
    	//Else
    	memo.put(number, fib(number-1, memo)+fib(number-2, memo));
    	
    	return memo.get(number);
    }
    
    
    
    //Sum of Fib F0+F1+F2....F(n-1) = S(n-1)
    //S(n-1)= F(n-1) - 1
    //S(n)=Fib(n+2)-1
    public static int SumOfNthfib(int n, Map<Integer, Integer> memo){
    	if(n == 0 || n == 1){
    		return 1;
    	}
    	
    	if(memo.get(n) != null){
    		return memo.get(n);
    	}
    	
    	//Else
    	return memo.put(n, SumOfNthfib((n-1)+2, memo));
    }
    
    //Fibonacce Iterative solution
    public static int getFibonacci(int n) {
        if(n < 0) {
            throw new IllegalArgumentException("n cannot be negative!");
        }
        if(n == 0 || n == 1) 
            return n;
        int a = 0, b = 1;
        int c = a+b;
        for(int i = 2; i <= n; i++) {
            c = a+b;
            a = b;
            b = c;
        }
        return c;
    }
    
    public static void main(String args[]) {
    	//Map<Integer,Integer> memo = new HashMap<Integer,Integer>();
    	//System.out.println("FIB VALUE ::"+fib(5, memo));
    }
}
