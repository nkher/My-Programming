package Leetcode.Google;

import java.util.Set;
import java.util.HashSet;

public class HappyNumber {

	public static boolean isHappy(int n) {
        
		Set<Integer> set = new HashSet<Integer>();
        do {
            n = getSumOfSquaresOfDig(n);
            if (set.add(n) == false) return false;
        } while (n != 1);
        
        return true;
    }
    
    public static int getSumOfSquaresOfDig(int n) {
        
        if (n <= 1) return n;
        
        int sum = 0;
        while (n > 0) {
            int rem = n % 10;
            sum += (rem * rem);
            n = n / 10;
        }
        return sum;
    }
	
	public static void main(String[] args) {
		
		System.out.println(isHappy(19));
		System.out.println(isHappy(30));
	}

}
