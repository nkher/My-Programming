package HonorsClass;

import Library.PairOfInts;

public class Q22_44 {
	
	public static PairOfInts findPairSumK(int a[], int k) {
		PairOfInts result = findPosNegPair(a, k);
		if (result.first == -1 && result.second == -1) {
			return k >= 0 ? findPairUsingComparison(a, k, new LesserThan(0)) : findPairUsingComparison(a, k, new GreaterEqualThan(0));
		}
		return result;
	}
	
	// this means both numbers in the pair are negative or else positive
	public static PairOfInts findPairUsingComparison(int a[], int k, CompareIntsWithZero comp) {
		PairOfInts result = new PairOfInts(0, a.length-1);
				
		while (result.first < result.second && (comp.compareTo(a[result.first]) == -1)) {
			++result.first;
		}
		
		while (result.first < result.second && (comp.compareTo(a[result.first]) == -1)) {
			++result.second;
		}
		
		while (result.first < result.second) {
			if (a[result.first] + a[result.second] == k) {
				return result;
			}
			
		}
		
		return null;
	}
	
	public static PairOfInts findPosNegPair(int a[], int k) {
		
		int n = a.length;
		PairOfInts result = new PairOfInts(n-1, n-1);
		
		// find the last positive
		while (result.first >= 0 && a[result.first] < 0) {
			--result.first;
		}
		
		// the first negative value
		while (result.second >= 0 && a[result.second] >= 0) {
			--result.second;
		}
		
		while (result.first >= 0 && result.second >= 0) {
			if (a[result.first] + a[result.second] == k) {
				return result;
			}
			else if ( (a[result.first] + a[result.second]) > k) {
				do {
					--result.first;
				} while (result.first >= 0 && a[result.first] < 0);
			}
			else {
				do {
					--result.second;
				} while (result.second >= 0 && a[result.second] > 0);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int a[] = {-49, 75, 103, -147, 164, -197, -238, 314, 348, -422};		
		//System.out.println(findPairSumK(a, 167));
		
		System.out.println(findPairUsingComparison(a, 167, new GreaterEqualThan(0)));
	}

}

class CompareIntsWithZero implements Comparable<Integer> {
	
	int i;
	public int compareTo(Integer o) {
		return 0;
	}
	
}

class GreaterEqualThan extends CompareIntsWithZero {
	
	public GreaterEqualThan(int i) {
		this.i = i;
	}
	
	public int compareTo(Integer o) {
		if (o.intValue() == this.i) return 1;
		else if (o.intValue() > this.i) return 1;
		else return -1;
	}	
}

class LesserThan extends CompareIntsWithZero {
	
	public LesserThan(int i) {
		this.i = i;
	}
	
	public int compareTo(Integer o) {		
		if (o.intValue() < this.i) return 1;
		else return -1;
	}
}

