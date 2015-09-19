package BloombergQuestions;

public class MissingNumbers {

	public static void getMissingNumbers(int ar[], int n) {
		int sum = 0;
		int a_sum = 0, a_product=1;
		sum = n*(n+1)/2;
		int product = getProduct(n);
		for (int i=0;i<ar.length;i++) {
			a_sum += ar[i];
			a_product *= ar[i];
		}
		sum = sum - a_sum;
		product = product/a_product;
		int a = 1, b = -sum,c = product;
		int root1 = (int) (((Math.abs(b)) + (Math.sqrt( (b*b) - (4*a*c) )))/ (2*a));
		int root2 = sum - root1;
		System.out.println("Numbers " + root1 + " and " + root2 + " the missing numbers");
	}
	 
	public static int getProduct(int n) {
		if (n == 1) return 1;
		else
			return n * getProduct(n-1);
	}
	
	public static void main(String[] args) {
		int array[] = {8,6,4,3,10,9,7,1}; // 1 2 3 4 5 6 7 8 9 10
		MissingNumbers.getMissingNumbers(array, 10);
	}

}
