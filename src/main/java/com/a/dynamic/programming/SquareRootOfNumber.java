package com.a.dynamic.programming;
//http://algorithms.tutorialhorizon.com/dynamic-programming-minimum-numbers-are-required-whose-square-sum-is-equal-to-a-given-number/
/*
 Objective: Given a number, Write an algorithm to find out minimum numbers required whose square is equal to the number.
 Given Number: 12
  Numbers whose sum of squares are equal to 12.
  12+12+12+12+12+12+12+12+12+12+12+12 = 12  (each 2 is a square)
  22+22+22 = 12 (each 2 is a square)
  32+12+12+12 = 12 (each 2 is a square)
  Answer: 3 numbers (2,2,2)
  
  Approach
  Given Number: N

  Find the square root of a given number ‘N’ and take the integer part of it, say it is ‘x’

  Now numbers from 1 to x are the options which can be used, whose square sum is equal to N.
  
 */
public class SquareRootOfNumber {
	
	public static void main(String args[]){
		SquareRootOfNumber nbr = new SquareRootOfNumber();
		nbr.solve(12);
	}
	
	
	public void solve(int n) {
		int options = (int) Math.sqrt(n);
		//solve using recursion
		System.out.println("solveRecursively:: "+solveRecursively(n, options));
		System.out.println("solveUsingDP :: "+solveUsingDP(n, options));
	}

	public int solveRecursively(int n, int options) {
		if (n <= 0) {
			return 0;
		}
		int min = solveRecursively(n - 1 * 1, options);
		for (int i = 2; i <= options; i++) {
			if (n >= i * i) {
				min = Math.min(min, solveRecursively(n - i * i, options));
			}
		}
		return min + 1;
	}
	
	//DYNAMIC PROGRAMMING SOLUTION
	public int solveUsingDP(int n, int options) {
		int MN[] = new int[n+1]; // Minimum numbers required whose sum is = n
		MN[0] = 0; // if number is 0 the answer is 0.
		int[] NUM = new int[options+1];
		
		// solve in bottom up manner
		for (int number = 1; number <= n; number++) {
			// reset the NUM[] for new i
			for (int j = 0; j <= options; j++) {
				NUM[j] = 0;
			}
			// now try every option one by one and fill the solution in NUM[]
			for (int j = 1; j <= options; j++) {
				// check the criteria
				if (j * j <= number) {
					// select the number, add 1 to the solution of number-j*j
					NUM[j] = MN[number - j * j] + 1;
				}
			}
			
			//Now choose the optimal solution from NUM[]
			MN[number]=-1;
            for(int j=1;j<NUM.length;j++){
                if(NUM[j]>0 && (MN[number]==-1 || MN[number]>NUM[j])){
                	MN[number]=NUM[j];
                }
            }
		}
		return MN[n];
	}

}
