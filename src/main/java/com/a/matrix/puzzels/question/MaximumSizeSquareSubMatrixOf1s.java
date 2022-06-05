package com.a.matrix.puzzels.question;

import java.util.Arrays;

//http://algorithms.tutorialhorizon.com/dynamic-programming-maximum-size-square-sub-matrix-with-all-1s/
/*
Objec�tive: Given a matrix of 0�s and 1�s (binary matrix). Find out Max�i�mum size square sub-matrix with all 1�s.
 
Approach:
Base Cases:

If only one row is given then cells with 1�s will be the Max�i�mum size square sub-matrix with size = 1.
If only one column is given then cells with 1�s will be the Max�i�mum size square sub-matrix with size = 1.

-----Dynamic Pro�gram�ming (Bottom-up).

Cre�ate an aux�il�iary array of the same size as given input array. We will fill the aux�il�iary array with Max�i�mum size square sub-matrix with all 1�s pos�si�ble with respect to the par�tic�u�lar cell.
Once the aux�il�iary is fill, scan it and find out the max�i�mum entry in it, this will the size of Max�i�mum size square sub-matrix with all 1�s in the given matrix.
How to fill the aux�il�iary matrix??

Copy the first row and first col�umn from the given array to aux�il�iary array. (Read the base cases described earlier).
For fill�ing rest of cells, check if par�tic�u�lar cell�s value is 0 in given array, if yes then put 0 against to that cell in aux�il�iary array.
check if par�tic�u�lar cell�s value is 1 in given array, if yes then put Min�i�mum (value in the left cell, top cell and left-top diag�o�nal cell) + 1 in aux�il�iary cell.

---- Recursion
basecase 
sub[i][0] = arrA[i][0] i = 0 to row Count // copy the first col�umn
sub[0][i] = arrA[0][i] i = 0 to col�umn Count // copy the first row

for rest of the cells
sub[i][j] = 0 if arrA[i][j]=0    = Min(sub[i-1][j], sub[i][j-1], sub[i-1][j-1] )
At the End, scan the sub[][] and find out the max�i�mum entry in it.
 */
public class MaximumSizeSquareSubMatrixOf1s {

	
	public static void main(String[] args) {
		int[][] arrA = { { 0, 1, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1, 0 },
				{ 0, 1, 1, 1, 1, 0 }, { 0, 0, 1, 1, 1, 0 },
				{ 1, 1, 1, 1, 1, 1 } };
		MaximumSizeSquareSubMatrixOf1s i = new MaximumSizeSquareSubMatrixOf1s();
		System.out.println(i.subMatrix(arrA, 5, 6));
	}
	
	public int subMatrix(int[][] a, int rows, int cols){
		int[][] sub = new int[rows][cols];
		
		//copy first row
		for(int i=0; i<a.length; i++){
			sub[0][i] = a[0][i];
		}
		
		//copy first column
		for(int i=0; i<a.length; i++){
			sub[i][0] = a[i][0];
		}
		
		//rest of the matrix check if a[i][j] = 1
		for(int i=1;i<rows; i++){
			for(int j=1; j<cols; j++){				
				if(a[i][j] == 1){
					sub[i][j] = Math.min(sub[i-1][j], Math.min(sub[i][j-1],sub[i-1][j-1]) ) + 1;
				}else{
					sub[i][j] = 0;
				}
			}
		}
		
		System.out.println(Arrays.deepToString(sub));
		//find maximum size of the subarray
		int max = -1;
		for(int i=0;i<rows; i++){
			for(int j=0; j<cols; j++){
				if(max < sub[i][j]){
					max = sub[i][j];
				}
			}
		}
		
		return max;
		
	}
}
