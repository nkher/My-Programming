package com.CTCI.Chapter1;

public class Question1_7 {
	
	public static void nullifyRow(int[][] matrix, int row) {
		for (int j=0;j<matrix.length;j++)
			matrix[row][j] = 0;
	}
	
	public static void nullifyColumn(int[][] matrix, int col) {
		for (int j=0;j<matrix[0].length;j++)
			matrix[j][col] = 0;
	}
	
	public static void setZeros(int[][] matrix) {
		
		boolean[] row = new boolean[matrix.length];
		boolean[] col = new boolean[matrix[0].length];
		
		for (int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				
				if(matrix[i][j] == 0) {
					row[i] = true;
					col[j] = true;
				}
			}
		}
		
		// Now actually zeroing the rows and the columns
		for(int i=0;i<row.length;i++) {
			if (row[i])
				nullifyRow(matrix, i);
		}
		
		for(int j=0;j<col.length;j++) {
			if (col[j])
				nullifyColumn(matrix, j);
		}

	}
	
	public static boolean matricesAreEqual(int m1[][], int m2[][]) {
		if (m1.length != m2.length || m1[0].length != m2[0].length) {
			return false;
		}
		for (int i=0;i<m1.length;i++) {
			for(int j=0;j<m2[0].length;j++) {
				if (m1[i][j] != m2[i][j])
					return false;
			}
		}
		return true;
	}
	
	public static int[][] cloneMatrix(int[][] matrix) {
		int[][] c = new int[matrix.length][matrix[0].length];
		for (int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				c[i][j] = matrix[i][j];
			}
		}
		return c;
	}
	
	public static void printMatrix(int matrix[][]) {
		for (int i=0;i<matrix.length;i++) {
			for (int j=0;j<matrix[0].length;j++) {
				System.out.print(matrix[i][j] + ", ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int matrix[][] = {  {1,2,3,4,5},
				{6,7,8,9,0},
				{11,12,13,14,15},
				{16,17,18,19,20},
				{21,22,23,24,25}};
		
		setZeros(matrix);
		printMatrix(matrix);
		
	}

}
