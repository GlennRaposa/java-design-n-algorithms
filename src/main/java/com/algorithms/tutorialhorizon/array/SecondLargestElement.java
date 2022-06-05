package com.algorithms.tutorialhorizon.array;

import java.util.Arrays;
//http://www.makeinjava.com/find-second-largest-element-array-integers-java-example/
public class SecondLargestElement {

    public static void main(String[] args) {
        int[] inputArray = {2, 4, 6, 8, 10, 12};
        printSecondLargestElement(inputArray);
    }

    private static void printSecondLargestElement(int[] inputArray) {
        int firstLargest = inputArray[0];
        int secondLargest = Integer.MIN_VALUE;

        for (int index = 1; index < inputArray.length; index++) {
            int currentElement = inputArray[index];
            if (firstLargest < currentElement) {
                secondLargest = firstLargest;
                firstLargest = currentElement;
            } else if (secondLargest < currentElement && firstLargest > currentElement) {
                secondLargest = currentElement;
            }
        }

        String array = Arrays.toString(inputArray);
        if (secondLargest != Integer.MIN_VALUE) {
            System.out.printf("Second Largest element in %s is : %d", array, secondLargest);
        } else {
            System.out.printf("There is not second largest element in array %s ", array);
        }
    }
}
