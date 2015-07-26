package com.CTCI.Chapter1;

// Rotate N*N image by 90 degrees
public class Question1_6 {
	
	public static void rotate(int[][] matrix, int n) {
		for (int layer=0;layer<n/2;layer++) {
			int first = layer;
			int last = n-1-layer;
			for (int i=first;i<last;++i) {
				int offset = i - first;				
				System.out.println(first + " " + i + " " + last + " " + (last-offset));
				int top = matrix[first][i]; // Saving the top left
				matrix[first][i] = matrix[last-offset][first]; // Assigning bottom left to --> top left
				matrix[last-offset][first] = matrix[last][last-offset]; // Assigning bottom right to --> bottom left
				matrix[last][last-offset] = matrix[i][last]; // Assigning top right to --> bottom right
				matrix[i][last] = top; // Assigning top left to --> top right
			}
		}
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
							{6,7,8,9,10},
							{11,12,13,14,15},
							{16,17,18,19,20},
							{21,22,23,24,25}};
		printMatrix(matrix);
		rotate(matrix, 5);
		System.out.println();
		printMatrix(matrix);
	}

}
