package PalantirQuestions;

public class Multiplication {
	
	// TC -> O(y)
	public static int multiply(int x, int y) {
		if (y == 0) 
			return 0;
		if (y > 0) 
			return (x + multiply(x, y-1));
		if (y < 0) // y is negative
			return -multiply(x, -y);
		return y;
			
	}
	
	public static void main(String[] args) {
		System.out.println(multiply(55555, 5555));
	}

}
