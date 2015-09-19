package Google;

import java.util.ArrayList;

// Not sure if this solution is correct or not
public class EquilibriumPoints {
	
	public static ArrayList<Integer> getEquilibriumPoints(int a[]) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		return getEquilibriumPoints(a, 0, a.length-1, list);
	}
	
	private static ArrayList<Integer> getEquilibriumPoints(int a[], int left, int right, ArrayList<Integer> list) {
		
		if (left < right) {
			int mid = left + (right - left) / 2;
			int leftSum = getSum(a, left, mid-1);
			int rightSum = getSum(a, mid+1, right);
			
			if (leftSum == rightSum) {
				// adding to the list and check on both parts of the array
				list.add(mid);
				getEquilibriumPoints(a, left, mid-1, list); // recurse left 
				getEquilibriumPoints(a, mid+1, right, list); // recurse right
			}
			else if (leftSum < rightSum) { // you have to got right as there can be no equilibrium on left
				getEquilibriumPoints(a, mid+1, right, list); // recurse right
			}
			else if (rightSum < leftSum) { // you have to got right as there can be no equilibrium on left
				getEquilibriumPoints(a, left, mid-1, list); // recurse left 
			}
		}
		return list;
	}
	
	public static int getSum(int a[], int start, int end) {
		int sum = 0;
		for (int i=start;i<=end;i++) {
			sum += a[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		
		int a[] = {1, 2, 4, 2, 3, 3, 1};
		System.out.println("Equilibrium indexes are : " + getEquilibriumPoints(a).toString());
	}
}
