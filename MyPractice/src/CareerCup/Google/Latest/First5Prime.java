package CareerCup.Google.Latest;

public class First5Prime {
	
	public static void first5TenDigPrimes(int n) {
		
		int i = 1000000000;
		while (i%6 != 0) {
			i++;
		}
		//System.out.println("Divisible is : " + i);
		
		while (n >= 0) {
			if (checkPrime(i-1)) {
				System.out.println(i-1);
				n--;
			}
			if (checkPrime(i+1)) {
				System.out.println(i+1);
				n--;
			}
			i += 6;
		}
	}
	
	public static boolean checkPrime(int n) {
		for (int i=2; i<Math.sqrt(n); i++) {
			if (n%i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		first5TenDigPrimes(5);
		
		System.out.println(checkPrime(1000000007));
		
		System.out.println(checkPrime(1000000009));
		
		System.out.println(checkPrime(1000000021));
		
		System.out.println(checkPrime(1000000022));
	}

}
