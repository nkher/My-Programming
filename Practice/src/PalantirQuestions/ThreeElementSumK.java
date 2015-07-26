package PalantirQuestions;

public class ThreeElementSumK {

	public void quicksort(int a[], int low, int high) {
		if (low < high) {
			int pIndex = partition(a, low, high);
			quicksort(a, low, pIndex-1);
			quicksort(a, pIndex+1, high);
		}
	}
	
	public int partition(int a[], int low, int high) {
		int pivot = a[high];
		int pIndex = low;
		
		for (int i=low;i<high;i++) {
			if (a[i] <= pivot) {
				// swap a[i] and a[pIndex]
				int temp = a[i];
				a[i] = a[pIndex];
				a[pIndex] = temp;
				pIndex++;
			}
		}
		
		// Swap pivot and pIndex
		int temp = pivot;
		a[high] = a[pIndex];
		a[pIndex] = temp;
		
		return pIndex;
	}
	
	public void find3NumbersSum(int a[], int sum) {
		quicksort(a, 0, a.length-1); // sorting the array
		int left, right;
		for (int i=0;i<a.length-2;i++) {
			left = i+1;
			right = a.length-1;
			while (left < right) {
				if (a[left] + a[right] + a[i] == sum) {
					System.out.println("Found triplet : " + a[left] + ", " + a[i] + ", " + a[right]);
					left++;
					right--;
				}
				else if (a[left] + a[right] + a[i] > sum)
					right--;
				else
					left++;
			}
		}
	}
	
	public static void main(String[] args) {
		int A[] = {1, 4, 45, 6, 10, 8, 25, 10, 0, 35, -10, -33};
	    int sum = 0;
	    
	    // System.out.println(Arrays.toString(A));
	    ThreeElementSumK obj = new ThreeElementSumK();
	    // obj.quicksort(A, 0, A.length-1);
	    // System.out.println(Arrays.toString(A));
	    
	    obj.find3NumbersSum(A, sum);
	    
	}

}
