package CareerCup.Google.Latest;

public class MinimumSquareSums {

	public static int minimumSquareSum(int N) {		
		int sqrt = integerSquareRoot(N);
		int count = 0;
		while (N > 0) {	
			
			if (N - (sqrt * sqrt) >= 0) {
				N = N - (sqrt * sqrt);
				count++;
			}
			else {
				sqrt--;
			}

			if (N - (sqrt * sqrt) < 0) {
				sqrt = integerSquareRoot(N);
			}			
		}
		
		return count;
	}
	
	public static int integerSquareRoot(int n) {
		int l = 0, r = n;
		while (l <= r) {
			int m = l + ( (r-l)/2 );
			int ans = (m * m);
			if (ans == n) return m;
			
			else if (ans > n) {
				r = m-1;
			}
			else {
				l = m+1;
			}
		}
		return l-1;
	}
	
	public static void main(String[] args) {
		
		int N = 11;
		System.out.println(minimumSquareSum(N));
		
		System.out.println(minimumSquareSum(8));
		
		System.out.println(minimumSquareSum(15));
		
		System.out.println(minimumSquareSum(9));
		
		System.out.println(minimumSquareSum(1000));
		
		System.out.println(minimumSquareSum(39));
	}

}
