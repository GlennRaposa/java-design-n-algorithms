package com.a.dynamic.programming;

import java.util.Deque;
import java.util.LinkedList;
//https://www.youtube.com/watch?v=oDhu5uGq_ic
//https://github.com/mission-peace/interview/blob/b2d7bdb1cc589e2830c778cef75f1c663b11cb77/src/com/interview/dynamic/StockBuySellKTransactions.java
public class BuySellStockKTransaction {

	
    /**
     * This is faster method which does optimization on slower method
     * Time complexity here is O(K * number of days)
     *
     * Formula is
     * fn[i][j] = Math.max(fn[i][j-1],  max+prices[j])
     * max = Math.max(max, fn[i-1][j] - prices[j])
     */
    // http://www.gorecursion.com/algorithm/2016/11/20/2d-dynamic2.html
	// https://www.youtube.com/watch?v=rC94KrC25Ts
    private int maxProfitDP(int[] prices, int k) {
        int[][] fn = new int[k+1][prices.length];

        for (int i = 1; i <= k; i++) {
            int max = -prices[0];
            for (int j = 1; j < prices.length; j++) {
            	//Compare Earlier Cell Value with current Max + Current price
                fn[i][j] = Math.max(fn[i][j-1], max + prices[j]);
                max = Math.max(fn[i-1][j] - prices[j], max);
            }
        }
        printActualSolution(fn, prices);
        return fn[k][prices.length-1];
    }
    
    public void printActualSolution(int T[][], int prices[]) {
        int i = T.length - 1;
        int j = T[0].length - 1;

        Deque<Integer> stack = new LinkedList();
        while(true) {
            if(i == 0 || j == 0) {
                break;
            }
            if (T[i][j] == T[i][j-1]) {
                j = j - 1;
            } else {
                stack.addFirst(j);
                int maxDiff = T[i][j] - prices[j];
                for (int k = j-1; k >= 0; k--) {
                    if (T[i-1][k] - prices[k] == maxDiff) {
                        i = i - 1;
                        j = k;
                        stack.addFirst(j);
                        break;
                    }
                }
            }
        }

        while(!stack.isEmpty()) {
            System.out.println("Buy at price " + prices[stack.pollFirst()]);
            System.out.println("Sell at price " + prices[stack.pollFirst()]);
        }

    }

    public static void main(String args[]) {
    	BuySellStockKTransaction sbt = new BuySellStockKTransaction();
        int prices[] = {2, 5, 7, 1, 4, 3, 1, 3};

        System.out.println("DP-Max profit fast solution " + sbt.maxProfitDP(prices, 2));
        //System.out.println("Max profit slow solution " + sbt.maxProfitSlowSolution(prices, 3));
    }

	

}
