package AmazonQuestions;

public class DivisibleBy3UsingBinary {

	public static boolean divisibleBy3(int n){
		int odd_count = 0;
		int even_count = 0;
		if(n<0) n=-n;
		if(n==0) return false;
		if(n==1) return true;
		while(n!=0){//Until n!=0
			System.out.println("-------------------------");
			if((n&1) == 1)
				odd_count++;
			n=n>>1;
			System.out.println("n is " + n);
			if((n&1) == 0)
				even_count++;
			n=n>>1;
			System.out.println("n is " + n);
			System.out.println("-------------------------");
		}
		return divisibleBy3(Math.abs(odd_count - even_count));
	}
	
	public static boolean divBy3(int n, int k) {
		int cN = k;
		if (n == k) return true;
		do {
			k = k + cN;
			if (k == n) return true;
			n = n - cN;
		}while (k <= n);
		return false;
	}
	
	public static void main(String args[]){		
		// Calling the function
		System.out.println(DivisibleBy3UsingBinary.divisibleBy3(99));
		System.out.println(DivisibleBy3UsingBinary.divBy3(99, 3));
	}
}
