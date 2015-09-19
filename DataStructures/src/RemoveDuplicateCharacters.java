import java.util.Scanner;


public class RemoveDuplicateCharacters {

	public char[] removeDuplicateCharacters(String s1){
		
		char[] strings1;
		strings1 = s1.toCharArray();
		int count = 0;
		
		//Tail is to mark the index of the next unique character
		int tail = 1;
		
		if (strings1 == null)
		{
			return strings1;
		}
		
		if (strings1.length < 2)
		{
			return strings1;
		}
		
		//First character will never be duplicate therefore we start from the second character and hence i = 1
		for (int i=1;i<strings1.length;i++)
		{
			//This will check character at index i is present in my unique string
			int j;
			for (j=0;j<tail;j++)
			{
				if(strings1[i] == strings1[j])
				{
					count = count + 1;
					break;
				}
			}
			
			//Now adding it to my unique string
			if(j == tail)
			{
				strings1[tail] = strings1[i];
				++tail;
			}
		 
		}
		
		// at this point the characters from index [0,tail) are unique
        // if there were any duplicates they are between [tail,input.length)
        // so truncate the length of input to tail.
		
		//Using string functions to trim to a particular position 
		String a = new String(strings1);
		a = a.substring(0,tail);
		strings1 = a.toCharArray();
		System.out.println("Count is: " + count);
		return strings1;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		RemoveDuplicateCharacters rdc = new RemoveDuplicateCharacters();
		
		System.out.println("Please enter a String:");
		System.out.println();
		String s1 = input.nextLine();
		
		char[] resultString = rdc.removeDuplicateCharacters(s1);
		
		System.out.println("The resultant string is");
		System.out.println();
		
		for (int i=0;i<resultString.length;i++)
		{
			System.out.print(resultString[i]);
		}
	}

}
