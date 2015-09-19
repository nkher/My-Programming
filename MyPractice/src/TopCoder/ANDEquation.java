package TopCoder;

import java.util.ArrayList;

/* A[] contains n+1 elements. Find any combination of n elements from the array such that the 
 * & of all of those N elements equals the one remaining element. If there such a combination then 
 * return Y else if not then return -1 */

// 106/250 points only !
public class ANDEquation {
	
	// The basic logic is that & operation reduces a number and never increases
	public static int restoreY(int A[]) {
		
		
		/* If length is less than or equal to 2 then sorry no chance */
		if (A.length <= 2) return -1;
		
		
		/* Get the smallest element of the array which would be the only possible Y */
		ArrayList<Integer> list = new ArrayList<Integer>();
		int Y = smallestInA(A); 
		boolean smallestVisited = true;
		
		/* Remove only one instance of the smallest number from the array and copy rest to another array */
		for (int i=0;i<A.length;i++) {
			if (A[i] == Y && smallestVisited) {
				// list.add(A[i]);
				smallestVisited = !smallestVisited;
			}
			else {
				list.add(A[i]);
			}
		}
		
		/* Let result be AND of 1st two elements and hence forth keep calculating the AND */				
		int result = list.get(0) & list.get(1); // initialize the result
		for (int j=2;j<list.size();j++) {
			result &= list.get(j);
		}
		
		return (result == Y) ? Y : -1;
	}
	
	public static int smallestInA(int A[]) {
		int min = Integer.MAX_VALUE;
		for (int i=0;i<A.length;i++) {
			min = Math.min(min, A[i]);
		}
		return min;
	}
	
	public static void main(String args[]) {
		
		int a[] = {1362,1066,1659,2010,1912,1720,1851,1593,1799,1805,1139,1493,1141,1163,1211};
		
		int b[] = {2, 3, 7, 19};
		
		int c[] = {191411,256951,191411,191411,191411,256951,195507,191411,192435,191411,191411,195511,191419,191411,256947,191415,191475,195579,191415,191411, 191483,191411,191419,191475,256947,191411,191411,191411,191419,256947, 191411,191411,191411};
		
		int d[] = {1,0,0,1,0,1,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,1,0,1,1,0,0,0,1};
		
		int e[] = {1, 3, 5};
		
		int f[] = {31, 7};
		
		//System.out.println(restoreY(a));
		
		System.out.println(restoreY(b));
		
		//System.out.println(restoreY(c));
		
		//System.out.println(restoreY(d));
		
		//System.out.println(restoreY(e));
		
		//System.out.println(restoreY(f));
	}
}
