package com.a.dynamic.programming;
/*
 https://www.youtube.com/watch?v=Taq95cvRom8 
 Say you have an array for which the ith element is the price of a given stock on day i.
 design an algorithm to find the maximum profit that can be obtained by multiple non-overlapping transactions(buy and sell)
 
 Approach:
   - Find All Increasing pairs
   - Accumulate the profit
 */
public class BuySellStockMultipleTransaction {

	 public int maxProfit(int[] prices){
		 
		 int totalProfit = 0;
		 //First  100, 80    currentProfit < 0    totalProfit=0
		 //second 80   120   currentProfit=40    totalProfit=40
		// Third  120  130   currentProfit=10    totalProfit=50
		// Fourth 130  70   currentProfit < 0    totalProfit=50
		// Fifth  70   60   currentProfit < 0    totalProfit=50
		// sixth  60   100   currentProfit=40    totalProfit=90
		// seventh100  125   currentProfit=25    totalProfit=115
		 for(int i=1; i<prices.length;i++){
			 int currentProfit = prices[i] - prices[i-1];
			 if(currentProfit > 0){
				 totalProfit +=currentProfit;
			 }
		 }
		 
		 return totalProfit;
	 }
	 
	 public static void main(String args[]){
		 int[] prices =  {100, 80, 120, 130, 70, 60, 100, 125};
		 BuySellStockMultipleTransaction bs = new BuySellStockMultipleTransaction();
		 System.out.println("profit ::"+bs.maxProfit(prices));
		 
	 }
}
