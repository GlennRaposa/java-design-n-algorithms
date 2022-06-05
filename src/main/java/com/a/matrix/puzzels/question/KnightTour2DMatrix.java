package com.a.matrix.puzzels.question;

import java.text.DecimalFormat;

//http://algorithms.tutorialhorizon.com/backtracking-knights-tour-problem/
/*
 A knight’s tour is a sequence of moves of a knight on a chess­board such that the knight visits every square only once. 
 If the knight ends on a square that is one knight’s move from the beginning square (so that it could tour the board again immediately, 
 following the same path), the tour is closed, otherwise it is open. 
 
 ------- Approach ---------
 Create a solution matrix of the same structure as Chess_board.
 
 Start from 0,0 and index = 0. (index will represent the no of cells has been covered by the knight)
 Check current cell is not already used if not then mark that cell (start with 0 and keep incrementing it, 
 it will show us the path for the knight).
 
 Check if index = N*N-1, means Knight has covered all the cells. return true and print the solution matrix.
 Now try to solve rest of the problem recursively by making index +1. 
 
 Check all 8 directions. (Knight can move to 8 cells from its current position.) Check the boundary conditions as well 
 If none of the 8 recursive calls return true, BACKTRACK and undo the changes ( put 0 to corresponding cell in solu­tion matrix) 
 and return false.
 */
public class KnightTour2DMatrix {
	
	int[][] solution;
	int path = 0;

	public KnightTour2DMatrix(int N) {
		solution = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				solution[i][j] = 0;
			}
		}
	}

	public void solve() {
		if (findPath(0, 0, 0, solution.length)) {
			print();
		} else {
			System.out.println("NO PATH FOUND");
		}
	}

	public boolean findPath(int row, int column, int index, int N) {
		// check if current is not used already
		if (solution[row][column] != 0) {
			return false;
		}
		// mark the current cell is as used
		solution[row][column] = path++;
		// if (index == 50) {
		if (index == N * N - 1) {
			// if we are here means we have solved the problem
			return true;
		}
		// try to solve the rest of the problem recursively

		// go down and right
		if (canMove(row + 2, column + 1, N)
				&& findPath(row + 2, column + 1, index + 1, N)) {
			return true;
		}
		// go right and down
		if (canMove(row + 1, column + 2, N)
				&& findPath(row + 1, column + 2, index + 1, N)) {
			return true;
		}
		// go right and up
		if (canMove(row - 1, column + 2, N)
				&& findPath(row - 1, column + 2, index + 1, N)) {
			return true;
		}
		// go up and right
		if (canMove(row - 2, column + 1, N)
				&& findPath(row - 2, column + 1, index + 1, N)) {
			return true;
		}
		// go up and left
		if (canMove(row - 2, column - 1, N)
				&& findPath(row - 2, column - 1, index + 1, N)) {
			return true;
		}
		// go left and up
		if (canMove(row - 1, column - 2, N)
				&& findPath(row - 1, column - 2, index + 1, N)) {
			return true;
		}
		// go left and down
		if (canMove(row + 1, column - 2, N)
				&& findPath(row + 1, column - 2, index + 1, N)) {
			return true;
		}
		// go down and left
		if (canMove(row + 2, column - 1, N)
				&& findPath(row + 2, column - 1, index + 1, N)) {
			return true;
		}
		// if we are here means nothing has worked , backtrack
		solution[row][column] = 0;
		path--;
		return false;

	}

	public boolean canMove(int row, int col, int N) {
		if (row >= 0 && col >= 0 && row < N && col < N) {
			return true;
		}
		return false;
	}

	public void print() {
		DecimalFormat twodigits = new DecimalFormat("00");
		for (int i = 0; i < solution.length; i++) {
			for (int j = 0; j < solution.length; j++) {
				System.out.print("   " + twodigits.format(solution[i][j]));
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int N = 8;
		KnightTour2DMatrix i = new KnightTour2DMatrix(N);
		i.solve();
	}
	
}
