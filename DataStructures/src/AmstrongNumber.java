import java.util.Scanner;

public class AmstrongNumber {
	
	public int CheckAmstrongNumber(int number){
		int result=0;
		int remainder;
		while(number>0){
			remainder=number%10;
			number=number/10;
			result=result+(int)Math.pow(remainder,3);
		}
		return result;
	}
	
	
	
	public static void main(String[] args) {
		
		int i = 4;
		System.out.println(i);
		
		Scanner input = new Scanner(System.in);
		AmstrongNumber an = new AmstrongNumber();
		System.out.println("Please Enter the number to be validated.");
		int number=input.nextInt();
		int result=an.CheckAmstrongNumber(number);
		if(result==number)
			System.out.println(number + " is an Amstrong Number.");
		else
			System.out.println(number + " is not an Amstrong Number.");

	}

}
