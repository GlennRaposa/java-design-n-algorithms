package com.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//FIND A BETTER EXAMPLE FOR CUSTOM SORT I DONT LIKE THIS ONE
public class CustomSort {

	public static void main(String[] args) {
		int[] arr = { 5, 3, 1, 2, 2, 2, 2, 2, 2, 2, 6, 6, 6, 6, 6, 5, 4 };
		customSort(arr);
	}
	
	static void customSort(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> numbers = new ArrayList<>();
		
		for (int i : arr) {
			if(map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
			
			
			if (!numbers.contains(i)) {
				numbers.add(i);
			}
		}
		
		Collections.sort(numbers);
		
		List<Integer> returning = new ArrayList<>(numbers);
		int count = 1;
		while(!returning.isEmpty()) {
			returning = print(returning, map, count);
			count++;
		}

	}
	
	static List<Integer> print(List<Integer> numbers, Map<Integer, Integer> map, int howManyItens) {
		List<Integer> returning = new ArrayList<>();
		
		for (Integer integer : numbers) {
			if(map.get(integer) == howManyItens) {
				for (int i = 1; i <= howManyItens; i++) {
					System.out.println(integer);
				}
			} else {
				returning.add(integer);
			}
		}
		
		return returning;
	}
}
