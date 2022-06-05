package com.a.dynamic.programming;
//http://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem/
//Video - http://www.ideserve.co.in/learn/set-partition-problem-dynamic-programming
/*
 * Timecompletxity O(sum*n)
 * 
Partition problem is to determine whether a given set can be partitioned into two subsets 
such that the sum of elements in both subsets is same.

	Examples
	arr[] = {1, 5, 11, 5}
	Output: true 
	The array can be partitioned as {1, 5, 5} and {11}
	
	arr[] = {1, 5, 3}
	Output: false 
	The array cannot be partitioned into equal sum sets.
	
	1) Calculate sum of the array. If sum is odd, there can not be two subsets with equal sum, so return false.
    2) If sum of array elements is even, calculate sum/2 and find a subset of array with sum equal to sum/2.
    
    Dynamic Programming Solution
     The problem can be solved using dynamic programming when the sum of the elements is not too big. 
     We can create a 2D array part[][] of size (sum/2)*(n+1)
     
     part[i][j] = true if a subset of {arr[0], arr[1], ..arr[j-1]} has sum 
             equal to i, otherwise false
 */
public class SubSetsIsEqualsBalancedPartition {
	
	static boolean findPartition (int arr[], int n)
    {
        int sum = 0;
        int i, j;
 
        // Caculcate sun of all elements
        for (i = 0; i < n; i++)
            sum += arr[i];
 
        if (sum%2 != 0)
            return false;
 
        boolean part[][]=new boolean[sum/2+1][n+1];
 
        // initialize top row as true
        for (i = 0; i <= n; i++)
            part[0][i] = true;
 
        // initialize leftmost column, except part[0][0], as 0
        for (i = 1; i <= sum/2; i++)
            part[i][0] = false;
 
        // Fill the partition table in botton up manner
        for (i = 1; i <= sum/2; i++)
        {
            for (j = 1; j <= n; j++)
            {
                part[i][j] = part[i][j-1];
                if (i >= arr[j-1]){
                    part[i][j] = part[i][j] || part[i - arr[j-1]][j-1];
                }    
            }
        }
 
        /* // uncomment this part to print table
        for (i = 0; i <= sum/2; i++)
        {
            for (j = 0; j <= n; j++)
                printf ("%4d", part[i][j]);
            printf("\n");
        } */
 
        return part[sum/2][n];
    }
 
    /*Driver function to check for above function*/
    public static void main (String[] args)
    {
        //int arr[] = {3, 1, 1, 2, 2,1};
    	int arr[] = {1, 5, 11, 5};

    	//int arr[] = {1, 5, 3};
    	
        int n = arr.length;
        if (findPartition(arr, n) == true)
            System.out.println("Can be divided into two subsets of equal sum");
        else
            System.out.println("Can not be divided into two subsets of equal sum");
 
    }

}
