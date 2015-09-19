package HonorsClass;

public class Q22_18 {
	
	// TC = O(logN)
	public static int searchKeyUnknownLengthArray(int a[], int k) {
		
		int p = 0;
		while (true) {
			try {
				int index = (1 << p) - 1; // 2^p -1
				if (a[index] == k) {
					return index;
				}
				else if (a[index] > k) {
					break;
				}
			}
			catch (Exception e) {
				break;
			}
			p++;
		}
		
		// Now we have the value of there for binary search [2^(i-1) and 2^(i) - 2]
		int left = 1 << (p - 1), right = (1 << p) - 2;
		while (left <= right) {
			int mid = left + ((right - left)/2);
			
			try {
				if (a[mid] == k) return k;
				else if (a[mid] > k) {
					left = mid + 1;
				}
				else {
					right  = mid - 1;
				}
			}
			catch(Exception e) {
				right = mid - 1;
			}
		}
		return -1;
	}
	
	public static void main(String args[]) {
		
		int a[] = {1, 2, 3, 5, 6, 8, 9, 10};
		System.out.println(searchKeyUnknownLengthArray(a, 5));
	}
}
