package com.algorithms.demo.matrixpuzzels;
/*
 * http://algorithms.tutorialhorizon.com/print-all-the-permutations-of-a-string/ 
 * Input : abc
 * Output: abc acb bac bca cba cab
 * Approach : 
 * Take one character at a time and fix it at the first posi�tion. (use swap to put every character at the first position)
   make recursive call to rest of the characters.
   use swap to revert the string back to its original form for next iteration.
 * 
 *                                  ABC
 *                                  
 *        ABC                       BAC                 CBA
 * 
 * ABC        ACB              BAC      BCA          CBA      CAB          
 * 
 */
import java.util.ArrayList;

public class StringPermutation {

	public ArrayList<String> permutation(char[] arr, int start, int end, ArrayList<String> list){
		int x = 0;
		
		if(start == end){
			StringBuffer buf = new StringBuffer();
			for(int i=0; i<arr.length; i++){
				buf.append(arr[i]);
			}
			System.out.println("list append :"+buf.toString());
			list.add(buf.toString());
		}else{
		   for(x=start; x<end; x++){
			   swap(arr,start,x);
			   permutation(arr,start+1,end,list);
			   swap(arr,start,x);
		   }
		}
		return list;
	}

	public void swap(char[] arrA, int i, int j) {
		char temp = arrA[i];
		arrA[i] = arrA[j];
		arrA[j] = temp;
	}

	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		String s = "abc";
		char[] arrCh = s.toCharArray();
		StringPermutation i = new StringPermutation();
		ArrayList<String> list = new ArrayList<String>();
		System.out.println(i.permutation(arrCh, 0, arrCh.length ,list));
	}

}
