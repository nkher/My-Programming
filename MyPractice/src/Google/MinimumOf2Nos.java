package Google;

public class MinimumOf2Nos {
	
	public static int min(int x, int y) {
		
		// return y ^ ( (x ^ y) && -(x < y)); // this works in c / c++
		return 0;
	}
	
	public static void main(String[] args) {
		
		
		int x = 10, y = 20;
		
		System.out.println(x < y); // true
		
		System.out.println(x ^ y); // 30
		
		System.out.println(Integer.toBinaryString(30));
	}
}


