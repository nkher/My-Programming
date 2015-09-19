import java.io.*; 
import java.util.Scanner;

public class CheckSubStringAndRotation {

	public boolean checkSubString(String checkString, String mainString){
		
		
		int substringlength = checkString.length();
		int noOfMatches=0; 
		int k=0;
		
		//Logic
			for(int j=0;j<mainString.length();j++)
			{
				if (noOfMatches== 0)
				{
					noOfMatches = 0; 
					k = 0;
				}
				if(k<substringlength)
				{
					if(checkString.charAt(k) == mainString.charAt(j))
					{
						k = k + 1;
						noOfMatches = noOfMatches + 1;
					}
				}
			}
			
			if (noOfMatches == 0)
				return false;

			if (noOfMatches == substringlength)
			return true;
			else
			return false;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CheckSubStringAndRotation fs = new CheckSubStringAndRotation();
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("Please enter the main string");
		String mainString = input.nextLine();
		System.out.println("Please enter the check string");
		String checkString = input.nextLine();
		//boolean isSubstring = fs.checkSubString(checkString, mainString);
		
		//if (isSubstring)
		//{
		//	System.out.println("It is a substring.");
		//}
		//else 
		//{
		//	System.out.println("It is not a substring.");
		//}
		
		//To check if a string is a rotation of an other string
		mainString = mainString + mainString;
		if (fs.checkSubString(checkString, mainString))
		System.out.println("Is a rotation");
		else
		System.out.println("Not a rotation");
		
	}

}
