package AmazonQuestions;

public class AddWithoutOperator {

	// Adding two operators
	// We use half adder logic to add 2 bits
	// Note 1: if x and y do not have the same bits at the same position
	// then do a simple XOR between them to get the answer
	
	//  Bitwise AND of x and y gives all carry bits. 
	// We calculate (x & y) << 1 and add it to x ^ y to get the required result.
	
	public static int addWithoutOperators(int x, int y) {
		// Iterate till there is no carry
		while(y != 0) {
			// carry now contains common set bits of x and y
			int carry = x & y;
			System.out.println("carry is : " + carry);
			
			// Sum of bits of x and y where at least one of the bits is not set
			x = x ^ y;
			System.out.println("x after xor is : " + x);
			
	        // Carry is shifted by one so that adding it to x gives the required sum
			y = carry << 1;
			System.out.println("y after left shifting carry is : " + y);
		}
		return x;
	}
	
	public static int addWOpr(int a, int b) {
		if (b == 0) return a;
		int sumWithoutCarry = a ^ b;
		int sumOfCarryOnly = (a & b) << 1;
		return addWOpr(sumWithoutCarry, sumOfCarryOnly);
	}

	public static int addWithoutOperatorsRecursive(int x, int y) {
		if(y == 0) 
			return x;
		else 
			return addWithoutOperatorsRecursive(x ^ y, (x&y) << 1);
	}
	
	public static void main(String[] args) {
		//System.out.println(addWithoutOperators(15, 1));
		//System.out.println(addWithoutOperatorsRecursive(15, 32));
		System.out.println(Integer.toBinaryString(759));
		System.out.println(Integer.toBinaryString(674));
		System.out.println(addWOpr(759, 674));
	}
}
