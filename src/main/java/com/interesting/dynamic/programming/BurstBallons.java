package a.com.interesting.dynamic.programming;

import java.util.Arrays;

//https://www.youtube.com/watch?v=PkqqhoO22sw&feature=youtu.be
//http://www.gorecursion.com/algorithm/2017/01/07/burstboolon.html
/*
 * Given n balloons {3,1,5,8}, indexed from 0 to n-1. 
 * maxcoins() - adds 1 to the start and end of the arr in a new arr so new we have {1,3,1,5,8,1}
 * dfscache() - sets a 2D cache array to store values for every sub array computation
 * dfscache( ) recursion - teks left and right value each time recursively for adds equations 
 *  int l = dfsCache(num, L, i-1, cache);
	int r = dfsCache(num, i+1, R, cache);
 *  nums[L-1] * nums[i] * nums[R+1] * l *r. 
 *    
 *  Here left and right are adjacent indices of i. After the burst,
 *  the left and right then becomes adjacent.
 *    
 *  coins = Math.max(coins, val);
 * 
 * Find the maximum coins you can collect by bursting the balloons wisely.
 *
 * Time complexity O(n^3)
 * Space complexity O(n^2)
 * 
 * Dereck Li
 */

//Add one on each side coz the solution is going to be n[L]* n[i] * n[R] * l * r;
//rewrite the arr using one in the front and one at
public class BurstBallons {
	
	public int maxCoins(int[] nums) {
	    if (nums == null || nums.length == 0)
	        return 0;
	    int n = nums.length;
	    int num[] = new int[n+2];
	    num[0] = 1;
	    for (int i = 0; i < n; i++){
	        num[i+1] = nums[i];
	    }    
	    num[n+1] = 1;
	    System.out.println(Arrays.toString(num));	
	    return dfsCache(num, 1, n);
	}
	
	private int dfsCache(int[] num, int L, int R) {
	    int n = R-L+1+2;
	    int[][] cache = new int[n][n];
	    
	    return dfsCache(num, L, R, cache);
	}
	
	
	private int dfsCache(int[] num, int L, int R, int[][] cache) {
	    if (cache[L][R] != 0)
	        return cache[L][R];
	    int coins = 0;
	    for (int i = L; i <= R; i++) {
	        int l = dfsCache(num, L, i-1, cache);
	        int r = dfsCache(num, i+1, R, cache);
	        int val = num[L-1]*num[i]*num[R+1] + l + r;
	        coins = Math.max(coins, val);
	    }
	    cache[L][R] = coins;
	    //System.out.println(Arrays.deepToString(cache));
	    return coins;
	}
	
    public static void main(String args[]){
		int[] arr = {3,1,5,8};
		BurstBallons bb = new BurstBallons();
		System.out.println("BOOO------------: "+bb.maxCoins(arr));
		
	}
}
