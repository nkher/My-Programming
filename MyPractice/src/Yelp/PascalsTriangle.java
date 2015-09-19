package Yelp;

public class PascalsTriangle {
	
	/* Method 1 - Simple iteration with 2 arrays */
	public void pascalsTriangleIter(int n) {
		int[] previousRow;
		int[] currentRow = {1};
		printArray(currentRow);
		previousRow = currentRow;
		for (int i=2;i<=n;i++) {
			currentRow = new int[i];
			/* Setting the first and last of the row to 1 */
			currentRow[0] = 1;
			currentRow[i-1] = 1;
			for (int j=0;j<=i-3;j++) {
				currentRow[j+1] = previousRow[j] + previousRow[j+1];
			}
			printArray(currentRow);
			previousRow = currentRow;
		}
	}
	
	public void printArray(int a[]) {
		for (int i=0;i<a.length;i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	/* Method 2 - Using recursion 
	 * Base condition for the first ans last elementts : pascal(i, 0) = 1 and pascal(i,i) = 1
	 * pascal ( i, j ) = pascal ( i - 1 , j -1 ) + pascal ( i - 1 , j )
	 */
	
	public void pascalTriangleRecur(int n) {		
		for (int i=0;i<n;i++) {
			System.out.format("%" + (n-i) * 2 + "s", "");
			for (int j=0;j<=i;j++) {
				int a = pascalTriangleRecurHelper(i, j);
				System.out.format("%4d", a);
			}
			System.out.println();
		}
	}
	
	public int pascalTriangleRecurHelper(int i, int j) {
		if (j == 0) return 1;
		else if (j == i) return 1;
		else return pascalTriangleRecurHelper(i-1, j-1) + pascalTriangleRecurHelper(i-1, j);
	}
	
	public void pascalTriangleRecurDP(int n) {
		int map[][] = new int[n+1][n+1];
		initMap(map);
		
		for (int i=0;i<n;i++) {
			System.out.format("%" + (n-i) * 2 + "s", "");
			for (int j=0;j<=i;j++) {
				int a = pascalTriangleRecurHelperDP(i, j, map);
				System.out.format("%4d", a);
			}
			System.out.println();
		}
	}
	
	public int pascalTriangleRecurHelperDP(int i, int j, int map[][]) {
		
		if (j == 0) return 1;
		else if (j == i) return 1;
		
		if (map[i-1][j-1] == -1) {
			map[i-1][j-1] = pascalTriangleRecurHelper(i-1, j-1);
		}
		if (map[i-1][j] == -1) {
			map[i-1][j] = pascalTriangleRecurHelper(i-1, j);
		}
		
		return map[i-1][j-1] + map[i-1][j];
	}
	
	public void initMap(int map[][]) {
		for (int i=0;i<map.length;i++) {
			for (int j=0;j<map[i].length;j++) {
				map[i][j] = -1;
			}
		}
	}
	
	
	
	/* Method 3
	 * Using binomial coefficients theory - (x+y)^n where n = no. of rows of the triangle.
	 * nCk = n! / (k! * (n-k)! )
	 */
	public void pascalTriangleBinomial(int n) {
		for (int x=0;x<n;x++) {
			System.out.format("%" + (n-x) * 2 + "s", "");
			for (int y=0;y<=x;y++) {
				int a = nCk(x, y);
				System.out.format("%4d", a);
			}
			System.out.println();
		}
	}
	
	public int nCk(int n, int k) {
		int numerator = fact(n);
		int denominator = fact(k) * fact(n-k);
		int result = (int) (numerator / denominator);
		return result;
	}
	
	public int fact(int num) { 
		int result = 1;
		for (int i=1;i<=num;i++) {
			result = result * i;
		}
		return result;
	}
	
	/* Method 4 */
	public void pascalIteration(int rows) {
		for (int i=0;i<rows;i++) {
			int number = 1;
			System.out.format("%" + (rows-i) * 2 + "s", "");
			for (int j=0;j<=rows;j++) {
				System.out.format("%4d", number);
				number = number * (i-j)/(j+1);
			}
			System.out.println();
		}
	}
	

	public static void main(String args[]) {
		PascalsTriangle object = new PascalsTriangle();
		int n = 10;
		
		/* Using iteration */
		//object.pascalsTriangleIter(n);
		
		System.out.println();
		
		/* Using Recursion */
		long t1 = System.currentTimeMillis();
		object.pascalTriangleRecur(5);
		long t2 = System.currentTimeMillis();;
		System.out.println(t2 - t1);
		
		System.out.println();
		System.out.println();
		
		/* DP */
		t1 = System.currentTimeMillis();
		//object.pascalTriangleRecurDP(33);
		t2 = System.currentTimeMillis();
		//System.out.println(t2 - t1);
		
		/* Using Binomial Thoory */
		//object.pascalTriangleBinomial(n);
		
		/* Method 4 */
		//System.out.println();
		//object.pascalIteration(5);
	}
}
