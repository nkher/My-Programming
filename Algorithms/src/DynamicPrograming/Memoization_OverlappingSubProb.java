package DynamicPrograming;

public class Memoization_OverlappingSubProb {

	public static final int NIL = -1;
	public static final int MAX = 100;
	
	int lookup[] = new int[MAX];
	
	public void initialize() {
		int i;
		for(i=0; i<MAX; i++)
			lookup[i] = NIL;
	}
	
	public int fibonacci(int n) {
		if(lookup[n] == NIL) {
			if(n <= 1)
				return n;
			else 
				lookup[n] = fibonacci(n-1) + fibonacci(n-2);
		}
		return lookup[n];
	}
	
	
	public static void main(String[] args) {	
		
		Memoization_OverlappingSubProb movp = new Memoization_OverlappingSubProb();
		movp.initialize();
		System.out.println("Fib of 5 is : " + movp.fibonacci(8));
		
	}

}
