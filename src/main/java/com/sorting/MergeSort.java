package com.sorting;

import java.util.Arrays;

public class MergeSort {
	
	 public static void main(String args[]){
		 int[] unsortedList = {4,45,64,28,109,25,190,2};
		 int[] sortedList =  mergesort(unsortedList);
		 System.out.println("Sorted_List:"+Arrays.toString(sortedList));
	 }
	
	
	//todo: Split the array down length/2
    // user recursive solution  -> //to keep splitting into auxillary arrays 
	// keep sorting the auxillary arrays and merging 
	
	public static int[] mergesort(int[] list){
		
		if(list.length <=1){
			return list;
		}
		
		int[] first = new int[list.length / 2];
		int[] second = new int [list.length - first.length];
		
		System.arraycopy(list, 0, first, 0, first.length);
		System.arraycopy(list, first.length, second, 0, second.length);

		
		mergesort(first);
		mergesort(second);
		
		mergeSort(first,second,list);
		
		return list;
	}
	
	public static void mergeSort(int[] first, int[] second, int[] list){
		int iFirst = 0;
		int iSecond = 0;
		int j = 0;
		
		while(iFirst < first.length && iSecond < second.length){
			if(first[iFirst] < second[iSecond]){
				list[j] = first[iFirst];
				iFirst++;
			}else{
				list[j] = second[iSecond];
				iSecond++;
			}
			j++;
		}
		
		//Copy Left over 
		System.arraycopy(first, iFirst, list, j, first.length - iFirst);
		System.arraycopy(second, iSecond, list, j, second.length - iSecond);
		
	}

 }
