package com.algorithms.demo.array;

import java.util.HashSet;
import java.util.Set;

public class FindOnlyElementIntheArrayThatDosentAppearTwice {
	
	public static void main(String args[]){
		int arr[] = {1,1,2,2,3,4,4,5,5,6,6};
		
		System.out.println(findSingle_XOR(arr));
		//System.out.println(findSingle_HashMap(arr));
	}

	public static int findSingle_XOR(int[] arr){
		int result = 0;
		for (int a : arr){
			System.out.println("result:"+result+" a:"+a);
		    result ^= a;
		    System.out.println("result:"+result);
		}    
		
		return result;
	}
	
	public static int findSingle_HashMap(int[] array) {

	    Set<Integer> set = new HashSet<Integer>();

	    for (int item : array) {
	        if (!set.remove(item)) {
	            set.add(item);
	        }
	    }       

	    assert set.size() == 1;
	    return set.iterator().next();
	}
}
