package com.algorithms.demo.array;

import java.util.Arrays;

//http://www.geeksforgeeks.org/maximum-difference-between-two-elements/
/*
 Observation:
 Given an array arr[] of integers, 
 find out the difference between any two elements such that larger element appears after the smaller number in arr[].
 
 Approach:
 First find the difference between the adjacent elements of the array and store all differences 
 in an auxiliary array diff[] of size n-1. Now this problems turns into finding the maximum sum subarray of this difference array.
 */
public class MaximumDifference 
{
    int maxDiff(int arr[], int n) 
    {
        // Create a diff array of size n-1. The array will hold
        //  the difference of adjacent elements
        int diff[] = new int[n - 1];
        for (int i = 0; i < n - 1; i++)
        {	
        	System.out.println("arr[i + 1]:"+arr[i + 1]+"   arrr[i]:"+arr[i]);
            diff[i] = arr[i + 1] - arr[i];
        }   
        // Now find the maximum sum subarray in diff array
        int max_diff = diff[0];
        for (int i = 1; i < n - 1; i++) 
        {
            if (diff[i - 1] > 0) 
                diff[i] += diff[i - 1];
            if (max_diff < diff[i])
                max_diff = diff[i];
        }
        System.out.println(Arrays.toString(diff));
        return max_diff;
    }
 
    // Driver program to test above functions
    public static void main(String[] args) 
    {
        MaximumDifference mxdif = new MaximumDifference();
        int arr[] = {80, 2, 6, 3, 100};
        int size = arr.length;
        System.out.println(mxdif.maxDiff(arr, size));
    }
}
