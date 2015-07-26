package BloombergQuestions;


// Given an unsorted integer array, place all zeros to the end of the array without 
// changing the sequence of non-zero elements. 
// (i.e. [1,3,0,8,12, 0, 4, 0,7] --> [1,3,8,12,4,7,0,0,0])
public class MoveZerosToEnd {
	
	public static int[] shiftZerosToEnd(int a[]) {
		int zeroCounter = 0;
		for (int i=0;i<a.length;i++) {
			if (a[i] == 0) {
				zeroCounter++;
				continue; // Go to the next counter
			}
			if (zeroCounter > 0) {
				a[i - zeroCounter] = a[i];
				a[i] = 0;
			}
		}
		return a;
	}
	
	public static void printArray(int a[]) {
		for(Integer i : a) {
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		int a[] = {1, 2, 0, 4, 6, 7, 0, 9, 12, 45, 0, 49, 0, 99, 0};
		a = shiftZerosToEnd(a);
		printArray(a);
	}

}
