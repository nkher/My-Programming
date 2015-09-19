import java.io.*;
import java.lang.reflect.Array;
import java.util.Scanner;

public class ReplaceByPercent20 {

	public char[] replaceWhiteSpaces(char[] returnString, int length){
		
		int newLength = 0, spaceCount = 0;
		
		//To count the number of white spaces.
		for (int i = 0; i<length; i++)
		{
			if (returnString[i] == ' ')
				spaceCount = spaceCount + 1;
		}
		
		if (spaceCount == 0)
		{
			System.out.println("There are no white spaces.");
			return returnString;
		}
		
		//Counting the newLength and giving the size of the new Array
		newLength = length + (spaceCount * 2) + 1;
		System.out.println(newLength);
		
		//Initializing the last space to null
		returnString[newLength] = '\0';
		
		
		for (int j=length;j>0; j--)
		{
			if (returnString[j] == ' '){
				
				returnString[newLength - 1] = '0';
				returnString[newLength - 2] = '2';
				returnString[newLength - 3] = '%';
				newLength = newLength - 3;
			}
			else 
			{
				returnString[newLength - 1] = returnString[j];
				newLength = newLength - 1;
			}
		}
		
		return returnString;
		
	}
	
	//Method using string function
	public String replaceUsingStringFunction(String s){
		
		s = s.replaceAll(" ", "%20");
		return s;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReplaceByPercent20 obj = new ReplaceByPercent20();
		Scanner input = new Scanner(System.in);
		
		//System.out.println("");
		char[] result = {'t', 'h', 'e',' ', 'd', 'o', 'g', ' ', ' ', ' ', ' ', ' ', ' '};
		int length = 6;
		System.out.println(result.length);
		
		result = obj.replaceWhiteSpaces(result, length);
		
		System.out.println("Your resultant string is:");
		for (int i = 0;i<result.length;i++){
			System.out.print(result[i]);
		}
		
		System.out.println();
		System.out.println("Please enter a string");
		String s1 = input.nextLine();
		
		System.out.println("Your resultant string is:" + obj.replaceUsingStringFunction(s1));
		
	}

}
