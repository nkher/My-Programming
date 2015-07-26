package com.CTCI.Chapter1;

// Program to reverse a C-Style String

public class Questions1_2 {
	
	public static void reverseCStyleString(char[] target) {
		int head = 0;
		int tail = target.length - 2;
		while (head < tail) {
			char temp = target[head];
			target[head] = target[tail];
			target[tail] = temp;
			head++;
			tail--;
		}
	}
	
	public static void main(String[] args) {
		
		// C-Style string in Java
		char c_String[] = {'1','2','3','4','5','\0'};
		System.out.println(c_String);
		reverseCStyleString(c_String);
		System.out.println(c_String);
	}

}
