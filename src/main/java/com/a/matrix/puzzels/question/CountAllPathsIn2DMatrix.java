package com.a.matrix.puzzels.question;
/*
 * http://algorithms.tutorialhorizon.com/count-all-paths-from-top-left-to-bottom-right-in-two-dimensional-array-including-diagonal-paths/
 * Objective: Count all the paths from left top corner to right bottom corner in two dimensional array.
   Input: Two Dimensional array
   
   Create two dimensional resultCount array to store the number of paths from top left corner.
   Base Case: To reach to any cell in either first row or column from first cell(top left at 0,0) will be 1.
   You can reach to any cell from 3 different ways, from left, from right, from diagonal. 
   So total no of paths to reach to that cell will be sum of all the paths to reach to left, top and diagonal cell
   
   Formula : 
   Loop row -> loop column
   
   Cij = solution[i][0] = 1;
         solution[0][i] = 1;
         solution[i][j - 1] + solution[i - 1][j] + solution[i - 1][j - 1]; 
   
 */

public class CountAllPathsIn2DMatrix {
	
	int rowCount;
	int colCount;
	int[][] arrA;

	public CountAllPathsIn2DMatrix(int arrA[][]) {
		this.arrA = arrA;
		rowCount = arrA.length;
		colCount = arrA[0].length;
	}

	public int printAllDynamic(int[][] arrA) {
		int[][] solution = new int[arrA.length][arrA[0].length];
		for (int i = 0; i < arrA.length; i++) {
			solution[i][0] = 1;
		}
		for (int i = 0; i < arrA[1].length; i++) {
			solution[0][i] = 1;
		}

		for (int i = 1; i < arrA.length; i++) {
			for (int j = 1; j < arrA[1].length; j++) {
				solution[i][j] = solution[i][j - 1]
						+ solution[i - 1][j] + solution[i - 1][j - 1];
			}
		}
		return solution[arrA.length - 1][arrA[0].length - 1];
	}

	public static void main(String args[]) {
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		CountAllPathsIn2DMatrix p = new CountAllPathsIn2DMatrix(a);
		System.out.println("No of paths By Dynamic Programming: "
				+ p.printAllDynamic(a));
	}

}
