package BloombergQuestions;

public class RotateByk {

	public static void rotate(int nums[], int k) {
		
		// First we will reverse 0 to k-1 sub array and then k to length-1 sub array
		// and then finally reverse the array
		reverse(nums, 0, k-1);
		reverse(nums, k, nums.length-1);
		
		// Reverse the whole array
		reverse(nums, 0, nums.length-1);
	}
	
	// Swapping inside the array
	public static void swap(int[] nums, int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
	
	// Reverse the sub arrays and then reverse the whole array in order to rotate with the minimal 
	// time complexity
	public static void reverse(int []nums, int start, int end) {
		
		// Reverse head and tail until they get closer
		for(int i=start; i<=(start+end)/2; i++) {
			swap(nums, i, (start+end)-i); // Index to be swapped is 'start+end-i'
		}
//		int front = start;
//		int back = end;
//		while(back < front) {
//			int tmp = nums[back];
//			nums[front] = nums[back];
//			nums[back] = tmp; 
//			--back;
//			++front;
//		}
//		return nums;
	}
	
	public static void main(String[] args) {
		int []nums = {1,2,3,4,5,6};
		int k=3; // So after rotation we will have {4,5,6,1,2,3}
		rotate(nums, 3);
		for(Integer i : nums)
			System.out.print(i + " ");
	}

}
