package com.algorithms.demo.dynamicprogramming;

/*
 http://www.programcreek.com/2014/02/leetcode-best-time-to-buy-and-sell-stock-java/
 https://www.youtube.com/watch?v=76-CYD0jn7s

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 

design an algorithm to find the maximum profit.

Java Solution - O(N)
 - Track Minimum Buying Price
 - Get Minimum Profit by Keeping Track of the minimum Buying
   price as you go along the array 
 - condition buyingDay <= SellingDay
   
   Equation :
   Two variables minP=INFINITY and Profit=0
                    
   prices= {7,       1,    5,   3,   6,   4};
           minPrice 
   
*/

public class BuySellStockOneTransaction {
	 
    public int maxProfit(int[] prices){
    	if(prices == null || prices.length ==0){
    		return 0;
    	}
    	
    	int minPrice = Integer.MAX_VALUE;
    	int profit = 0;
    	
    	for(int i=0; i< prices.length; i++){
    	   
    	   minPrice = Math.min(minPrice, prices[i]);
    	   profit = Math.max(profit, prices[i]-minPrice);
    	}
    	System.out.println("minPrice:"+minPrice);
    	return profit;
    	
    }
	 
	 public static void main(String args[]){
		 int[] prices =  {100, 80, 120, 130, 70, 60, 100, 125};
		 BuySellStockOneTransaction bs = new BuySellStockOneTransaction();
		 System.out.println("profit ::"+bs.maxProfit(prices));
		 
	 }
}
