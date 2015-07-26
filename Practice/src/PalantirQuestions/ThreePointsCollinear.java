package PalantirQuestions;

import java.awt.Point;

public class ThreePointsCollinear {

	public static boolean checkcollinear(Point p1, Point p2, Point p3) {
		double area = areaofTriangle(p1, p2, p3);
		if (area == 0) return true;
		else return false;
	}
	
	public static double areaofTriangle(Point p1, Point p2, Point p3) {
		double det = 0;
		det = Math.abs( p1.x * (p2.y - p3.y) + p2.x * (p3.y - p1.y) + p3.x * (p1.y - p2.y) );
		det = det / 2;
		return det;
	}
	
	public static void main(String[] args) {
		Point p1 = new Point(1, 1);
		Point p2 = new Point(1, 2);
		Point p3 = new Point(8, 8);
		
		if (checkcollinear(p1, p2, p3))
			System.out.println("Points are collinear");
		else System.out.println("Points are not collinear");
	}
}

