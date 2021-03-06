package com.algorithms.demo.binarysearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BinarySearchString {
    public static final int NUM_SAMPLES = 10;
    
    public static void main(String[] args) throws FileNotFoundException {
         correctnessTest();
        //timingTests();     
    }
    
    public static int binarySearch(String[] words, String value) {
        return binarySearch(words, value, 0, words.length - 1);
    }
    
    /**
     * Searches an array of words for a given value using a recursive binary 
     * search.  Returns the index that contains the value or -1 if the value 
     * is not found.
     * @param words
     * @param value
     * @return
     */    
    public static int binarySearch(String[] words, String value, int min, int max) {
        if (min > max) {
            return -1;
        }
        
        int mid = (max + min) / 2;
        
        if (words[mid].equals(value)) {
            return mid;
        } else if(words[mid].compareTo(value) > 0) {
            return binarySearch(words, value, min, mid - 1);
        } else {
            return binarySearch(words, value, mid + 1, max);
        }
    }
    
    /**
     * Searches an array of words for a given value in a linear fashion.  
     * Returns the index that contains the value or -1 if the value is not found.
     * @param words
     * @param value
     * @return
     */
    public static int linearSearch(String[] words, String value) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(value)) {
                return i;
            }
        }
        
        return -1;
    }    
    
    public static void correctnessTest() {
        String[] array = {"bear", "bird", "cat", "dog", "fish", "koala", "lion", "tiger", "turtle", "zebra"};
        System.out.println("array = " + Arrays.toString(array));
        
        String[] queries = {"cat", "lion", "koala", "tiger", "zebra", "bear", "dolphin", "eagle", "rat"};
        for (String s : queries) {
            System.out.println("search for " + s + " = " + binarySearch(array, s));
        }
    }
    
    public static void timingTests() throws FileNotFoundException {
        String[] smallWords = readFileSorted("students.txt", 256);
        timingTest(smallWords);
        
        System.out.println();

        String[] mediumWords = readFileSorted("anthem.txt", 22082);
        timingTest(mediumWords);
        
        System.out.println();

        String[] largeWords = readFileSorted("clarissa.txt", 985725);
        timingTest(largeWords);           
    }
    
    public static void timingTest(String[] words) {
        long linearStartTime, estimatedLinearTime = 0;        
        long binaryStartTime, estimatedBinaryTime = 0;

        System.out.println("n = " + words.length);
        
        Random rand = new Random();
        
        // search the array N times and time it with each method
        for (int n = 0; n < NUM_SAMPLES; n++) {
            // get a random word in the array
            int randomValue = rand.nextInt(words.length);
            
            // linear search (timed)
            linearStartTime = System.nanoTime();  
            int linearIndex = linearSearch(words, words[randomValue]);
            estimatedLinearTime += System.nanoTime() - linearStartTime;
            
            // binary search (timed)
            binaryStartTime = System.nanoTime();  
            int binaryIndex = binarySearch(words, words[randomValue]);
            estimatedBinaryTime += System.nanoTime() - binaryStartTime;        
        }
        
        // print the results and average time for each search
        System.out.println("Linear Search: " + estimatedLinearTime / NUM_SAMPLES + " ns");
        System.out.println("Binary Search: " + estimatedBinaryTime / NUM_SAMPLES + " ns");
    }    
    
    /**
     * @param filename
     * @param size
     * @return
     * @throws FileNotFoundException
     */
    public static String[] readFileSorted(String filename, int size) throws FileNotFoundException {
        Scanner input = new Scanner(new File(filename));
        String[] words = new String[size];
        
        for (int i = 0; i < size; i++) {
            words[i] = input.next();
        }
        
        Arrays.sort(words);
        return words;
    }
}
