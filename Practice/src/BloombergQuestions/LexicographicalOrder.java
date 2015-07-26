package BloombergQuestions;

public class LexicographicalOrder {
	
	public static void lexicographicalOrder(int N, int k) {
		if (k > N) return;
		for (int i=0;i<10;i++) {
			if (k <= N) {
				System.out.print(k + " ");
				k *= 10;
				lexicographicalOrder(N, k);
				k /= 10;
				k++;
				if (k%10 == 0) return;
			}
		}
	}
	
	public static void main(String[] args) {
		lexicographicalOrder(55, 1);
	}

}
