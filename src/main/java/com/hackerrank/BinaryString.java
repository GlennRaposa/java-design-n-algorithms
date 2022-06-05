package com.hackerrank;

import java.util.Arrays;

//https://www.hackerrank.com/challenges/30-bitwise-and/tutorial
public class BinaryString {
    
    public BinaryString(String string){
        for( byte b : string.getBytes() ){
            System.out.print(Integer.toBinaryString(b) + " ");
        }
        System.out.println();
    }
    
    public BinaryString(Integer integer){
        System.out.println(Integer.toBinaryString(integer));
    }
    
    //BITWISE OR OPERATOR 
    public BinaryString(String string, Integer integer){
        String binaryInteger = Integer.toBinaryString(integer);
        
        for( byte b : string.getBytes() ){
            // Perform a bitwise operation using byte and integer operands, save result as tmp:
            int tmp = b | integer; 
            System.out.println( Integer.toBinaryString(b) + " OR " + Integer.toBinaryString(integer) 
                + " = " + Integer.toBinaryString(tmp) + " = " + tmp );
        }
    }
    
    

    
    public static void main(String[] args) {
    	byte[] b = "HackerRank".getBytes();
    	System.out.println(Arrays.toString(b));
    	
        //new BinaryString("HackerRank");
        //new BinaryString(8675309);
    	new BinaryString("HackerRank", 8675309);
    }
}
