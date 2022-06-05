package com.a.dynamic.programming;

public class RodCutting {
	/*
	 * Input Rod of size Xs
	 * Output Best cut for Most Gains 
	 * Approach
	 * Use Dynamic programming (Memoization + recursion)
	 * 	c(i) = optimal cut
	 *	Vk = Optimal Price for the cut
	  		
	 *  say C(i) is the first cut and C(j) is the last cut 
	 *  sub problem C(i..k)  C(k+1...j) 
	 *  
	 *  Formula: C(i) = Math.MAX{Vk + C(i-k+1)};
	 *  
	 *  C(4) = MAX{
	 *           V1 + C(4-1),  
	 *           V2 + C(4-2),
	 *           V3 + C(4-3),
	 *           V4 
	 *         }
	 *  So lets have an original table with Cuts & prices 
	 *  and not compute another table for C(i) best cuts and price 
	 */
	
	
   public static int profit(int[] V, int length){
	   int[] c = new int[length +1];
	   c[0] = 0;
	   
	   for(int i=1; i<=length; i++){
		   int max = -1;
		   //values for each subproblem from Ci...k
		   for(int k=0;k<i; k++){ //This would recurse MAx
			   
			   max = Math.max(max, (V[k] + c[i-(k+1)]));
			   c[i] = max;
		   }
	   }
	   return c[length];
   }

	
	public static void main(String[] args) {
		int[] value = { 2, 3, 7, 8, 9 };
		int len = 5;
		System.out.println("Max profit for length is " + len + ":"
				+ profit(value, len));

		//System.out.println((3+1)%4);
	}
}
