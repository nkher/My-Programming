package PalantirQuestions;

public class FlipMatrix {

	public static int[][] flipMatrix(int a[][], int flipDirection) {
		if (flipDirection == 0) {
			a = flipRightLeftorLeftRight(a);
			System.out.println("Left Right Flipped array ");
		}
		else {
			a = flipUpDownorDownUp(a);
			System.out.println("Up Down Flipped array ");
		}
		return a;
	}
	
	private static int[][] flipRightLeftorLeftRight(int a[][]) {
		for (int i=0;i<a.length;i++) {
			int start = 0, end=a[i].length-1;
			while (start < end) {
				// swap
				int temp = a[i][start];
				a[i][start] = a[i][end];
				a[i][end] = temp;
				start++;
				end--;
			}
		}
		return a;
	}
	
	private static int[][] flipUpDownorDownUp(int a[][]) {
		for (int i=0;i<a[i].length;i++) {
			int start = 0, end=a.length-1;
			while (start < end) {
				// swap
				int temp = a[start][i];
				a[start][i] = a[end][i];
				a[end][i] = temp;
				start++;
				end--;
			}
		}
		return a;
	}
	
	public static void printDoubleArr(int a[][]) {
		for (int i=0;i<a.length;i++) {
			System.out.print("[ ");
			for (int j=0;j<a[i].length;j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.print("]\n");
		}
	}
	
	public static void main(String[] args) {
		// 00 01 02 03
		// 10 11 12 13
		// 20 21 22 23
		// 30 31 32 33
		// 40 41 42 43
		int arr[][] =  {{1,2,3,4},
						{5,6,7,8},
						{9,10,11,12},
						{13,14,15,16},
						{17,18,19,20},
						{21,22,23,24}};
		
		// 0 for left right flip and 1 for down up flip
		System.out.println("Original array ");
		FlipMatrix.printDoubleArr(arr);
		arr = FlipMatrix.flipMatrix(arr, 1);
		FlipMatrix.printDoubleArr(arr);
	}
}
