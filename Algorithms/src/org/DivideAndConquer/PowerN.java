package org.DivideAndConquer;

import java.util.Scanner;

public class PowerN {

	public int power(int x, int y){
		if(y==0)
			return 1;
		else if (y%2==0)
			return power(x,y/2)*power(x,y/2);
		else
			return x*power(x,y/2)*power(x,y/2);
	}
	
	/* Power Function with float values */
	public static float powerWithNegative(float x, float y){
		float temp;
		if(y==0)
			return 1;
		temp=powerWithNegative(x, y/2);
		if(y%2==0)
			return temp*temp;
		else{
			if (y>0)
				return x*temp*temp;
			else 
				return (temp*temp)/x;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner scan =  new Scanner(System.in);
		PowerN obj =  new PowerN();
		
		System.out.println("Please Enter a Number : ");
		int number = scan.nextInt();
		System.out.println("Please Enter the Power : ");
		int powerValue = scan.nextInt();
		float answer = obj.power(number, powerValue);
		System.out.println(answer);
		
		System.out.println(powerWithNegative(2.0f, 2.2f));
	}

}
