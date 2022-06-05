package com.algorithms.demo.matrixpuzzels;
/*
https://sadakurapati.wordpress.com/2013/11/30/algorithm-knapsack/

we perform the following steps DP-iteratively for sack capacity from 1 to 10 (sackCapacity)

Check the weight of the each item, if it can’t fit (weights[i] > w) into our sack, then we move to the next weight
If we can fit it in (weights[i] <= w), then we calculate the optimal price by the following steps.
Find the price if we include this item. We just wanted to know what the price gain is if we include this in the sack. So price = price of this item + price of (sackCapacity of this sub problem – weight of this item)
Find the price if we don’t include this item – it will be optimal price of i-1 items.
Then take the best option from above – the greater price.
So the final dpTable will look like below for the above example.
*/

import java.util.Arrays;
 
/**
 * Knapsack algorithm
 *
 * @author Sada Kurapati <sadakurapati@gmail.com>
 */
public class Knapsack {
 
  public static void main(String[] args) {
    int[] price = {6, 4, 5, 3, 9, 7};
    int[] weights = {4, 2, 3, 1, 6, 4};
 
    int sackCapacity = 10;
    boolean[][] keep = getItemsToPick(price, weights, sackCapacity);
    printSelectedItems(keep, sackCapacity, price, weights);
  }
 
  /**a
   * price[] - value - $$$ Gain weights[] - weights sackCapacity - the maximum
   * weight knapsack can carry.
   */
  private static boolean[][] getItemsToPick(int[] price, int[] weights, int sackCapacity) {
    int nItems = price.length;
    //dp[i][w] - the maximum value of sub problem with i items and with w sack capacity.
    //no need to initialize with zeros as in java, the defalt values are 0 for int premitive type.
    int[][] dpTable = new int[nItems + 1][sackCapacity + 1];
    boolean[][] keep = new boolean[nItems][sackCapacity + 1];
 
    //iterate through all of the items
    for (int i = 1; i <= nItems; i++) {
      //calculate sub problem for all weights
      for (int w = 1; w <= sackCapacity; w++) {
        if (weights[i - 1] > w) {
          // we cannt take this weight as it exceeds sub problem with weight w and i items
          dpTable[i][w] = dpTable[i - 1][w];
        } else {
          //Price if we include item i
          int pYes = price[i - 1] + dpTable[i - 1][w - weights[i - 1]];
          //Price if we include item i
          int pNo = dpTable[i - 1][w];
          if (pYes > pNo) {
            //this item MAY go into sack
            keep[i - 1][w] = true;
            dpTable[i][w] = pYes;
          } else {
            dpTable[i][w] = pNo;
          }
        }
      }
    }
    //printing dpTable
    System.out.println(Arrays.deepToString(dpTable));
    System.out.println(Arrays.deepToString(keep));
    return keep;
  }
 
  public static void printSelectedItems(boolean[][] keep, int sackCapacity, int[] price, int[] weights) {
    //printing what items we picked
    System.out.println("Selected items:");
    int K = sackCapacity;
    int n = price.length;
    int wsel = 0;
    int vsel = 0;
    for (int i = n - 1; i >= 0; i--) { // need to go in the reverse order
      if (keep[i][K] == true) {
        System.out.println(i + "\tv=" + price[i] + "\tw=" + weights[i]);
        wsel += weights[i];
        vsel += price[i];
        K = K - weights[i];
      }
    }
    System.out.println("The overall value of selected items is " + vsel + " and weight " + wsel);
    System.out.println("Maximum weight was " + sackCapacity);
  }
}