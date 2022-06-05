 package com.binarysearch;

public class BinarySearchFirstNLastOccurance {

   public static final String FIRST = "FIRST";
   
   public static final String LAST = "LAST";
	
   public static void main(String args[]){
		
		int[] a = {2,4,10,10,10,18,20};
		
		int Findex = binarySearch(a, a.length, 10, FIRST);
		System.out.println("FIRST_INDEX ::"+(Findex == -1 ? "Value not present in Array" : Findex ));
		
		int Lindex = binarySearch(a, a.length, 10, LAST);
		System.out.println("LAST_INDEX ::"+(Lindex == -1 ? "Value not present in Array" : Lindex ));
		
		//Count Occurences
		int occurenceCount = Lindex - Findex +1;
		System.out.println("COUNT ::"+(occurenceCount < 0 ? "Count value is 0" : occurenceCount ));
		
	}
	
	public static int binarySearch(int[] a, int arrlength, int value, String occurance){
		int result = -1;
		int start = 0;
		int end = arrlength -1;
		while(start <=end){ //loop divides value n...n/2...n/4....1
			int mid = (start+end)/2;
			//case1: if a[mid] == x
			//case2: if a[mid] > x
			//case3: if a[mid] < x
			if(a[mid] == value){
				result = mid;
				if(FIRST.equals(occurance)){
					end = mid-1;
				}else if(LAST.equals(occurance)){
					start = mid+1;
				}
			}else if(a[mid] > value){
				//go left
				end = mid-1;
			}else if(a[mid] < value){
				start = mid+1;
			}
		}
		return result;
		
	}
}
