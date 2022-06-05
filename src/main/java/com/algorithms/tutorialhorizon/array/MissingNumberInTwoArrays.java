package com.algorithms.tutorialhorizon.array;

public class MissingNumberInTwoArrays {

	public static void main(String args[]){
		int[] arr1 = { 1,2,3,4,5 };
		int[] arr2 = {2,3,1,0,5 };
		System.out.println(Find_Missing(arr1, arr2));
	}
	
	public static int Find_Missing(int [] array1, int [] array2)
	{
		int xor = 0;
		int i;
		for (i =0; i < array1.length; ++i)
		{
			xor ^= array1[i];
		}
		for (i =0; i < array2.length; ++i)
		{
			xor ^= array2[i];
		}
		return xor;
	}
}
