package com.a.matrix.puzzels.question;

import java.util.Arrays;

//http://algorithms.tutorialhorizon.com/dynamicprogrammingminimumcostpathproblem/
//http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
/*
 * Objective : Given a 2Dmatrix where each cell has a cost to travel. 
 * You have to write an algorithm to find a path from lefttop cor�ner to bottomright cor�ner with min�i�mum travel cost. 
 * You can move only right or down.
 * 
 * -----------Optimal Substructure------------
      The path to reach (i, j) must be through one of the 3 cells: (i-1, j-1) or (i-1, j) or (i, j-1). 
      So minimum cost to reach (i, j) can be written as �minimum of the 3 cells plus cost[i][j]�.
      minCost(i, j) = cost[i][j] + min (minCost(i-1, j-1), minCost(i-1, j), minCost(i, j-1))  
 * 
 * Approach
 * Given: arrA[][].
   At every cell, we have two options (go right or down) and we will choose the minimum of these two.
   So for any i,j cell

   solution[i][j] = A[0][j] if i=0 , 
   first row= A[i][0] if j=0, 
   first column= A[i][j] + Min(solution[i-1][j] , solution[i][j-1]) if i>0 && j>0
 */
public class MinimumCostPath2DMatrix {
	
	public static int find(int[][] a){
		int solution[][] = new int[a.length][a.length];
		solution[0][0] = a[0][0];
		
		//fill out first row
		for(int i= 1; i<a.length; i++){
		 solution[0][i] = a[0][i] + solution[0][i-1];
		}
		
		//fill out first column
		for(int i=1; i<a.length; i++){
			solution[i][0] = a[i][0] + solution[i-1][0]; 
		}
		
		//System.out.println(Arrays.deepToString(solution));
		
		for(int i=1; i<a.length;i++){
			for(int j = 1; j<a[0].length; j++){
				solution[i][j] = a[i][j]+min(solution[i-1][j-1], solution[i-1][j], solution[i][j-1]);
			}
		}
		return solution[a.length-1][a.length-1];
	}
	
	/* A utility function that returns minimum of 3 integers */
    private static int min(int x, int y, int z)
    {
        if (x < y)
            return (x < z)? x : z;
        else
            return (y < z)? y : z;
    }
	
	
	public static void main(String[] args) {
		/*
		 //This solution doesnt work now that i have added solution[i-1][j-1], for this to work Uncomment 1A
		 int[][] A = { { 1, 7, 9, 2 }, { 8, 6, 3, 2 }, { 1, 6, 7, 8 },
				{ 2, 9, 8, 2 } };
	    System.out.println("Minimum Cost Path " + find(A));*/
		
		 int cost[][]= {{1, 2, 3},
                 {4, 8, 2},
                 {1, 5, 3}};
         System.out.println("minimum cost to reach (2,2) = " +
                                   find(cost));
		
	}

	
}
