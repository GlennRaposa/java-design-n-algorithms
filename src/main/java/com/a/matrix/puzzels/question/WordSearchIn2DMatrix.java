package com.a.matrix.puzzels.question;
/*
 * 
 * http://algorithms.tutorialhorizon.com/backtracking-search-a-word-in-a-matrix/
   Objec­tive : Given a 2D matrix of char­ac­ters. Check whether the word exist in the matrix or not. 
   If it exists then print its path. All move­ments are allowed (right, left, up, down and diagonally[4]).
   
   - Create a solution matrix of the same structure as Matrix.
   
   - Try each cell a starting point.
   
   - Check current cell is not already used and character in it matches with the char­ac­ter in the word at index (starts will 0).
   
   - Check if index = length of the word, means we have found the word. return true and print the solu­tion matrix.
   
   - If above cri­te­ria matches, mark that cell with a num­ber When­ever any cell matches with the cri­te­ria, 
     put a num­ber cor­re­spond­ing to it in solu­tion matrix. (start with 0 and keep incre­ment­ing it, it will show us the path for the word).
     
   - Now try to solve rest of the prob­lem recur­sively by mak­ing index +1. Check all 8 direc­tions ( up, down, left right, 
     diag­o­nally up-left, diag­o­nally up-right, diag­o­nally down-left, diag­o­nally down-right). Check the bound­ary con­di­tions as well
     
   - If none of the 8 recur­sive calls return true, BACKTRACK and undo the changes ( put 0 to 
     cor­re­spond­ing cell in solu­tion matrix) and return false.
     
   - Choose dif­fer­ent start­ing point.
   - If all the start­ing points tried and solu­tion not found, return false
*/
public class WordSearchIn2DMatrix {
	
	public int[][] solution;
	int path = 1;

	// initialize the solution matrix in constructor.
	public WordSearchIn2DMatrix(int N) {
		solution = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				solution[i][j] = 0;
			}
		}
	}

	public boolean searchWord(char[][] matrix, String word) {
		int N = matrix.length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (search(matrix, word, i, j, 0, N)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean search(char[][] matrix, String word, int row, int col,
			int index, int N) {

		// check if current cell not already used or character in it is not not

		if (solution[row][col] != 0 || word.charAt(index) != matrix[row][col]) {
			return false;
		}

		if (index == word.length() - 1) {
			// word is found, return true
			solution[row][col] = path++;
			return true;
		}

		// mark the current cell as 1
		solution[row][col] = path++;		
		// check if cell is already used

		if (row + 1 < N && search(matrix, word, row + 1, col, index + 1, N)) { // go
																				// down
			return true;
		}
		if (row - 1 >= 0 && search(matrix, word, row - 1, col, index + 1, N)) { // go
																				// up
			return true;
		}
		if (col + 1 < N && search(matrix, word, row, col + 1, index + 1, N)) { // go
																				// right
			return true;
		}
		if (col - 1 >= 0 && search(matrix, word, row, col - 1, index + 1, N)) { // go
																				// left
			return true;
		}
		if (row - 1 >= 0 && col + 1 < N
				&& search(matrix, word, row - 1, col + 1, index + 1, N)) {
			// go diagonally up right
			return true;
		}
		if (row - 1 >= 0 && col - 1 >= 0
				&& search(matrix, word, row - 1, col - 1, index + 1, N)) {
			// go diagonally up left
			return true;
		}
		if (row + 1 < N && col - 1 >= 0
				&& search(matrix, word, row + 1, col - 1, index + 1, N)) {
			// go diagonally down left
			return true;
		}
		if (row + 1 < N && col + 1 < N
				&& search(matrix, word, row + 1, col + 1, index + 1, N)) {
			// go diagonally down right
			return true;
		}

		// if none of the option works out, BACKTRACK and return false
		solution[row][col] = 0;
		path--;
		return false;
	}

	public void print() {
		for (int i = 0; i < solution.length; i++) {
			for (int j = 0; j < solution.length; j++) {
				System.out.print(" " + solution[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		char[][] matrix = { { 't', 'z', 'x', 'c', 'd' },
				{ 'a', 'h', 'n', 'z', 'x' }, { 'h', 'w', 'o', 'i', 'o' },
				{ 'o', 'r', 'n', 'r', 'n' }, { 'a', 'b', 'r', 'i', 'n' } };
		WordSearchIn2DMatrix w = new WordSearchIn2DMatrix(matrix.length);
		if (w.searchWord(matrix, "horizon")) {
			w.print();
		} else {
			System.out.println("NO PATH FOUND");
		}

	}
}
