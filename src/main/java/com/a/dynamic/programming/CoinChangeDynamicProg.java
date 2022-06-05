package com.a.dynamic.programming;
/*
 //http://algorithms.tutorialhorizon.com/dynamic-programming-coin-change-problem/
 Objective: Given a set of coins and amount, 
 Write an algorithm to find out how many ways we can make the change of the amount using the coins given.
 
 Create a solution matrix. (solution[coins+1][amount+1]).

Base Cases:
if amount=0 then just return empty set to make the change, so 1 way to make the change.
if no coins given, 0 ways to change the amount.
Rest of the cases:

For every coin we have an option to include it in solution or exclude it.
check if the coin value is less than or equal to the amount needed, if yes then we will find ways by including that coin and excluding that coin.
Include the coin: reduce the amount by coin value and use the sub problem solution (amount-v[i]).
Exclude the coin: solution for the same amount without considering that coin.
If coin value is greater than the amount then we can’t consider that coin, so solution will be without considering that coin.

Equation::
solution[coins+1][amount+1]  

                =	0	if i=0
solution[i][j]	=	1	if j=0
                =	solution[i — 1][j] + solution[i][j — v[i — 1]]	if(coin[i]<=j)
                =	solution[i — 1][j];	if(coin[i]>j)
*/
/*
 */
import java.util.Arrays;

public class CoinChangeDynamicProg {
    
	public static int dynamic(int[] v, int amount){
		int[][] solution = new int[v.length+1][amount+1];
		
		//if amount is 0 then just set one into first column[one way to make change]
		for(int i =0; i<=v.length;i++){
			solution[i][0] = 1;
		}
		
		//if coins=0 then just set zero in first row
		for(int i =1; i<=amount;i++){
			solution[0][i] = 0;
		}
		
		//fill the rest of the matrix
		for(int aCoin=1; aCoin<=v.length; aCoin++){
			for(int currAmt=1; currAmt<=amount; currAmt++){
				if(v[aCoin-1] <= currAmt){  //if(coin[i]<=j)
					solution[aCoin][currAmt] = solution[aCoin-1][currAmt] + solution[aCoin][currAmt - v[aCoin-1]];
				}else{ // if(coin[i] > j)
					solution[aCoin][currAmt] = solution[aCoin-1][currAmt];
				}
				
			}
		}
		System.out.println(Arrays.deepToString(solution));
		return solution[v.length][amount];

	}
	
	public static void main(String[] args) {
		int amount = 5;
		int[] v = { 1, 2, 3 };
		System.out.println("By Dynamic Programming " + dynamic(v, amount));
		
		/*
		 * ArrayOutput
		 * [[1, 0, 0, 0, 0, 0], 
		 *  [1, 1, 1, 1, 1, 1], 
		 *  [1, 1, 2, 2, 3, 3], 
		 *  [1, 1, 2, 3, 4, 5]
		 *  ]
		 */
	}
}
