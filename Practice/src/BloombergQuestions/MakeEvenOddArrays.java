package BloombergQuestions;

public class MakeEvenOddArrays {
	
	public static void makeEvenOddArrays(int a[], int b[]) {
		// 'a' is even and 'b' is odd
		int n = a.length, i = 0, j =0;
		while(i < n && j <n) {
			if(a[i]%2 == 0) { // If element is even
				i++; 
				continue;
			}
			if(b[j]%2 != 0) { // If element is odd
				j++;
				continue;
			}
			else { // swap
				int temp = a[i];
				a[i] = b[j];
				b[j] = temp;
			}
		}
	}
	
	public static void printArray(int c[]) {
		for(Integer i : c)
			System.out.print(i + " ");
	}
	
	public static void main(String[] args) {
		int a[] = {1,2,3,4,5,6};
		int b[] = {7,8,9,10,33,54};
		makeEvenOddArrays(a, b);
		System.out.println("even array");
		printArray(a);
		System.out.println("\nodd array");
		printArray(b);
	}
}
