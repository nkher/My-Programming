import java.util.ArrayList;
import java.util.Scanner;


public class FibRec {
	
	
	public int fibRec(int range) {
		if (range == 0)
			return 0;
		else if (range == 1)
			return 1;
		else
			return fibRec(range - 1) + fibRec(range - 2);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		FibRec fs = new FibRec();
		System.out.println("Please Enter the range.");
//		int range=input.nextInt();
//		for (int i=0; i<range; i++) {
//			System.out.println(fs.fibRec(i));
//		}
		
		final ArrayList al = new ArrayList();
		al.add("Hello");
		al.add("Hi");
		al.add("Namesh");
		for (int i=0;i<al.size();i++)
			System.out.println(al.get(i));
	}

}
