 package com.algorithms.demo.array;

import java.util.Arrays;

/*
 * http://www.makeinjava.com/find-second-smallest-element-array-integers-java-example/
 * use two pointer (firstSmallest, secondSmallest)
 */
public class SecondSmallestElement {
    public static void main(String[] args) {

        int[] inputArray = {2, 4, 6, 8, 10, 12};
        printSecondSmallestElement(inputArray);

        System.out.println();
        inputArray = new int[]{5, 3, 4, 1, 2};
        printSecondSmallestElement(inputArray);

        System.out.println();
        inputArray = new int[]{16, 41, 41, 9, 41, 7};
        printSecondSmallestElement(inputArray);

    }

    private static void printSecondSmallestElement(int[] inputArray) {
        int firstSmallest = inputArray[0];
        int secondSmallest = Integer.MAX_VALUE;

        for (int index = 1; index < inputArray.length; index++) {
            int currentElement = inputArray[index];
            if(firstSmallest > currentElement) {
                secondSmallest = firstSmallest;
                firstSmallest = currentElement;
            } else if(secondSmallest > currentElement && firstSmallest < currentElement) {
                secondSmallest = currentElement;
            }
        }
        String array = Arrays.toString(inputArray);
        if(secondSmallest != Integer.MIN_VALUE) {
            System.out.printf("Second Smallest element in %s is : %d",array,secondSmallest);
        } else {
            System.out.printf("There is not second Smallest element in array %s ",array);
        }
    }

}
