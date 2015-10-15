package Sorting;
import java.util.*;

public class BubbleSort {
	
	public void bubbleSort(int[] array)
	{
		//We can improve this algorithm in two ways
		// 1. For the first instance only the second loop has to run till n-2 ... for the 
		// second it has to be run till n-3 and for the third till n-4 and so on ... so we 
		// can generalize second loop till n-k-1 (This is because the right part always gets
		// sorted after each iteration)
		// 2. Keep a flag to check whether the array is sorted at any point of time
		
		int n = array.length;
		int temp;
		for (int k=1;k<=n-1;k++)
		{
			for (int i=0;i<=n-k-1;i++)
			{
				if (array[i] > array[i+1])
				{
					temp = array[i+1];
					array[i+1] = array[i];
					array[i] = temp;
					//flag = 1;
				}
			}
		}
	}

	public void displayArray(int[] array)
	{
		System.out.println("Elements of Array are: ");
		for (int i=0;i<array.length;i++)
		{
			System.out.println(i + "th " + "Element :" + array[i]);
		}
	}
	
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the size of the array.");
		int size = input.nextInt();
		
		int[] array =  new int[size];
		
		int counter = 0;
		
		System.out.println("Please start entering elements in the array!" + "Mind you .. array size is only " + size);
		while (counter < array.length)
		{
			System.out.println("Enter Element");
			int element = input.nextInt();
			array[counter] = element;
			counter++;
			System.out.println("Press '0' if you wanna stop entering elements. Else Press '1' to enter any other element");
			int choice = input.nextInt();
			if (choice == 0)
			{
				break;
			}
			else if (choice == 1)
				continue;
		}
		
		BubbleSort bsobj =  new BubbleSort();		
		bsobj.displayArray(array);			
		bsobj.bubbleSort(array);		
		System.out.println("Your sorted array."); 
		bsobj.displayArray(array);	
				
	}

}
