package Leetcode.Google;

import java.util.ArrayList;
import java.util.List;

public class AddDigits {
	
	public static int addDigits(int num) {
		
		if (num == 0) return 0;
		
		double div = 9.0;
		double n = (double)(num);
		
		return (int) (n - ( (Math.ceil(n/div) - 1.0) * 9 ));
	}
	
	public static int addDigits2(int num) {
		if (num == 0) return 0;
		
		return (num-1) % 9 + 1;
	}
	
	public static void main(String[] args) {
		
		System.out.println(addDigits(38));
		
		System.out.println(addDigits(12345));
		
		System.out.println(addDigits(0));
		
		System.out.println(addDigits2(27));
		
		List<Integer> list = new ArrayList<Integer>(1);
		
	}

}
