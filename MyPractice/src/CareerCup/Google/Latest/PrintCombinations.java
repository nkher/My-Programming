package CareerCup.Google.Latest;

import java.util.ArrayList;

public class PrintCombinations {
	
	// Not done
	public static void printAllStringComb(String[][] stringLists) {
		ArrayList<String> list = new ArrayList<String>();
		printAllStringCombHelper(stringLists, 0, 0, list);
	}
	
	public static void printAllStringCombHelper(String[][] stringLists, int row, int col, ArrayList<String> list) {
		
		if (row > stringLists.length-1 || col > stringLists[0].length-1) {
			return;
		}
		
		else if (row == stringLists.length-1 && col == stringLists[0].length-1) {
			System.out.println(list.toString());
			return;
		}
		
		if (row <= stringLists.length-1) {
			list.add(stringLists[row][col]);
			printAllStringCombHelper(stringLists, row+1, col, list);
			list.remove(list.size()-1);
					
			if (col <= stringLists[0].length-1) {
				list.add(stringLists[row][col]);
				printAllStringCombHelper(stringLists, row, col+1, list);
				list.remove(list.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {
		
		String[][] stringLists = { {"quick", "slow"}, 
								   {"brown", "red"}, 
								   {"fox", "dog"}};
		
		printAllStringComb(stringLists);
	}

}
