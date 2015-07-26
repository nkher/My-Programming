package org.Sorting;

public class MergeSort {

	public void mergeSort(int[] array)
	{
		int n = array.length;
		int mid = n/2;
		int[] left = new int[mid];
		int[] right = new int[n - mid];
		
		if (n<2)
			return;
		
			for (int i=0;i<=mid-1;i++)
			{
				left[i] = array[i];
			}
			for (int i=mid;i<=n-1;i++)
			{
				right[i-mid] = array[i];
			}
		//Recursive calls 
		mergeSort(left);
		mergeSort(right);
		
		//Calling function Merge
		merge(left,right,array);
	}
	
	public void merge(int left[], int right[], int array[])
	{
		int nLeft = left.length;
		int nRight = right.length;
		int i = 0,j = 0,k = 0;		
		while (i < nLeft && j < nRight)
		{
			//Checking if element in left is greater then do the following else execute the else part
			if (left[i] <= right[j])
			{
				array[k] = left[i];
				i++;
			}
			else
			{
				array[k] = right[j];
				j++;
			}
			k++;
		}		
		//Following conditions checks when one of the side array gets filled up
		while (i < nLeft)
		{
			array[k] = left[i];
			i++;
			k++;
		}
		while (j < nRight)
		{
			array[k] = right[j];
			j++;
			k++;
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
		
		//Creating an array
		int[] array = {2,4,1,6,8,5,3,7,89,54,23,76,1,20,34};
		
		//Displaying the array
		MergeSort msobj =  new MergeSort();
		
		//Displaying the initial array
		msobj.displayArray(array);
		
		//Calling the Merge Function
		System.out.println();		
		msobj.mergeSort(array);
		
		//Displaying the array after calling merge sort
		System.out.println("Elements after merge sort are: ");
		msobj.displayArray(array);
	}
}
