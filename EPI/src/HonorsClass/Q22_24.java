package HonorsClass;

import java.util.Arrays;

public class Q22_24 {
	
	/* We first sort the array. Sorting might not help when you want the smallest reconstructible 
	 * change but it helps in knowing when we should not proceed ahead. Start the maxConstructible change
	 * from 0 and keep adding the current element. At every point keep checking if the (currentValue + 1)
	 * is achievable or not by checking the current element in the array which you are at.
	 * */
	public static int smallestNonConstructibleChange(int a[]) {
		int maxConstructible = 0;
		Arrays.sort(a);
		
		for (int change : a) {
			if (change > maxConstructible + 1) {
				break;
			}
			maxConstructible += change;
		}
		
		return maxConstructible + 1;
	}
	
	public static void main(String args[]) {
		
		int a[] = {1, 2, 4};
		System.out.println("Smallest cons change is : " + smallestNonConstructibleChange(a));
		
		int b[] = {1, 1, 1, 1, 1, 5, 10, 25};
		System.out.println("Smallest cons change is : " + smallestNonConstructibleChange(b));
	}
}
