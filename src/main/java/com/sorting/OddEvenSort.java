package com.sorting;
//http://www.geeksforgeeks.org/odd-even-sort-brick-sort/
import java.util.Arrays;

public class OddEvenSort {

	public static void main(String args[]) {
		OddEvenSort o = new OddEvenSort();
		int[] arr =  {3, 2, 3, 8, 5, 6, 4, 1};	
		System.out.println(""+Arrays.toString(o.oddEvenSort(arr))); 
	}

	public void swap(int[] list, int i, int j) {
		int temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}

	public int[] oddEvenSort(int[] list) {

		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			for (int i = 1; i < list.length - 1; i += 2) {
				if (list[i] > list[i + 1]) {
					swap(list, i, i + 1);
					sorted = false;
				}
			}

			for (int i = 0; i < list.length - 1; i += 2) {
				if (list[i] > list[i + 1]) {
					swap(list, i, i + 1);
					sorted = false;
				}
			}
		}
		return list;
	}
}
