package AmazonQuestions;

public class LeftDownSearch {

	public static boolean search(int mat[][], int n, int elem) {
		int i = 0, j = n-1; // i is the col marker and j is the row marker
		while (i < n && j >= 0) {
			if (mat[i][j] == elem) {
				return true;
			}
			else if(mat[i][j] > elem) { // If greater then go left
				j = j-1;
			}
			else { // If smaller go down
				i = i + 1;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		  int mat[][] = { {10, 20, 30, 40},
                  {15, 25, 35, 45},
                  {27, 29, 37, 48},
                  {32, 33, 39, 50},
                };
		  boolean isPresent = search(mat, 4, 60);
		  if(isPresent)
			  System.out.println(" present in the Matrix");
		  else
			  System.out.println(" is not present in the Matrix");
	}

}
