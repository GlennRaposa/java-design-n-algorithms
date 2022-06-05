package com.a.dynamic.programming;
//http://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
public class CoinChangeGreedyAlgo {

	public static void main(String args[]) {
		CoinChangeGreedyAlgo greedy = new CoinChangeGreedyAlgo();
		int coins[] = { 9, 6, 5, 1 };
		int m = coins.length;
		int V = 11;
		System.out.println("Minimum coins required is " + greedy.minCoin(coins, m, V));
	}

	//TIME COMPLEXITY EXPONENTIAL SO SHOULDENT SOLVE IT THIS WAY
	// m = size of coins
	// v = value
	public int minCoin(int[] coins, int m, int v) {
		if (v == 0) {
			return 0;
		}
		int res = Integer.MAX_VALUE;

		for (int i = 0; i < m; i++) {
			if (coins[i] <= v) {
				int sub_res = minCoin(coins, m, v - coins[i]);

				if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res) {
					res = sub_res + 1;
				}
			}
		}
		return res;
	}

}
