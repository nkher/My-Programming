package com.CTCI.Chapter1;

// Replace white spaces in a string with '%20'
public class Question1_5 {
	
	// Assuming that the string has free spaces at the end
	public static void replaceSpaces(char str[], int length) {
		int spaceCount = 0, index, i=0;
		for (i=0;i<str.length;i++) {
			if (str[i] == ' ')
				spaceCount++;
		}
		index = length + spaceCount*2;
		str[index] = '\0';
		for (i=length-1;i>=0;i--) {
			if (str[i] == ' ') {
				str[index-1] = '0';
				str[index-2] = '2';
				str[index-3] = '%';
				index = index -3;
			}
			else {
				str[index-1] = str[i];
				index--;
			}
		}
	}
	
	public static void main(String[] args) {
		String str = "abc d e f";
		char c[] = new char[str.length() + 3 * 2 +1];
		for (int i=0;i<str.length();i++) {
			c[i] = str.charAt(i);
		}
		replaceSpaces(c, str.length());
		System.out.println(c);
	}

}
