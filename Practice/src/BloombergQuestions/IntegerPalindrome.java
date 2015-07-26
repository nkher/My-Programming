package BloombergQuestions;

public class IntegerPalindrome {

	public static void main(String[] args) {
		
		int i = 1234321, i_copy = i;
		int rev_num = 0;
		while (i_copy > 9) {
			int rem = i_copy%10;
			rev_num = (rev_num*10) + rem;
			i_copy = i_copy/10;
		}
		
		rev_num = (rev_num*10) + i_copy;
		System.out.println(rev_num);
		if(rev_num == i) {
			System.out.println("Is a palindrome !");
		}
		else {
			System.out.println("Is not a palindrome");
		}
	}

}
