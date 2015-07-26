package Ebay;

public class OnesAndZeros {
	
	
	// the below code would get the length of the binary format of the number
	// For getting number of ones do (n AND 1 == 1) and then right shift the number
	public static int get1s(int n) {
		int countOnes = 0;
		int binLength = Integer.toBinaryString(n).length();
		while(binLength > 0) {
			if ((n & 1) == 1)
				countOnes++;
			n = n >> 1; // right shift
			binLength--;
		}
		return countOnes;
	}
	
	// For getting number of ones do (n OR 0 == 0) and then right shift the number
	public static int get0s(int n) {
		int countZeros = 0;
		int binLength = Integer.toBinaryString(n).length();
		while(binLength > 0) {
			if ((n | 0) == 0)
				countZeros++;
			n = n >> 1; // right shift
			binLength--;
		}
		return countZeros;
	}
	
	public static void main(String[] args) {
		int i = 100; //  1001
		System.out.println("Binary Number : " + Integer.toBinaryString(i));
		int numberOfOnes = OnesAndZeros.get1s(i);
		System.out.println("Number of ones : " + numberOfOnes);
		int numberOfZeros = OnesAndZeros.get0s(i);
		System.out.println("Number of zeros : " + numberOfZeros);
		System.out.println(0 | 5);
		System.out.println();
		System.out.println('a'-'a');
		System.out.println(54 & 100);
	}

}
