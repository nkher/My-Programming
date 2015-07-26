package PalantirQuestions;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FindCollinearPoints {

	public static final double NO_SLOPE = Integer.MIN_VALUE;
	
	public static void getAllCollinearPoints(ArrayList<Point> list) {
		HashMap<Double, HashSet<Point>> map = null;
		for (int i=0;i<list.size();i++) {
			Point outer_curr = list.get(i);
			map = new HashMap<Double, HashSet<Point>>();
			for (int j=i+1;j<list.size();j++) {
				Point inner_curr = list.get(j);
				double slope = getSlope(outer_curr, inner_curr);
				if(!map.containsKey(slope)) {
					map.put(slope, new HashSet<Point>());
				}
				HashSet<Point> set = map.get(slope);
				set.add(inner_curr);
				set.add(outer_curr);
				map.put(slope, set);
			}
			printmap(map);
		}	
	}
	
	public static void printmap(HashMap<Double, HashSet<Point>> map) {
		// Printing the co-linear points
				for (Double val : map.keySet()) {
					HashSet<Point> points = map.get(val);
					if (points.size() >= 3) {
						System.out.println("\nCollinear Points with slope " + val + " are : ");
						for (Point p : points)
							System.out.print(printPoint(p) + " ");
					}
				}
	}
	
	public static String printPoint(Point p) {
		String s = "( " + p.x + ", " + p.y + ")";
		return s;
	}
	
	
	public static double getSlope(Point p1, Point p2) {
		int deltaY = p2.y - p1.y;
		int deltaX = p2.x - p1.x;
		if (deltaY == 0)
			return 0;
		if (deltaX == 0)
			return NO_SLOPE;
		double slope = (p2.y - p1.y)/(p2.x - p1.x);
		return slope;
	}

	public static void main(String[] args) {
		ArrayList<Point> listofpoints = new ArrayList<Point>();
		Point p1 = new Point(1, 1);
		Point p2 = new Point(0, 0);
		Point p3 = new Point(8, 8);
		Point p4 = new Point(0, 1);
		Point p5 = new Point(7, 1);
		Point p6 = new Point(1, 4);
		Point p7 = new Point(1, -10);
		listofpoints.add(p1);
		listofpoints.add(p2);
		listofpoints.add(p3);
		listofpoints.add(p4);
		listofpoints.add(p5);
		listofpoints.add(p6);
		listofpoints.add(p7);
		
		getAllCollinearPoints(listofpoints);

		
		Point[] array = new Point[7];
		array = listofpoints.toArray(array);
		for (int i=0;i<array.length;i++) {
			System.out.println(array[i].toString());
		}		
	}

}
