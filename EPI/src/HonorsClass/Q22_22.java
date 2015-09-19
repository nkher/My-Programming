package HonorsClass;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import Library.Line;

public class Q22_22 {
	
	// TC = O(n^2) time
	// Find the line which has most number of points through it
	public static Line findLineWithMostPoints(ArrayList<Point> points) {
		
		HashMap<Line, HashSet<Point>> table = new HashMap<Line, HashSet<Point>>();
		int n = points.size();
		
		for (int i=0; i<n; i++) {
			for (int j=i+1; j<n; j++) {
				
				Line l = new Line(points.get(i), points.get(j));
				HashSet<Point> set;
				if (!table.containsKey(l)) {
					table.put(l, new HashSet<Point>());
				}
				set = table.get(l);
				set.add(points.get(i));
				set.add(points.get(j));
			}
		}
		
		// Return the line with maximum points
		Line toReturn = new Line();
		int currMax = 0;
		
		for (Line l : table.keySet()) {
			int pts = table.get(l).size();
			if (pts > currMax) {
				currMax = pts;
				toReturn = l;
			}
		}
		
		return toReturn;
	}
	
	public static void main(String[] args) {
		
		ArrayList<Point> points = new ArrayList<Point>();
		
		Point p1 = new Point(1, 1);
		Point p2 = new Point(2, 2);
		Point p3 = new Point(3, 3);
		Point p4 = new Point(4, 4);
		Point p5 = new Point(4, 5);
		Point p6 = new Point(1, 8);
		Point p7 = new Point(9, 2);
		Point p8 = new Point(18, 3);
		
		points.add(p1);
		points.add(p2);
		points.add(p3);
		points.add(p4);
		points.add(p5);
		points.add(p6);
		points.add(p7);
		points.add(p8);
		
		System.out.println(findLineWithMostPoints(points).toString());
	}

}
