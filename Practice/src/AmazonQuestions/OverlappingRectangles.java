package AmazonQuestions;

public class OverlappingRectangles {

	public boolean doOverlap(RectPoint topLeft1, RectPoint bottomRight1, RectPoint topLeft2, RectPoint bottomRight2) {
		// here we will check only for two conditions 
		// 1. one is on the left of the second ones right
		if((topLeft2.getY() < bottomRight1.getY()) || (topLeft1.getY() < bottomRight2.getY()))
			return false;
			// 2. one is below the top of the other one
		if((topLeft2.getX() > bottomRight1.getX()) || (topLeft1.getX() > bottomRight2.getY()))
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		OverlappingRectangles obj = new OverlappingRectangles();
		
		RectPoint topLeft1 = new RectPoint(0, 10);
		RectPoint topLeft2 = new RectPoint(8, 10);
		RectPoint bottomRight1 = new RectPoint(10, 0);
		RectPoint bottomRight2 = new RectPoint(15, 0);
		
//		RectPoint topLeft1 = new RectPoint(0, 10);
//		RectPoint topLeft2 = new RectPoint(10, 10);
//		RectPoint bottomRight1 = new RectPoint(10, 0);
//		RectPoint bottomRight2 = new RectPoint(15, 0);
		
		// call the function to check if overlap
		if(obj.doOverlap(topLeft1, bottomRight1, topLeft2, bottomRight2))
			System.out.println("Rectangles overlap");
		else
			System.out.println("Do not overlap");
	}
}

class RectPoint {
	private int x;
	private int y;
	
	public RectPoint() {}
	
	public RectPoint(int p1, int p2) {
		x = p1;
		y = p2;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int p1) {
		x = p1;
	}
	
	public void setY(int p2) {
		y = p2;
	}
}
