package com.algorithms.demo.matrixpuzzels;
/*
 * http://www.programcreek.com/2014/05/leetcode-unique-paths-java/
 * A robot is located at the top-left corner of a m x n grid. 
 * It can only move either down or right at any point in time. 
 * The robot is trying to reach the bottom-right corner of the grid.
   How many possible unique paths are there?
 */
public class RobotUniquePathsIn2DMatrix {

	public int uniquePaths(int m, int n) {
	    if(m==0 || n==0) return 0;
	    if(m==1 || n==1) return 1;
	 
	    int[][] dp = new int[m][n];
	 
	    //left column
	    for(int i=0; i<m; i++){
	        dp[i][0] = 1;
	    }
	 
	    //top row
	    for(int j=0; j<n; j++){
	        dp[0][j] = 1;
	    }
	 
	    //fill up the dp table
	    for(int i=1; i<m; i++){
	        for(int j=1; j<n; j++){
	            dp[i][j] = dp[i-1][j] + dp[i][j-1];
	        }
	    }
	 
	    return dp[m-1][n-1];
	}
	
	public static void main(String args[]) {
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		RobotUniquePathsIn2DMatrix p = new RobotUniquePathsIn2DMatrix();
		System.out.println("No of Paths By Recursion: "
				+ p.uniquePaths(3,3));

	}

}
