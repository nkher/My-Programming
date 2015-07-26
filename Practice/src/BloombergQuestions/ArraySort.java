package BloombergQuestions;

public class ArraySort {

	public static int[] sortArray(int a[]) {
		
		int twoCounter = 0;
		int left = 0;
		int right = a.length-1;
		while(left < right) {
			// Step 1 : Check if right is 3, if yes then decrement right
			if (a[right] == 3) {
				right--;
			}
			// Step 2 : Check if left is 3 and right is not 3, if yes swap
			if(a[left] == 3 && a[right] != 3) {
				// Swap
				int tmp = a[right];
				a[right] = a[left];
				a[left] = tmp;
				right--;
				// here do not increment left as then once we swap we can get a 2 or 1 in the place after swapping
			}
			// Step 3 : Check if left is 2, if yes increment twoCounter
			if(a[left] == 2) {
				left++;
				twoCounter++;
				continue;
			}
			if (a[left] == 1 && twoCounter == 0) {
				left++;
				continue;
			}
			// Step 4 : Check if left is 1 and twoCounter is greater than 0, if yes swap
			else if(a[left] == 1 && twoCounter > 0) {
				// Swap
				int tmp = a[left];
				a[left] = a[left-twoCounter];
				a[left-twoCounter] = tmp;
				left++;
			}
		}
		return a;
	}
	
	public static void printArray(int a[]) {
		System.out.print("[ ");
		for(Integer i : a) {
			System.out.print(i + " ");
		}
		System.out.print("]");
	}
	
	public static void main(String[] args) {
		
		int a[] = {1, 2, 1, 1, 3, 3, 2, 1, 2, 3, 2, 2, 3};
		a = sortArray(a);
		printArray(a);
	}

}
