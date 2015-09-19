package CareerCup.Google;

public class NthElement2SortedArrays {
	
	public static int nthElement(int a[], int b[], int n) {
		
		int i = 0, j = 0; 
		int currElem = 0;// current will store the elem at nth index at the end
		int mergedInd = -1;
		while (i < a.length && j < b.length) {
			
			currElem = a[i] <= b[j] ? a[i++] : b[j++];
			mergedInd++;
			
			if (n == mergedInd) {
				if (i < a.length && currElem == a[i-1]) { // return a[i]
					return currElem;
				}
				else if ( j < b.length && currElem == b[j-1]) {
					return currElem;
				}
			}
		}
		
		while (i < a.length) { // if i has not yet completed
			if (++mergedInd == n) { // return a[i]
				return a[i];
			}
			i++;

		}
		
		while (j < b.length) {			
			if (++mergedInd == n) { // return a[i]
				return b[j];
			}
			j++;
		}
		
		return -1;
	}
	
	public static void main(String []args) {
		
		int a[] = {1,3,9,14};
		int b[] = {5,6,7,14,17};
		
		System.out.println("3rd element is : " + nthElement(a, b, 3));
	}
}
