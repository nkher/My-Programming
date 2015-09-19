package YouTube;

import java.util.Arrays;

public class WiggleSort {
	
	public static int[] wigglesort(int a[]) {
		int len = a.length;
		if (len < 2) return a;
		for (int i=0;i<len-1;i=i+2) { // The key here is to run the algorithm till (len - 1)
			swap(a, i, i+1);
		}
		return a;
	}
	
	public static void swap(int a[], int index1, int index2) {
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}
	
	public static void main(String[] args) {
		
		int a[] = {1,2,3,4,5,6,7,8};
		System.out.println("Before wiggle sorting : " + Arrays.toString(a));
		wigglesort(a);
		System.out.println("After wiggle sorting : " + Arrays.toString(a));		
		
		int b[] = {1,2,3,4,5,6,7};
		System.out.println("Before wiggle sorting : " + Arrays.toString(b));
		wigglesort(b);
		System.out.println("After wiggle sorting : " + Arrays.toString(b));
		
		int c[] = {12, 78, 100, 150, 162, 199, 217, 799};
		System.out.println("Before wiggle sorting : " + Arrays.toString(c));
		wigglesort(c);
		System.out.println("After wiggle sorting : " + Arrays.toString(c));
		
	}

}
