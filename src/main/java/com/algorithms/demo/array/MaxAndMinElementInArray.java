 package com.algorithms.demo.array;

import java.util.Arrays;

//http://www.makeinjava.com/find-maximum-minimum-element-array-java-example/
public class MaxAndMinElementInArray {

	private static void printMinMax(int[] arr) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int element = 0; element < arr.length; element++) {

			if (min > arr[element])
				min = arr[element];
			if (max < arr[element])
				max = arr[element];
		}
		System.out.printf("Min value : %d & Max value: %d\n", min, max);
	}
	
	public static void main(String[] args) {

		int arr[] = { 5, 10, 40, 35, 20 };
		String sArray = Arrays.toString(arr);
		System.out.printf("1. Minimum & Maximum value in array %s\n",sArray);
		printMinMax(arr);

	}
	
}
