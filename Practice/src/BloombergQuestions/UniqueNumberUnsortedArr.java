package BloombergQuestions;

public class UniqueNumberUnsortedArr {

	public static void main(String[] args) {
		int a[] = {30,20,23,30,23};
		int result = a[0];
		for (int i=1;i<a.length;i++) {
			result = result ^ a[i]; 
		}
		System.out.println(result);
	}

}
