package Sorting;

import java.util.ArrayList;

public class InsertionSort {

	//Performing an insertion sort along with a binary search
	public ArrayList<Integer> insertionSort1(ArrayList<Integer> al, int key)
	{
		int i = al.size() -1;		
		al.add(0);
		
		while (i>=0 && al.get(i) > 0)
		{
			if (key < al.get(i)) {
				al.set(i+1, al.get(i));
				al.set(i, key);
			}
			else{
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
		
		InsertionSort isobj = new InsertionSort();
		
		int array[] = {5,4,3,2,1,-8,-9,10,20,30,40,23,7};
		System.out.println("You array currently is : ");
		isobj.displayArray(array);
		
		isobj.InsertionSort2(array);
		
		isobj.displayArray(array);
	}

}
