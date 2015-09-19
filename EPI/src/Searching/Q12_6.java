package Searching;

public class Q12_6 {
	
	public static double squareRootFloat(double number) {
		double x = number;
		double y = 0;
		double e = 0.00001;
		
		while (x - y > e) {
			x = (x + y) / 2;
			y = number / x;
		}
		
		return (double) Math.round(x * 10000) / 10000;
	}
	
	public static void main(String[] args) {
		
		System.out.println(squareRootFloat(21));
	}
}
