package AmazonQuestions;

import java.util.Scanner;

public class RangeMinimum {

	public void getMinimumInRange(int positionA, int positionB, int array[]){
		
		positionA = positionA-1;
		positionB = positionB-1;
		
		int minValue=Integer.MAX_VALUE;
		
		for(int i=positionA; i<=positionB ;i++){
			if(minValue > array[i])
				minValue = array[i];
		}
		System.out.println("Minimum Value in range " + (positionA+1) + " and " + (positionB+1) + " : " + minValue);
	}
	
	public void displayArray(int[] array){
		for(int i=0;i<array.length;i++)
			System.out.println(array[i]);
	}
	
	public static void main(String[] args) {
		
		RangeMinimum rangeMinimum =  new RangeMinimum();
		Scanner scanner =  new Scanner(System.in);
		int array[] = {4,5,3,1,77,33,23,999,12,34};
		int positionA, positionB;
		
		System.out.println("Yout Array is : ");
		rangeMinimum.displayArray(array);
		
		System.out.println("Please enter the first element.");
		positionA = scanner.nextInt();
		System.out.println("Please enter the second element.");
		positionB = scanner.nextInt();
		
		rangeMinimum.getMinimumInRange(positionA, positionB, array);
	}

}
