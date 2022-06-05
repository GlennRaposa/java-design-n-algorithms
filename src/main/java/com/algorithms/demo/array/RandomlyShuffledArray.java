package com.algorithms.demo.array;

import java.util.Arrays;
import java.util.Random;

//Randomly Shuffled Array relates to Random card shuffel
//IN order to generate a random number wew use math.random This method will return value between 
public class RandomlyShuffledArray {
	
	public static void main(String args[]){
		String[] strCharacters = {"A","B","C","D","E"};
		
		int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println("Shuffled ::"+Arrays.toString(shuffleArray(a)));
       
	}
	
	//Another Approach [http://www.vogella.com/tutorials/JavaAlgorithmsShuffle/article.html]
    public static int[] shuffleArray(int[] a) {
        int n = a.length;
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < n; i++) {
                int change = i + random.nextInt(n - i);
                swap(a, i, change);
        }
        return a;
	}
	
	private static void swap(int[] a, int i, int change) {
	        int helper = a[i];
	        a[i] = a[change];
	        a[change] = helper;
	}

	
	
}
