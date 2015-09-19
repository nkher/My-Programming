package Bloomberg;

public class DigitsSum {
	
	public static int sumDig(int x) {
		
		if (x == 0) return 0;
		return (x-1) % 9 + 1;
	}
	
	public static int sumDig2(int x) {
		if (x == 0) return 0;
		
		double div = 9.0, n = (double)x;
		
		return (int) (n - (Math.ceil(n/div)-1.0) * 9);
	}
	
	public static void main(String[] args) {
		
		System.out.println(sumDig(38));
		System.out.println(sumDig(134));
		
		System.out.println(sumDig2(38));
		System.out.println(sumDig2(134));
	}

}
