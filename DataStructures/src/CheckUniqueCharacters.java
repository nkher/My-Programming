import java.util.Scanner;


public class CheckUniqueCharacters {

	public int checkUniqueCharacters(String s){
		
		int k=0;
		char[] checkString = s.toCharArray();
		
		//Checking if there is an empty string
		if(checkString.length == 0){
			return 1;
		}
		
		for (int i = 0;i<=checkString.length-1;i++)
		{
			if(k != i && k <= checkString.length-1)
			{
				if (checkString[k] == checkString[i])
					return -1;
				if(i == checkString.length - 1)
				{
					k = k + 1;
					i = 0;
					continue;
				}
			}
		}
		
		return 0;
		
	}
	public static void main(String[] args) {
		// TODO Auto
		CheckUniqueCharacters obj = new CheckUniqueCharacters();
		
		System.out.println("Please Enter a string");
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		
		int returValue = obj.checkUniqueCharacters(s);
		
		if (returValue == 1){
			System.out.println("The given string is Empty !");
		}
		else if (returValue == -1){
			System.out.println("The string is not Unique");
		}
		else if (returValue == 0){
			System.out.println("The string is unique");
		}
		
	}

}
