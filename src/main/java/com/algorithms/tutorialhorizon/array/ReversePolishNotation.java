package com.algorithms.tutorialhorizon.array;

import java.util.Stack;

//http://www.programcreek.com/2012/12/leetcode-evaluate-reverse-polish-notation/
public class ReversePolishNotation {

	public int eval(String[] arr){
		int returnValue = 0;
		String operators = "+-*/";
		
		Stack<String> stack = new Stack<String>();
		
		for(String str : arr){
			if(!operators.contains(str)){
				stack.push(str);
			}else{
				int a = Integer.parseInt(stack.pop());
				int b = Integer.parseInt(stack.pop());
				int index = operators.indexOf(str);
				switch(index){
				case 0:
					stack.push(String.valueOf(a+b));
					break;
				case 1:
					stack.push(String.valueOf(b-a));
					break;
				case 2:
					stack.push(String.valueOf(a*b));
					break;
				case 3:
					stack.push(String.valueOf(b/a));
					break;	
				}
			}
		}
		returnValue = Integer.parseInt(stack.pop());
		return returnValue;
		
	}
	
	public static void main(String args[]){
		String [] arr =   {"2", "1", "+", "3", "*"}; //-> ((2 + 1) * 3) -> 9
		//  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
		ReversePolishNotation reversePolish = new ReversePolishNotation();
		System.out.println(reversePolish.eval(arr));
	}
	
}
