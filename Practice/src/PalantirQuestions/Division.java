package PalantirQuestions;

public class Division {
	
	// Working --> In a number that is a power of 2 we have only one bit set, with n zeros
	// When we divide N (number) by (2^n), the bit positions corresponding to the above zeros 
	// contribute to the remainder of division operation
	
	/* N = 87 (1010111 – binary form)

		N%2 = N & (2-1) = 1010111 & 1 = 1 = 1
		
		N%4 = N & (4-1) = 1010111 & 11 = 11 = 3
		
		N%8 = N & (8-1) = 1010111 & 111 = 111 = 7
		
		N%16 = N & (16-1) = 1010111 & 1111 = 111 = 7
		
		N%32 = N & (32-1) = 1010111 & 11111 = 10111 = 23 
		
		*/
	
	
	// only works for power of 2
	public static int remainderByPower2(int N, int b) {
			return ( N & (b-1) ); 
	}
	
	public static int modulus(int N, int b){
		if ( checkpowerof2(b) ) {
			return ( N & (b-1) ); 
		}
		else 
			return remainder(N, b);
	}
	
	public static boolean checkpowerof2(int number) {
		int count = 0;
		while (number > 0) {
			number = number & (number-1);
			count++;
		}
		return (count == 1);
	}
	
	// Without divide and shift
	public static int remainder(int N, int b) {
		int prev = b, curr = b;
		while (curr < N) {
			prev = curr;
			curr += b;
			if (curr == N) return 0;
		}
		return (N - prev);	
	}
	
	
	
	public static void main(String[] args) {
		// System.out.println(remainderByPower2(10, 8));
		
		// System.out.println(checkpowerof2(8));		
		System.out.println(modulus(190, 17));
	}
}
