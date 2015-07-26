package AmazonQuestions;

public class Median2SortedArrays {
	
	public static int getMedian(int a1[], int a2[], int n) {
		
		int i = 0; // a1 counter
		int j = 0; // a2 counter
		int count;
		int m1 = -1, m2 = -1;
		
		for (count=0;count<=n;count++) {
			if (i == n) {
				m1 = m2;
				m2 = a2[0]; // make the first elem of the next array as the median 1
				break;
			}
			else if (j == n) {
				m1 = m2;
				m2 = a1[0];  // make the first elem of the next array as the median 1
				break;
			}
			if (a1[i] < a2[j]) { // if a1 is smaller
				m1 = m2; /* Store the prev median */
				m2 = a1[i];
				i++;
			}
			else { // if a2 is smaller
				m1 = m2; /* Store the prev median */
				m2 = a2[j];
				j++;
			}
		}
		return (m1 + m2)/2;
	}
	
	public static void main(String[] args) {
		int a1[] = {1, 2, 3, 4, 5, 8}; 
		int a2[] = {1, 2, 3, 4, 5, 8};
		int n = a1.length;
		
		int median = getMedian(a1, a2, n);
		System.out.println(median);
	}

}
