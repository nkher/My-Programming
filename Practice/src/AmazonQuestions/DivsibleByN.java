package AmazonQuestions;

import java.util.Scanner;

public class DivsibleByN {

	//Without using modulo operator
	public boolean getDivisibileByN(int number, int N){
		int checkNumber = N;
		boolean returnValue = false;
		int count=0;
		do{
			count++;
			checkNumber += N;// Incrementing by N
			if(checkNumber == number){
				returnValue = true;
				break;
			}
			number -= N;
			if(checkNumber == number){
				returnValue = true;
				break;
			}
		}while(checkNumber <= number);
		
		System.out.println("Number of iterations : " + count);
		return returnValue;
	}
	
	//Using modulo operator
	public boolean checkDivisibilityBy5(int number){
		if (number % 5 == 0)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		DivsibleByN divbyNObj =  new DivsibleByN();
		
		System.out.println("Please enter a number.");
		int number = input.nextInt();
		
		System.out.println("Please enter a number by which you want to check divisibility");
		int N = input.nextInt();
		
		//Calling the function
		boolean returnValue = divbyNObj.getDivisibileByN(number, N);
		if(returnValue == true)
			System.out.println(number + " is divisible by " + N);
		else
			System.out.println(number + " is not divisible by " + N);
		
		//Testing another function
		/*returnValue = divbyNObj.checkDivisibilityBy5(21);
		System.out.println();
		if(returnValue == true) System.out.println("Is divisible by 5");
		else System.out.println("Is not divisible by 5");*/
	}

}
