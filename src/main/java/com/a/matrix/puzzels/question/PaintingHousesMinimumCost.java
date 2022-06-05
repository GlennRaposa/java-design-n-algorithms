package com.a.matrix.puzzels.question;

import java.util.Arrays;

/*
 solution :: http://karmaandcoding.blogspot.com/2012/02/house-coloring-with-red-blue-and-green.html
 There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. 
 The cost of painting each house with a certain color is different. You have to paint all the houses such 
 that no two adjacent houses have the same color.

Note: Painting house-1 with red costs different from painting house-2 with red. The costs are different for each house and each color.
The cost of painting each house with a certain color is represented by a n x 3 cost matrix. 
 
Approach: RED=0 GREEN=1 BLUE=2
Dynamic Programming solution:
we can paint the ith house with blue, red or green.
so we have the following equations:
cost[i,r] = min( cost[i-1,b], cost[i-1,g] ) + cost of painting i with r.
cost[i,g] = min( cost[i-1,b], cost[i-1,r] ) + cost of painting i with g.
cost[i,b] = min( cost[i-1,r], cost[i-1,g] ) + cost of painting i with b.

 
 ---------------------------
HOUSES    R      G       B
---------------------------
1         7      5       10 
---------------------------
2         3      6        1
---------------------------
3         8      7       4
--------------------------
4         6      2       9
--------------------------
5         1      4       7
--------------------------
6         2      3       6
--------------------------
Cost matrix leading to the solution: 
		0 0 0 
		7 5 10 
		8 13 6 
		14 13 12 
		18 14 22 
		15 22 21 
		23 18 21 
 */
public class PaintingHousesMinimumCost {
 
	public static void main(String[] args) {
		  int [][] costMatrix = {{7, 5, 10},
		          {3, 6, 1},
		          {8, 7, 4},
		          {6, 2, 9},
		          {1, 4, 7},
		          {2, 3, 6},
		         };
		  int cost = calcHouseColoringCost(costMatrix);
		  System.out.println("Cost of coloring the house is: " + cost);
		 }
		  
		 public static int calcHouseColoringCost(int [][] M) {
		  int finalCost = 0;
		  int r = M.length+1;
		  int c = M[0].length;
		  int [][] solution = new int[r][c];
		   
		  for (int i=0; i<c; i++) {
		   solution[0][i] = 0;
		  }
		   
		  for (int i=1; i<r; i++) {
		   solution[i][0] = Math.min(solution[i-1][1], solution[i-1][2]) + M[i-1][0];
		   solution[i][1] = Math.min(solution[i-1][2], solution[i-1][0]) + M[i-1][1];
		   solution[i][2] = Math.min(solution[i-1][0], solution[i-1][1]) + M[i-1][2];
		  }
		  //System.out.println(C[r-1][0]);
		  //System.out.println(C[r-1][1]);
		  //System.out.println(C[r-1][2]);
		  
          //Post for loop Iteration now get min values from the last row[last houses painted] [232,18,21] answer=18  
		  finalCost = Math.min(Math.min(solution[r-1][0], solution[r-1][1]), solution[r-1][2]);
		  //printing the DP matrix.
		  System.out.println("Cost matrix leading to the solution: "+Arrays.deepToString(solution));
		  
		  return finalCost;
		 }
}

/*
  OUTPUT 
  Cost matrix leading to the solution: 
 [ [0, 0, 0], 
   [7, 5, 10], 
   [8, 13, 6], 
   [14, 13, 12], 
   [18, 14, 22], 
   [15, 22, 21], 
   [23, 18, 21]
]
Cost of coloring the house is: 18
*/