import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CheckAnagram {

	//Anagram function using one for loop
	public boolean checkAnagram(char[] Phrase1, char[] Phrase2){
		
		int lp1 = Phrase1.length, lp2 = Phrase2.length;
		int k = 0, flag = 0;
		
		if(lp1 != lp2)
		{
			System.out.println("The Strings you entered do not have same number of characters !");
			return false;
		}
		else
		{
			for (int j=0;j<lp1;j++)
			{
				if(Phrase1[k] == Phrase2[j])
				{
					flag = flag + 1;
					k = k + 1;
					j = 0;
					continue;
				}
				else 
				{
					continue;
				}
			}
			
			System.out.println(lp1);
			System.out.println(flag);
			if(flag == lp1)
			return true;
			else 
			return false;
		}
	}
		
		
		//Anagram function using two for loops
		public boolean checkAnagramTwo(char[] Phrase1, ArrayList<Character> Phrase2AL){
		
			int lp1 = Phrase1.length;
			
			if(lp1 != Phrase2AL.size())
			{
				System.out.println("The Strings you entered do not have same number of characters !");
				return false;
			}
			else
			{
				boolean isFound = true;
				for (int i = 0;i<lp1;i++)
				{
					for (int j = 0;j<Phrase2AL.size();j++)
					{
						if (Phrase1[i] == Phrase2AL.get(j))
						{
							System.out.println("There is a common element.");
							//isFound = ;
							Phrase2AL.remove(j);
						}
						//else 
						//{
						//	isFound = false;
						//	break;
						//}
					}
					if(isFound == false)
					{
						System.out.print("Is not an Anagram !");
						return false;
					}
				}
				return true;
				}
					
			}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		//To check if the given strings are anagrams
		char[] Phrase1, Phrase2;
		
		System.out.println("Please Enter the first String:");
		String s1 = input.nextLine();
		System.out.println("Please Enter the Second String:");
		String s2 = input.nextLine();
		
		Phrase1 = s1.toCharArray();
		/*Phrase2 = s2.toCharArray();
		
		*/
		//Calling the Anagram Function
		CheckAnagram cA = new CheckAnagram();
		/*
		if(cA.checkAnagram(Phrase1, Phrase2))
			System.out.println(s1 + " is an Anagram of " + s2);
		else
			System.out.println(s1 + " is not an Anagram of " + s2);
		*/
		//Using an array list to make anagram function
		ArrayList<Character> Phrase2AL = new ArrayList<Character>();
		for (char c : s2.toCharArray()){
			Phrase2AL.add(c);
		}
		
		boolean  isAnagram = cA.checkAnagramTwo(Phrase1, Phrase2AL);
		if(isAnagram)
		System.out.println(s1 + " is an Anagram of " + s2);
	    else
		System.out.println(s1 + " is not an Anagram of " + s2);
	}

}
