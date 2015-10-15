package Sorting;


public class SimpleInsertionSort {

	public int[] simpleInsertionSort(int[] array)
	{
		int temp, i = 0;
		int key = 1;
		
		for (i = 0; i < array.length-1; i++) {			
			for (int j=key;j>0;j--) {
				//Comparing and Swapping
				if (array[j] < array[j-1]) {
						temp = array[j];
						array[j] = array[j-1];
						array[j-1] = temp;
					}
			}
			key = key + 1;
		}
		return array;
	}
	
	public void displayArray(int[] array)
	{
		for (int i=0;i<array.length;i++) {
			System.out.println("Element " + i + " :" + array[i]);
		}
	}
			
	public static void main(String[] args) {
		SimpleInsertionSort obj =  new SimpleInsertionSort();		
		int[] array = {5,2,4,6,1,3};
		System.out.println("--You initial array is as follows -- ");
		obj.displayArray(array);		
		System.out.println("--You sorted array is as follows -- ");
		array = obj.simpleInsertionSort(array);
		obj.displayArray(array);
	}

}
