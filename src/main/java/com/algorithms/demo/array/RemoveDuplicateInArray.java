package com.algorithms.demo.array;

import java.util.Arrays;

public class RemoveDuplicateInArray {

	public static void main(String args[]) {
		int[] num = {1, 1, 2, 2, 3, 4, 5};
		int[] result = removeDuplicates(num);
		System.out.println(Arrays.toString(result));
	}
	
	public static int[] removeDuplicates(int[] numbersWithDuplicates) {

        // Sorting array to bring duplicates together      
        Arrays.sort(numbersWithDuplicates);     
      
        int[] result = new int[numbersWithDuplicates.length];
        System.out.println(Arrays.toString(result));
        
        int previous = numbersWithDuplicates[0];
        result[0] = previous;

        for (int i = 1; i < numbersWithDuplicates.length; i++) {
            int ch = numbersWithDuplicates[i];
            //System.out.println("previous:"+previous+" result[i]:"+result[i]+" ch:"+ch);

            if (previous != ch) {
                result[i] = ch;
            }
            previous = ch;
        }
        return result;

      }
      //output : initialize Array -> [0, 0, 0, 0, 0, 0, 0] - > process array -> {1, 1, 2, 2, 3, 4, 5} result ->  [1, 0, 2, 0, 3, 4, 5]
    }
   
