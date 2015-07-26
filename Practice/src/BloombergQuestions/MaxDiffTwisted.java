package BloombergQuestions;

public class MaxDiffTwisted {
	
	// Find the maximum difference in an unsorted array with the index of max greater than min
	public static void main(String[] args) {
		int arr[] = {20, 10, 5, 8, 22, 17, 6};
		int min = arr[0], max = Integer.MIN_VALUE;
		for (int i=1;i<arr.length;i++) {
			if(arr[i] < min) {
				min = arr[i];
				continue;
			}
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		System.out.println("Max difference with given condition is : " + (max - min));
	}
}
