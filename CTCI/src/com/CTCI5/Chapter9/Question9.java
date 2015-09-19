package com.CTCI5.Chapter9;

import java.util.Scanner;

public class Question9 {

	public static int N;
	
	// naive - O(2^(n*n))
	// backtracking - O(n^(2*n)) 
	public static boolean boardSolver(int board[][], int col) {
		if (col >= N) {
			return true;
		}
		for (int row=0;row<N;row++) {
			if (checkPlacement(board, row , col)) {
				
				board[row][col] = 1;
				if (boardSolver(board, col+1))
					return true;
				
				// backtrack
				board[row][col] = 0;
			}
		}
		return false;
	}
	
	public static boolean checkPlacement(int [][]board, int row, int col) {
		
		// check row
		for (int i=0;i<col;i++)  {
			if (board[row][i] == 1) return false;
		}
		
		// check diagonally top left
		for (int i=row, j=col; i >= 0 && j >= 0; i--, j--)  {
			if (board[i][j] == 1) return false;
		}
		
		// check diagonally bottom left
		for (int i=row, j=col; i < N && j >= 0; i++, j--)  {
			if (board[i][j] == 1) return false;
		}
		
		return true;
	}
	
	public static void printBoard(int a[][]) {
		for (int i=0;i<a.length;i++) {
			for (int j=0;j<a[i].length;j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter size of the matrix. ");
		
		N = scan.nextInt();
		int[][] board = new int[N][N];
		if (!boardSolver(board, 0)) {
			System.out.println("Solution not found.");
		}
		printBoard(board);

	}

}
