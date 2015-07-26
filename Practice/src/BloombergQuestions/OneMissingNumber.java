package BloombergQuestions;

public class OneMissingNumber {

	public static void main(String[] args) {
		int a[] = {1,2,3,5,6,4,8,9,10};
		
		int result1 = a[0] ^ a[1];
		for (int i=2;i<a.length;i++){
			result1 ^= a[i];
		}
		
		// Now getting the result for the range of numbers
		int result2 = 1 ^ 2;
		for (int i=3;i<=10;i++) {
			result2 ^= i;
		}
		
		System.out.println("Missing number in the array which is not in range 1 to 10 is : " + (result1 ^ result2));
	}

}
