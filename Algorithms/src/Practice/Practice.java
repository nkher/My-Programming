package Practice;

public class Practice {
	
	public static void fibonacci(int range) {
		int curr = 1, prev = 0, next;
		for (int i=0;i<range;i++) {
			System.out.print(prev + "  ");
			next = prev + curr;
			prev = curr;
			curr = next;
		}
	}
	
	public static int fibRec(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		else 
			return fibRec(n-1) + fibRec(n-2);
	}
	
	public static void main(String[] args) {
		int range = 10;
		Practice.fibonacci(range);
		
		System.out.println();
		range = 10;
		for (int i=0;i<range;i++) {
			System.out.print(Practice.fibRec(i) + "  ");
		}
	}

}
