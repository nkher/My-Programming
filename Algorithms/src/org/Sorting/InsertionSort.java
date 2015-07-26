package org.Sorting;
import java.util.ArrayList;
import java.util.Scanner;


public class InsertionSort {

	//Performing an insertion sort along with a binary search
	public ArrayList<Integer> insertionSort1(ArrayList<Integer> al, int key)
	{
		int i = al.size() -1;
		
		//To increase the size of the arrayList
		al.add(0);
		
		while (i>=0 && al.get(i) > 0)
		{
			if (key < al.get(i))
			{
				al.set(i+1, al.get(i));
				al.set(i, key);
			}
			else
			{
				al.set(i+1, key);
				break;
			}
			i--;
		}
		return al;
	}
	
	//Simple Insertion sort
	public void InsertionSort2(int[] array){
		
		int temp;
		int j;
		for (int i=1; i<array.length;i++)
		{
			j = i;
			while (j != 0){
				if(array[j] < array[j-1]){
					//Swap
					temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
					j--;
				}
				else 
					break;
				}
			}
		}
	
	public void swap(int value1, int value2){
		int temp = value1;
		value1 = value2;
		value2 = temp;
	}
	
	//To display th array
	public void displayArray(int[] array)
	{
		System.out.println("Elements of Array are: ");
		for (int i=0;i<array.length;i++)
		{
			System.out.println(i + "th " + "Element :" + array[i]);
		}
	}
	
	public static void main(String[] args) {
		
		String choice;
		Scanner input = new Scanner(System.in);
		InsertionSort isobj = new InsertionSort();
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		/*
		boolean flag = true;
		System.out.println("Please Start Entering elements in the Array List in a sorted manner");
		
		while(flag)
		{
			System.out.println("Enter Element");
			int element = input.nextInt();
			al.add(element);
			
			System.out.println("Do you want to add a another element ?");
			System.out.println("Enter Y/N");
			choice = input.next();
			if (choice.equalsIgnoreCase("Y"))
				flag = true;
			if(choice.equalsIgnoreCase("N"))
				break;
		}
		
		while(flag)
		{
			ArrayList<Integer> result = new ArrayList<Integer>();
			System.out.println("Size is: " + al.size());
			//Taking a key
			System.out.println("Please Enter the key in the array !");
			int key = input.nextInt();
			
			//Running insertion sort
			result = isobj.insertionSort1(al, key);
			System.out.println("Size is: " + result.size());
			
			//Showing sorted array 
			System.out.println("Your sorted Array is:");
			for (int i=0;i<result.size();i++)
			{
				System.out.println("Element" + i + ":" + result.get(i));
			}
			
			
			//Asking user if he/she wants to add another element
			System.out.println("Do you want to add a another element to the Array for Insertion Sort ?");
			System.out.println("Enter Y/N");
			choice = input.next();
			if (choice.equalsIgnoreCase("Y"))
				flag = true;
			if(choice.equalsIgnoreCase("N"))
				break;
		}
		*/
		
		int array[] = {5,4,3,2,1,-8,-9,10,20,30,40,23,7};
		System.out.println("You array currently is : ");
		isobj.displayArray(array);
		
		isobj.InsertionSort2(array);
		
		isobj.displayArray(array);
	}

}
