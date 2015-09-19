package CareerCup.Google.Latest;

import java.util.Arrays;

public class ArrangeNegPositive {
	
	public static int[] arrangeNegPosAlternate(int a[]) {
		
		int posIdx = 0, negIdx = 1, i=0;
		for (i=0; i<a.length; i++) { // even is pos and odd is neg
			
			if (a[i] > 0) {
				
				if ((posIdx&i) == 0) { // means pos found at even index
					continue;
				}
				else if ( ((negIdx-1)&i) == 0 ){ //  means pos found at odd index
					swapAt(a, i, negIdx);
					negIdx = negIdx + 2;
				}
			}
			else if(a[i] < 0){
				
				if ( ((negIdx-1)&i) == 0 ) { // means neg found at odd index 
					continue;
				}
				else if ((posIdx&i) == 0) { // means neg found at even index
					swapAt(a, posIdx, i);
					posIdx = posIdx + 2;
				}
			}
		}
		
		return a;
	}
	
	public static void swapAt(int a[], int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	
	public static void main(String[] args) {
		
		int a[] = {1, 2, 3, -4, -1, 4};
		
		System.out.println(Arrays.toString(arrangeNegPosAlternate(a)));
	}

}
