package DP;

public class CountBSTsWithNumberOfKeys {
	
	public static int countNumberOfBSTsPossible(int n) {
		
		if (n == 0) return 0;
		
		int T[] = new int[n+1];
		T[0] = T[1] = 1;
		
		for (int i=2; i<=n; i++) {
			int sum = 0;
			for (int j=0; j<i; j++) {
				sum += T[j] * T[i-j-1]; 
			}
			T[i] = sum;
		}
		
		return T[n];
	}
	
	public static void main(String[] args) {
		
		System.out.println("Total binary search trees possible : " + countNumberOfBSTsPossible(5));
	}

}
