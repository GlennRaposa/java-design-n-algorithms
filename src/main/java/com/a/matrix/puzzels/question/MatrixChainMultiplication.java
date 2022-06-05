package com.a.matrix.puzzels.question;
/*
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/MatrixMultiplicationCost.java
 * http://www.geeksforgeeks.org/dynamic-programming-set-8-matrix-chain-multiplication/
 * https://www.youtube.com/watch?v=vgLJZMUfnsU
 * 
 * Given a sequence of matrices, find the most efficient way to multiply these matrices together. 
 * The problem is not actually to perform the multiplications, 
 * but to decide in which order to perform the multiplications to get best cost
 * 
 * We have many options to multiply a chain of matrices because matrix multiplication is associative. 
 * In other words, no matter how we parenthesize the product, the result will be the same. F
 * or example, if we had four matrices A, B, C, and D, we would have:
    (ABC)D = (AB)(CD) = A(BCD) = ....

    Minimum number of multiplication needed to multiply a chain of size n = Minimum of all n-1 placements 
   ----Optimal Solution Dynamic Programming------ : 
      Assume we have matrix from Ai....... Aj
      break up into subproblems between Ai..K  and Ak+1...j 
      
      is ther a better way to Multiple Ai...k
      we want to find which K returns the fewest number of multiplication
      
      M[i,j]is the is the cost of multiplying from Ai...Aj
      
      P = dimensions
      
      M[i,j] = M[i,k]+ M[K+1,j] + Pi-1*Pk*Pj;
      
      Range i less then equals to k less that equal to j
      
      
   ----Optimal Substructure:
   A simple solution is to place parenthesis at all possible places, calculate the cost for each placement and return the minimum value. 
   In a chain of matrices of size n, we can place the first set of parenthesis in n-1 ways. For example, if the given chain is of 4 matrices. 
   let the chain be ABCD, then there are 3 ways to place first set of parenthesis outer side: (A)(BCD), (AB)(CD) and (ABC)(D). 
   So when we place a set of parenthesis, we divide the problem into subproblems of smaller size. 
   Therefore, the problem has optimal substructure property and can be easily solved using recursion.
 */
public class MatrixChainMultiplication {
	
	    // Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
	    static int MatrixChainOrder(int p[], int arrSize)
	    {
	        int m[][] = new int[arrSize][arrSize];
	        int cost;
	        
            //Fill out diagonal values in the 2D array with ZERO multiplication with itself
	        for (int i = 1; i < arrSize; i++){
	            m[i][i] = 0;
	        }
	 
	        for (int lengthOfChain=2; lengthOfChain<arrSize; lengthOfChain++)
	        {
	            for (int i=1; i<arrSize-lengthOfChain+1; i++)
	            {
	                int j = i+lengthOfChain-1;
	                if(j == arrSize) continue;
	                m[i][j] = Integer.MAX_VALUE;
	                for (int k=i; k<=j-1; k++)
	                {
	                    cost = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
	                    if (cost < m[i][j]){
	                        m[i][j] = cost;
	                    }    
	                }
	            }
	        }
	 
	        return m[1][arrSize-1];
	    }
	    
	    
	 
	    public static void main(String args[])
	    {
	        int arr[] = new int[] {1, 2, 3, 4};
	        int size = arr.length;
	 
	        System.out.println("Minimum number of multiplications is "+MatrixChainOrder(arr, size));
	    }

}
