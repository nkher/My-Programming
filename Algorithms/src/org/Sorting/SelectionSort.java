package org.Sorting;
public class SelectionSort {
	
	public void SelectionSort(int array[])
	{	
		int n = array.length;
		int minIndex,temp;
		if (n<2)
			return;
		else
		{
			for (int i=0;i<n-2;i++)
			{
				minIndex = i;
				for (int k=minIndex+1;k<=n-1;k++)
				{
					if(array[minIndex] > array[k])
					{
						temp = array[minIndex];
						array[minIndex] = array[k];
						array[k] = temp;
					}
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
		
		int arrayUnsorted[] = {2,98,45,32,123,1,54,65,4,9,23};
		
		SelectionSort ssobj =  new SelectionSort();
		
		//Displaying unsorted array
		ssobj.displayArray(arrayUnsorted);
		
		//Calling the Sorting Function
		ssobj.SelectionSort(arrayUnsorted);
		
		//Displaying the array
		ssobj.displayArray(arrayUnsorted);
	}

}
