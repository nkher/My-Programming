package AmazonQuestions;

import java.util.Arrays;

public class ThreeIntegerMultiplication {
	
	public static int getMaxMultiplicationValue(int a[]) {
		int max1=Integer.MIN_VALUE, max2=Integer.MIN_VALUE, max3=a[0], min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
		int result, i;
		for (i=0;i<a.length;i++) {
			
			// Getting 3 maximums
			if (a[i] > max1) {
				max2 = max1; // save previous max1 here
				max1 = a[i]; // get the max1
			}
			else if (a[i] > max2) { // update max2 only if the incoming value is not the highest value which is max 1
				max3 = max2;
				max2 = a[i];
			}
			else if (a[i] > max3) {
				max3 = a[i];
			}
			
			// Getting 2 minimums
			if (a[i] < min1) {
				min2 = min1;
				min1 = a[i];
			}
			else if (a[i] != min1) {
				min2 = Math.min(min2, a[i]);
			}
		}
		// separate loop for max3
		max3 = Integer.MIN_VALUE;
		for (i=0;i<a.length;i++) {
			if (a[i] < max2) {
				max3 = Math.max(max3, a[i]);
			}
		}
		System.out.println("max 1 " + max1);
		System.out.println("max 2 " + max2);
		System.out.println("max 3 " + max3);
		System.out.println("min 1 " + min1);
		System.out.println("min 2 " + min2);
		
		if ( (min1 * min2) > (max2 * max3) ) 
			return (min1 * min2 * max1);
		else
			return (max1 * max2 * max3);
	}
	
	public static void main(String[] args) {
		int a[] = {2,3,1,16,-8,-1,90};
		int result = ThreeIntegerMultiplication.getMaxMultiplicationValue(a);
		System.out.println(Arrays.toString(a));
		System.out.println("Answer is " + result);
	}

}
