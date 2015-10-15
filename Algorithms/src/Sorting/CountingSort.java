package Sorting;

import java.util.Scanner;

public class CountingSort {

	private static final int MAX_RANGE = 100000;
	
	public static void sort(int[] array){
		int N = array.length;
		if(N == 0)
			return;
		
		//Find max and min values
		int max=array[0], min=array[0];
		
		for(int i=1;i<N;i++){
			if(array[i]>max)
				max=array[i];
			if(array[i]<min)
				min=array[i];
		}
		
		int range=max-min+1;
		
		//Check if range is greater than MAX_RANGE
		if(range>MAX_RANGE){
			System.out.println("Range is too large for sort");
			return;
		}
		
		//Creating a new array of the size of range
		int[] count  =  new int[range];
		
		/* Count Occurences */
		//Make count/freq array for each element
		for(int i=0;i<N;i++)
			count[array[i]-min]++;
		
		for(int k=0;k<range;k++){
			System.out.print(count[k] + " ");
		}
		
		System.out.println("-----------------------------------------------------------------");
		
		//Modify count so that positions in the final array is obtained
		for(int i=1;i<range;i++)
			count[i] += count[i-1];
		
		System.out.println("-----------------------------------------------------------------");
		System.out.println();
		for(int k=0;k<range;k++){
			System.out.print(count[k] + " ");
		}
		System.out.println();
		System.out.println("-----------------------------------------------------------------");
		/* Generate Result */
		//Modify original array
		int j=0;
		for(int i=0;i<range;i++)
			while(j<count[i])
				array[j++] = i+min;
	}
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Implementing Counting Sort");
		
		int n, i;
		System.out.println("Enter the no of elements");
		n = scan.nextInt();
		
		int[] array =  new int[n];
		
		System.out.println("Enter " + n + " elements into the array");
		for(i=0;i<n;i++)
			array[i] = scan.nextInt();
		
		sort(array);
		
		System.out.println("Printing the sorted array");
		for(int k=0;k<n;k++){
			System.out.println(array[k] + " ");
		}

	}

}
