package AmazonQuestions;

import java.util.Stack;

public class TimeIntervalMerge {
	
	public static void mergeSortIntervals(Interval[] intervals) {
		int n = intervals.length;
		int mid = n/2;
		Interval left[] = new Interval[mid];
		Interval right[] = new Interval[n - mid];
		
		if (n < 2) return;
		for(int i=0;i<mid;i++) {
			left[i] = intervals[i];
		}
		for(int i=mid;i<n;i++) {
			right[i-mid] = intervals[i];
		}
		
		// Applying the recursion on left and then right
		mergeSortIntervals(left);
		mergeSortIntervals(right);
		
		// Calling merge function
		merge(left, right, intervals);
	}
	
	public static void merge(Interval left[], Interval right[], Interval intervals[]) {
		int nLeft = left.length;
		int nRight = right.length;
		int i=0, j=0, k=0; // creating left, right and main intervals array iterators
		while (i < nLeft && j < nRight) {
			if (left[i].startTime < right[j].startTime) {
				intervals[k] = left[i];
				i++;
			}
			else {
				intervals[k] = right[j];
				j++;
			}
			k++;
		}
		while (i < nLeft) {
			intervals[k] = left[i];
			i++;
			k++;
		}
		while (j < nRight) {
			intervals[k] = right[j];
			j++;
			k++;
		}
	}
	
	public static void display(Interval[] intervals) {
		int j = 0;
		for (Interval i : intervals) {
			System.out.print("Interval " + j + ": " + "(" + i.startTime + "," + i.endTime + ")\n");
			j++;
		}
	}
	
	public static void display(Stack<Interval> intervalStack) {
		int j = 0;
		while(!intervalStack.isEmpty()) {
			Interval i = intervalStack.pop();
			System.out.print("Interval " + j + ": " + "(" + i.startTime + "," + i.endTime + ")\n");
			j++;
		}
	}
	
	public static Stack<Interval> mergeIntervals(Interval[] intervals) {
		Stack<Interval> intervalStack = new Stack<Interval>();
		
		mergeSortIntervals(intervals); // Applying merge sort onto the intervals array
		intervalStack.push(intervals[0]); // Push the first element into the stack 
		
		// Looping over the array after sorting 
		for (int i=1;i<intervals.length;i++) {
			Interval top = intervalStack.peek();
			if (top.endTime > intervals[i].startTime) {
				// Make the new interval object
				Interval mergedInterval = new Interval(top.startTime, intervals[i].endTime);
				intervalStack.pop(); // pop the top interval from stack
				// Put the merged interval onto the top
				intervalStack.push(mergedInterval);
			}
			else {
				intervalStack.push(intervals[i]);
			}
		}
		return intervalStack;
	}
	 
	public static void main(String[] args) {
		
		Interval[] intervals = new Interval[4];
		intervals[0] = new Interval(1, 3);
		intervals[1] = new Interval(5, 7);
		intervals[2] = new Interval(6, 8);
		intervals[3] = new Interval(2, 4);
		
		System.out.println("Intervals before sorting");
		TimeIntervalMerge.display(intervals);
		
		Stack<Interval> intervalsStack =  TimeIntervalMerge.mergeIntervals(intervals);
		
		System.out.println("Intervals after sorting");
		TimeIntervalMerge.display(intervals);
		
		System.out.println("Merged intervals after sorting in descending order");
		TimeIntervalMerge.display(intervalsStack);
	}

}

class Interval {
	int startTime;
	int endTime;
	
	public Interval(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
}
