package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Q14_7 {
	
	public static ArrayList<Interval> unionOfIntervals(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) return new ArrayList<Interval>();
		
		Arrays.sort(intervals);
		
		ArrayList<Interval> result = new ArrayList<Interval>();
		
		for (Interval i : intervals) {
			System.out.println(i.toString());
		}
		
		Interval curr = intervals[0];
		
//		for (int i=1; i<intervals.length; i++) {
//			if (intervals[i].left.val < curr.right.val || (intervals[i].left.val == curr.right.val && intervals[i].left.isClosed || curr.right.isClosed)) {
//				
//				if (intervals[i].right.val > curr.right.val || (intervals[i].right.val == curr.right.val && intervals[i].right.isClosed) ) {
//					curr.right = intervals[i].right;
//				}
//			}
//			else {
//				result.add(curr);
//				curr = intervals[i];
//			}
//		}
		
		return result;
	}

	public static void main(String[] args) {
		
		Interval intervals[] = {new Interval(new EndPoint(0, false), new EndPoint(3, false)), new Interval(new EndPoint(1, true), new EndPoint(1, true)),
				new Interval(new EndPoint(2, false), new EndPoint(4, false)), new Interval(new EndPoint(3, true), new EndPoint(4, false)),
				new Interval(new EndPoint(5, true), new EndPoint(7, false)), new Interval(new EndPoint(7, true), new EndPoint(8, false)),
				new Interval(new EndPoint(8, true), new EndPoint(11, false)), new Interval(new EndPoint(9, false), new EndPoint(11, true)),
				new Interval(new EndPoint(12, true), new EndPoint(14, true)), new Interval(new EndPoint(12, false), new EndPoint(16, true)),
				new Interval(new EndPoint(13, false), new EndPoint(15, false)), new Interval(new EndPoint(16, false), new EndPoint(17, false))};
		
		unionOfIntervals(intervals);
	}

}

class Interval implements Comparator<Interval> {
	
	public EndPoint left, right;
	
	public Interval(EndPoint left, EndPoint right) {
		this.left = left;
		this.right = right;
	}
	
	public String toString() {
		return "[ left -> " + left.toString() + "], right -> " + right.toString() + "]";
	}
	
	public int compare(Interval o1, Interval o2) {
		return o1.left.compareTo(o2.left);
	}
}

class EndPoint implements Comparator<EndPoint> {
	public boolean isClosed;
	public int val;
	
	public EndPoint() {
		
	}
	
	public EndPoint(int val, boolean isClosed) {
		this.val = val;
		this.isClosed = isClosed;
	}
	
	public int compareTo(EndPoint ep) {
		if (this.val < ep.val) return -1;
		else if (this.val > ep.val) return 1;
		else return 0;
	}
	
	public String toString() {
		return "[" + val + "]";
	}

	public int compare(EndPoint o1, EndPoint o2) {
		if (o1.val < o2.val) return -1;
		else if (o1.val > o2.val) return 1;
		else return 0;
	}
}
