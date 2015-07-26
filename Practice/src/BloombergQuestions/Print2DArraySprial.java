package BloombergQuestions;

public class Print2DArraySprial {
	
	public static void print2DArraySprial(int a[][]) {
		int layer, n = a.length;
		for(layer=0;layer<n/2;layer++) {
			int first = layer; //  0 1 2
			int last = n-1-layer; // 5 - 1 - layer (4 - 0)
			printRow(a, first, a[first].length-1);
			printCol(a, last, a[last].length-1);
			printRowBack(a, last, a[last].length-1);
			printColUp(a, first, a[first].length-1);
		}
	}
	
	public static void printRowBack(int a[][], int rowNumber, int colsize) {
		for (int i=colsize;i>0;i--) {
			System.out.print(a[rowNumber][i] + " ");
		}
	}
	
	public static void printRow(int a[][], int rowNumber, int colsize) {
		for (int i=0;i<colsize;i++) {
			System.out.print(a[rowNumber][i] + " ");
		}
	}
	
	public static void printCol(int a[][], int colNumber, int rowsize) {
		for (int i=0;i<rowsize;i++) {
			System.out.print(a[i][colNumber] + " ");
		}
	}
	
	public static void printColUp(int a[][], int colNumber, int rowsize) {
		for (int i=rowsize;i>0;i--) {
			System.out.print(a[i][colNumber] + " ");
		}
	}
	
	public static void main(String args[]) {
		
		int arr[][] = 	{{1,2,3,4,5},
						{6,7,8,9,10},
						{11,12,13,14,15},
						{16,17,18,19,20},
						{21,22,23,24,25}};
		
		Print2DArraySprial.print2DArraySprial(arr);
	}
	// 00 01 02 03 04 14 24 34 44 43 42 41 40 30 20 10
}
