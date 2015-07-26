package AmazonQuestions;

public class SquareRoot {
	
	// Babylons method to get the square root
	public static double squareRoot(double n) {
		double x = n;
		double y = 1;
		double e = 0.000001;
		while (x - y > e) {
			x = (x+y)/2;
			y = (n/x);
		}
		return (double)Math.round(x * 10000)/10000;
	}
	
	public static void main(String[] args) {
		double x = 100.00;
		System.out.println(squareRoot(x));
		double y = 2;
		System.out.println(squareRoot(y));
		System.out.println(squareRoot(25));
	}

}
