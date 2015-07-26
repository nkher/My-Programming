package BloombergQuestions;

public class NumberDig {

	// Program to determine whether the first and the last digits 
	// of a given number are same. Like 767, 37743
	public static void main(String[] args) {
		int i = 377422343, lastDig, firDig = 0;
		lastDig = i%10;
		i = i/10;
		System.out.println("last dig is " + lastDig);
		while (i > 0) {
			firDig = i%10;
			i=i/10;
		}
		System.out.println("first dig is " + firDig);
		if(firDig == lastDig) {
			System.out.println("first and last are same");
		}
		else {
			System.out.println("Not same !");
		}
	}
}
