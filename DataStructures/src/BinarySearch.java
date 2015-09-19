import java.util.Scanner;


public class BinarySearch {

	public static int binarySearch(int[] array, int size, int key){
		
		int start=0;
		int end = size-1;
		while(start<=end){
			int mid = (start+end)/2;
			if(key == array[mid]) 
				return mid;
			else if(key < array[mid]) 
				end=mid-1;
			else
				start=mid+1; 
		}
		return 1;
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int[] array = {10,20,30,40,50,60,70,80,90,100};
		System.out.println("Please enter an element to Search");
		int key = scan.nextInt();
		int retuValue=BinarySearch.binarySearch(array, array.length, key);
		if(retuValue == 1){
			System.out.println("Element is not found.");
		}
		else
			System.out.println(key + " is present in the array at position " + retuValue + ".");
	}

}
