package com.a.dynamic.programming;
//https://www.youtube.com/watch?v=H7WymG3gab0
//http://www.ideserve.co.in/learn/square-root-of-a-number
/*
 * give number 1024 find its square root 
 * use binary search to keep diving the value till we get value * value = 1024
 */
public class SquareRootForGivenNumber {

	public static String findSquareRoot(int number) {
		Boolean isNegative = false;
		if (number < 0) {
			number = -number;
			isNegative = true;

		}

		if (number == 1) {
			return number + (isNegative ? "i" : "");
		}

		double start = 0;
		double end = number;
		double mid = start + end / 2;
		double prevMid = 0;
		double diff = Math.abs(mid - prevMid);
		double precision = 0.0005;

		while ((mid * mid != number) && (diff > precision)) {
			if (mid * mid > number) {
				end = mid;
			}
			else {
				start = mid;
			}
			prevMid = mid;
			mid = start + end / 2;
			diff = Math.abs(mid - prevMid);
		}

		return mid + (isNegative ? "i" : "");

	}

	public static void main(String[] args) {
		int number = 1024;
		System.out.println("Square root of " + number + " = " + findSquareRoot(number));
	}

}
