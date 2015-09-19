package Twitter;

public class DivideUsingMultiply {
	
	
	// x = 20, y = 2, ans = 10
	public static int divideUsingMultiply(int dividend, int divisor) {
		int quotient = 1, checker = 0;
		
		if (divisor == dividend) return 1;
		
		while (checker < dividend) {
			quotient++;
			checker = divisor * quotient;
		}
		
		if (checker == dividend) return quotient;
		
		return quotient-1;
	}
	
	public static int divideUsingBinarySearch(int dividend, int divisor) {
		
		int s = 0, e = dividend;
		while (s <= e) {
			int m = s + (e - s) / 2;
			
			int ans = m * divisor;
			if (ans == dividend) return m;
			
			if (ans > dividend) {
				e = m - 1;
			}
			else {
				s = m + 1;
			}
		}
		
		return s-1;
	}
	
	public static void main(String[] args) {
		System.out.println(divideUsingMultiply(100, 3));
		
		System.out.println(divideUsingBinarySearch(100, 3));
		
		System.out.println(divideUsingBinarySearch(27, 10));
		
		System.out.println(divideUsingBinarySearch(102, 3));
	}

}
