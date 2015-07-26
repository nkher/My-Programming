package BloombergQuestions;

// Program to find the first and second minimum index in an unsorted array
public class FirstSecMinIndex {
	
	// 1. First Method
	// sort the array in nlog(n) and return first and second index
	
	// 2. Second Method
	public static void printFirstAndSecondSmallest(int a[]) {
		int firstMinInd = 0, i;
		int smallest = a[1];
		for (i=1;i<a.length;i++) {
			if(a[i] < smallest) {
				smallest = a[i];
				firstMinInd = i;
			}
		}
		int secSmallest = a[0];
		int secondMinInd = 0;
		for (i=1;i<a.length;i++) {
			if((a[i] < secSmallest) && (a[i] > smallest)) {
				secSmallest = a[i];
				secondMinInd = i;
			}
		}
		System.out.println("Index with smallest element is : " + firstMinInd);
		System.out.println("Index with secondSmallest element is : " + secondMinInd);
	}
	
	// 3. Third Method
	public static void printFirstAndSecondSmallest2(int a[]) {
		int fsi=0, ssi = Integer.MAX_VALUE, fs=a[0], ss = Integer.MAX_VALUE;
		for(int i=1;i<a.length;i++) {
			if(a[i] < fs) { // update first and second if current is smaller than the first
				// make the second one the first one
				ss = fs;
				ssi = fsi;
				// make the current one the smallest one
				fsi = i;
				fs = a[i];
			}
			if(a[i] < ss && a[i] != fs) {
				ss = a[i];
				ssi = i;
			}
		}
		System.out.println("Index with smallest element is : " + fsi);
		System.out.println("Index with secondSmallest element is : " + ssi);
	}
	
	public static void main(String[] args) {
		int a[] = {10, 2, 2, 15, 5, 1, 90};
		FirstSecMinIndex.printFirstAndSecondSmallest2(a);
	}
}
