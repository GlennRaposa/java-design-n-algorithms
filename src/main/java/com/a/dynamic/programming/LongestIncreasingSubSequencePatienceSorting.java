package com.a.dynamic.programming;

import java.util.Arrays;

/*
 * https://github.com/IDeserve/learn/blob/master/LongestIncreasingSubsequence.java
 * https://www.youtube.com/watch?v=1RpMc3fv0y4
 * 
 * Approach : 
 * Have Auxillary Arrays that will contain the increasing sub sequence and parent of the element 
 * 
 * current > last  Append Current if greater than last element in the increasinngSub Array
 * current<= last  Replace element in the increasinngSub Array
 * 
 * Rule1: Append if Greater
 * Rule2: Replace if Smaller
 * 
 * X = {3,1,5,2,6,4,9}
 */
//TIME COMPLEXITY O(n log n) 
public class LongestIncreasingSubSequencePatienceSorting {
	
	public static void LIS(int X[])
	{
		int parent[]= new int[X.length]; //Tracking the predecessors/parents of elements of each subsequence.
		int increasingSub[]= new int[X.length + 1]; //Tracking ends of each increasing subsequence.
		int length = 0; //Length of longest subsequence.
		
		for(int i=0; i<X.length; i++)
		{
			//Binary search
			int low = 1;
			int high = length;
			while(low <= high)
			{
				int mid = (int) Math.ceil((low + high)/2);
				if(X[increasingSub[mid]] < X[i])
					low = mid + 1;
				else
					high = mid - 1;
			}
			
			int pos = low;
			//update parent/previous element for LIS
			parent[i] = increasingSub[pos-1];
			//Rule1: Append if Greater  RULE2: Replace is smaller
			increasingSub[pos] =  i;
			
			//Update the length of the longest subsequence.
			if(pos > length)
				length=pos;
		}
		System.out.println("parentarr"+Arrays.toString(parent));
		//Generate LIS by traversing parent array
		int LIS[] = new int[length];
		int k 	= increasingSub[length];
		System.out.println("K start value ::"+k);
		for(int j=length-1; j>=0; j--)
		{
			LIS[j] =  X[k];
			k = parent[k];
			System.out.println("LIS[j]  ::"+LIS[j]+"  K::"+k);
		}
		
		
		System.out.println(Arrays.toString(LIS));
	
	}
	

	
	public static void main(String args[])
	{
		int X[] = {3,1,5,2,6,4,9};
		LIS(X);
	}

}
