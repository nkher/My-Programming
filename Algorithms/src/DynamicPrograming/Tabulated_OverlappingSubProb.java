package DynamicPrograming;

public class Tabulated_OverlappingSubProb {
	
	public int fibonacci(int n) {
		int f[] = new int[n+1];
		int i;
		f[0] = 0; f[1] = 1;
		for(i=2; i<=n; i++)
			f[i] = f[i-1] + f[i-2];
		return f[n];
	}
	
	public static void main(String[] args) {
		Tabulated_OverlappingSubProb tosp = new Tabulated_OverlappingSubProb();
		int retVal = tosp.fibonacci(10);
		System.out.println("10th fib number is : " + retVal);
	}

}
