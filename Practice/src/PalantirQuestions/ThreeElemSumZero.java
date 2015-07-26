package PalantirQuestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ThreeElemSumZero {

	public static void getTripletSumZero(int a[]) {
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		Set<Integer> set = new HashSet<Integer>();
		for (int i=0;i<a.length;i++)
			set.add(a[i]);
		for (int i=0;i<a.length;i++) {
			for (int j=i+1;j<a.length;j++) {
					int sum_pair = a[i] + a[j];
					if (sum_pair > 0)
						if (set.contains(-sum_pair) && (a[i] != -sum_pair && a[j] != -sum_pair) ) {
							System.out.println("a.\t" + a[i] + "\tb.\t" + a[j] + "\tc.\t" + -sum_pair);
						}
					else {
						if (set.contains(-sum_pair) && (a[i] != -sum_pair && a[j] != -sum_pair) ) {
							System.out.println("a.\t" + a[i] + "\tb.\t" + a[j] + "\tc.\t" + sum_pair);
						}
					}
			}
		}
	}
	
	public static void main(String[] args) {
		int a[] = {12, 3, -5, 7, 4, 19, 1, -6, -1, -2, 8};
		ThreeElemSumZero.getTripletSumZero(a);
	}

}
