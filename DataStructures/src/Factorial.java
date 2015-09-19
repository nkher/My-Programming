import java.util.Scanner;

public class Factorial {
	
	public int GenerateFactorial(int number){
		int result=number;
		while(number>1){// We will use greater than 1 condition so that it does not go inside the loop when it is 0
			number--;
			result=result*(number);
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Factorial f = new Factorial();
		System.out.println("Please Enter the number for which you want the factorial.");
		int number=input.nextInt();
		int result=f.GenerateFactorial(number);
		System.out.println(number+"! is : "+result);
	}

}
