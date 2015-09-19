package CareerCup.Google;

public class CompareIntegers {
	
	// xor operation returns 0 if the numbers are equal else returns any other number
	
	public static int compareUsingXor(int x, int y) {
		return x ^ y;
	}
	
	public static int compare(int a, int b) {
		
		return 1^(((a-b)>>31)|((b-a)>>31));
	}
	
	public static void main(String[] args) {
		
		// System.out.println(compareUsingXor(13567, 13567));
		
		if (compareUsingXor(13567, 13567) == 0) 
			System.out.println(true);
	}

}
