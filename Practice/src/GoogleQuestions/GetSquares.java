package GoogleQuestions;

public class GetSquares {
	
	public int getSquares(int A, int B) {
		int counter = 0;
		while (A <= B) {
			if (Math.sqrt(A) == Math.floor(Math.sqrt(A))) {
				counter++;
				A = (int) Math.pow(((int)Math.sqrt(A) + 1), 2);
			}
		}
		return counter;
	}
	
	public static void main(String[] args) {
		
		GetSquares obj = new GetSquares();
		int ret = obj.getSquares(4, 150);
		System.out.println(ret);
	}

}
