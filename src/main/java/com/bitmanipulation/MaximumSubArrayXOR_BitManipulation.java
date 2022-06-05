package com.bitmanipulation;
//http://massivealgorithms.blogspot.com/2015/10/find-maximum-subarray-xor-in-given.html
//http://www.geeksforgeeks.org/find-the-maximum-subarray-xor-in-a-given-array/
public class MaximumSubArrayXOR_BitManipulation {
	
	int maxSubarrayXOR(int arr[], int n)

	{

	    int ans = Integer.MIN_VALUE;     // Initialize result

	    // Pick starting points of subarrays
	    for (int i=0; i<n; i++)

	    {
	        int curr_xor = 0; // to store xor of current subarray
	 
	        // Pick ending points of subarrays starting with i

	        for (int j=i; j<n; j++)

	        {

	            curr_xor = curr_xor ^ arr[j];

	            ans = Math.max(ans, curr_xor);

	        }

	    }

	    return ans;

	}
}
