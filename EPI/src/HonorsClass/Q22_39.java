package HonorsClass;

public class Q22_39 {
	
	// TC = O((c+1)(d+1))
	// F(c+1, d) = F(c, d-1) + F(c-1, d-1) + 1
	// Do read up from the book
	public static int maxHeight(int c, int d) {
		
		int F[][] = new int[c+1][d+1];
		for (int i=0; i<F.length; i++) {
			for (int j=0; j<F[0].length; j++) {
				F[i][j] = -1;
			}
		}
		return maxHeightHelper(c, d, F);
	}
	
	public static int maxHeightHelper(int c, int d, int F[][]) {
		
		if (c == 0 || d == 0) {
			return 0;
		}
		else if (c == 1) {
			return d;
		}
		else {
			if (F[c][d] == -1) {
				F[c][d] = maxHeightHelper(c-1, d-1, F) + maxHeightHelper(c, d-1, F) + 1;
			}
			return F[c][d];
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println(maxHeight(1, 5));
		
		System.out.println(maxHeight(2, 5));
		
		System.out.println(maxHeight(2, 14));
	}

}
