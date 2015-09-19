package Bloomberg;

public class RandomNumberGenerator {
	
	/* Based on Linear Congruential generator 
	 * 
	 * Recurrence relation is : X(n+1) = [ aX(n) + c ] mod m
	 * where X is the sequence of pseudorandom values
	 * m is the modulus which is > 0
	 * a is the multiplier and 0 < a < m
	 * c is the increment and 0 < c < m
	 * X(o) is the seed or start value and 0 <=  X(o) < m
	 * 
	 * If c == 0 then the generator is called MCG, multiplicative congruential generator
	 * 
	 * Often m is a power of 2, m = 2^32 or 2^64 as this allows the modulus operation
	 * to be computed by merely truncating all but the right most 32 or 64 bits. 
	 * In Java, m = 2^64 and C++11 it is 2 ^31	
	 */
	
	private static final long a = 0x5DEECE66DL; // multiplier
	
	private static final long m = (long) Math.pow(2.0, 48.0); // 281474976710655; this is the modulus which is the mask
	
	private static final long c = 11; // 0xBL; this is the increment
	
	private long previous = 0;
	
	public void rseed(long seed) {
		previous = seed;
	}
	
	public long rand() {
		long r = (a * previous + c); // % m
		previous = r;
		return r;
	}
	
	public static void main(String args[]) {
		
		RandomNumberGenerator rng = new RandomNumberGenerator();
		rng.rseed(1000);
		System.out.println(rng.rand());
	}
}
