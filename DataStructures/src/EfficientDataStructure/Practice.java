package EfficientDataStructure;

public class Practice {

	public static void main(String[] args) {
		MyPoint p1 = new MyPoint(10, 10);
		MyPoint p2 = new MyPoint(20, 20);
		System.out.println(p1);
		System.out.println(p1.hashCode());
		MyPoint p3 = p1;
		System.out.println(p3);
	}
}

class MyPoint {
	private int x;
	private int y;
	public MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
