package AmazonQuestions;

import java.util.Scanner;

public class ClosestFibNo {
	
	public int getClosestFibNumber(int number){
		
		int next, prev, sum=0;// Initializing the sum to zero
		next = prev = 1; // Initializing next and previous to 1
		while(sum <= number){
			
			if(sum == number) // Check if we have got the number
				return 1;
			
			// Setting the next iteration values
			sum=next+prev; 
			prev=next;
			next=sum;      
		}
		
		// Logic to check whether the higher bound is closer to the number
		// or the lower bound is closer
		if((next - number) < (number  - prev)) 
			return next;
		else if((next - number) > (number  - prev)) 
			return prev;
		else
			return 0;
	}
	
	public static void main(String args[]){
		
		ClosestFibNo cfnObj = new ClosestFibNo();
		Scanner input = new Scanner(System.in);
		
		System.out.println(" Please Enter the number\n to which you want to\n find the Closest\n fibonaaci number.");
		int number = input.nextInt();
		int retValue = cfnObj.getClosestFibNumber(number);
		
		if(retValue == 1)
			System.out.println(" Number itself is a \n fibonacci number");
		else 
			System.out.println("Closest Number is " + retValue);
			
	}
	
}
