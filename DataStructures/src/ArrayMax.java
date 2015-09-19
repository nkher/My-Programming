import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;


public class ArrayMax {

	public int findMaxArray1D(ArrayList<Integer> array, int returnMax)
	{
		returnMax = array.get(0);
		int l = array.size();
		for (int i=1; i<l; i++)
		{
			if (returnMax <= array.get(i))
			{
				returnMax = array.get(i);
			}
		}
		return returnMax;
	}
	public static void main(String[] args) {
		
		String choice;
		Scanner input = new Scanner(System.in);
		ArrayMax peekobj = new ArrayMax();
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		boolean flag = true;
		
		System.out.println("Please Start Entering elements in the Array List");
		
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
		
			
		//System.out.println(al.size());
		//for (int j = 0; j<al.size();j++)
		//{
		//	System.out.println(al.get(j));	
		//}
		//Calling the function
		int getMax = 0;
		getMax = peekobj.findMaxArray1D(al, getMax);
		System.out.println("The largest element is :" + getMax);
				
	}

}
