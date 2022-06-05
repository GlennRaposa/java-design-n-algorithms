package com.a.matrix.puzzels.question;
/*
  SUDOKU Puzzle : The objective is to fill a 9�9 grid with digits so that each column, 
  each row, and each of the nine 3�3 sub-grids that com�pose the grid (also called �boxes�, �blocks�, �regions�, or �sub-squares�) 
  contains all of the digits from 1 to 9. The puzzle setter provides a partially completed grid, which for a well posed puz�zle 
  has a unique solution.

  Better Approach � Backtracking:
  - Find empty cell, find int row, col number
  - If there are no empty cells, return true, problem solved.

  For number  from 1 to 9
    a) IF IT IS safe for digit at cell[row][col]
        fill the cell[row][col]=number and recursively try fill in rest of grid
    b) If recursion successful, return true
    c) Else, undo the selection, cell[row][col]=0 and try another
  
  If all numbers are tried and solution not found, return false
 
 */
public class SUDOKU {
	public static int[][] grid;

	public boolean solveSUDOKU() {
		int row;
		int col;
		int[] blankCell = findBlankLocation();
		row = blankCell[0];
		col = blankCell[1];
		if (row == -1) {
			// means will have filled the grid, return;
			return true;
		}
		// we need to fill grid[row][col] cell
		for (int i = 1; i <= 9; i++) {
			// check if number i is safe for grid[row][col] cell
			if (isSafe(row, col, i)) {
				// means its safe to fill the number
				grid[row][col] = i;
				// fill the rest of the grid
				if (solveSUDOKU()) {
					return true;
				}
				// if we are here that means current selection of number didnt
				// work, revert back the changes
				grid[row][col] = 0;
			}
		}
		return false; // This will cause the backtracking
	}

	public boolean isSafe(int row, int col, int n) {
		// we need to check row contains number n OR
		// Column contains number n OR
		// Block in which cell appears contains number n
		// If Any of the above statement is true, return false
		if (!UsedInRow(row, n) && !UsedInColumn(col, n)
				&& !UsedInBox(row - row % 3, col - col % 3, n)) {
			return true;
		}
		return false;
	}

	// check if n not in particular row
	public boolean UsedInRow(int row, int n) {
		for (int i = 0; i < 9; i++) {
			if (grid[row][i] == n) {
				return true;
			}
		}
		return false;
	}

	// check if n not in particular column
	public boolean UsedInColumn(int col, int n) {
		for (int i = 0; i < 9; i++) {
			if (grid[i][col] == n) {
				return true;
			}
		}
		return false;
	}

	// check if n not in particular box
	public boolean UsedInBox(int boxStartRow, int boxStartCol, int n) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (grid[i + boxStartRow][j + boxStartCol] == n) {
					return true;
				}
			}
		}
		return false;
	}

	public int[] findBlankLocation() {
		int[] cell = new int[2]; // cell[0]-row cell[1] -column
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (grid[i][j] == 0) {
					cell[0] = i;
					cell[1] = j;
					return cell;
				}
			}
		}
		cell[0] = -1;
		cell[1] = -1;
		return cell; // means grid is full
	}

	public void print() {
		for (int row = 0; row < 9; row++) {
			if (row % 3 == 0) {
				System.out.println(); // for more readability
			}
			for (int col = 0; col < 9; col++) {
				if (col % 3 == 0) {
					System.out.print(" "); // for more readability
				}
				System.out.print(grid[row][col] + " ");

			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		grid = new int[][] { { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
				{ 6, 0, 0, 1, 9, 5, 0, 0, 0 }, { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
				{ 8, 0, 0, 0, 6, 0, 0, 0, 3 }, { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
				{ 7, 0, 0, 0, 2, 0, 0, 0, 6 }, { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
				{ 0, 0, 0, 4, 1, 9, 0, 0, 5 }, { 0, 0, 0, 0, 8, 0, 0, 7, 9 } };
		SUDOKU s = new SUDOKU();
		if (s.solveSUDOKU()) {
			s.print();
		} else {
			System.out.println("NO SOLUTION");
		}
	}

}
