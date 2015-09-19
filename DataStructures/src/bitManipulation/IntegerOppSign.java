package bitManipulation;

import java.util.Scanner;

public class IntegerOppSign {
	
	public static boolean isOpposite(int a, int b) {
		return (a ^ b) < 0;
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a number");
		int x = input.nextInt();
		System.out.println("Please enter another number");
		int y = input.nextInt();
		
		// comparing the signgs by the above method
		if(IntegerOppSign.isOpposite(x, y)) 
			System.out.println("Numbers have different signs");
		else
			System.out.println("Numbers do not have different signs");
		
		System.out.println(Integer.toHexString(1));
		System.out.println(Integer.toBinaryString(1));
	}

}
