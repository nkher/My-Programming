package BloombergQuestions;

import java.util.Scanner;

public class ReverseInteger {
	
	public static int reverseInteger(int n) {
		int rev_num=0;
		while(n > 9) {
			int rem = n%10;
			rev_num = (rev_num+rem) * 10;
			n = n/10;
		}
		rev_num = rev_num + n;
		return rev_num;
	}
	
	public static void main(String[] args) {
		
		Scanner scan =  new Scanner(System.in);
		System.out.println("Please enter a positive integer");
		int integer = scan.nextInt();
		int n = reverseInteger(integer);
		System.out.println(n);
	}

}
