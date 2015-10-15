package DynamicPrograming;

public class CountNumberOfBinaryWithoutConsecutive1s {
	
	
	/* Like fibonacci series */
	public int count(int n) {
		
		
		// We can initialize two arrays 
		// Both have zeroth position set to 1
		int a[] = new int[n];
		int b[] = new int[n];
		
		a[0] = 1;
		b[0] = 1;
		
		// Starting to set their positions from 1st indices
		// The first index means n=1, second means n=2 and so on
		// The reason we are using two arrays is it helps in starting for the 1st and 2nd index values
		// The latest index in array a will maintain the previous value to the current and the 
		// latest in b will have the previous to the previous value to the current one
		
		for (int i=1;i<n;i++) {
			a[i] = a[i-1] + b[i-1]; // 2, 3, 5
			b[i] = a[i-1]; // 1, 2, 3 
		}
		
		return a[n-1] + b[n-1];
	}
	
	public static void main(String[] args) {
		CountNumberOfBinaryWithoutConsecutive1s obj = new CountNumberOfBinaryWithoutConsecutive1s();
		System.out.println(obj.count(6));
	}

}
