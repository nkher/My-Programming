package org.Sorting;

import java.util.Arrays;

public class QuickSort {

	//Creating Partition Function
	public int Partition(int[] array, int start, int end)
	{
		int temp;
		int pivot = array[end];
		int pIndex = start;
		
		for (int i=start;i<=end-1;i++)
		{
			if (array[i] <= pivot) {
				temp = array[i];
				array[i] = array[pIndex];
				array[pIndex] = temp;
				pIndex++;
			}
		}
		
		//Swapping the pivot with the partitioned index
		temp = pivot;
		array[end] = array[pIndex];
		array[pIndex] = temp;
		
		return pIndex;
	}
	
	public void Quicksort(int array[], int start, int end)
	{
		if (start < end)
		{
			int pIndex=Partition(array, start, end);
			System.out.println("partition index is : " + pIndex);
			Quicksort(array,start,pIndex-1);
			Quicksort(array,pIndex+1,end);
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
		
		int array[] = {7,2,1,6,8,5,3,4,40,5};
		int start = 0; 
		int end = array.length-1;
		
		//Creating an object
		QuickSort qsobj =  new QuickSort();
		
		//Displaying the initial array
		//qsobj.displayArray(array);
		System.out.println(Arrays.toString(array));
		
		//Calling the QuickSort function
		qsobj.Quicksort(array, 0, array.length-1);
		
		//Displaying the partitioned array
		//qsobj.displayArray(array);
		System.out.println(Arrays.toString(array));
				
	}

}
