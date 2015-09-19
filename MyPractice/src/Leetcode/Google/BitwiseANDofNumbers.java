package Leetcode.Google;

public class BitwiseANDofNumbers {
	
	public static int rangeBitwiseAndSimple(int m, int n) {
        
        int result = m;
        for (int i=m; i<=n; i++) {
            result = (result & i);
        }
        return result;
    }
	
	public static int rangeBitwiseAnd(int m, int n) {
		while (n > m) {
			n = n & n-1;
		}
		return m & n;
	}
	
	public static void main(String[] args) {
		
		System.out.println(rangeBitwiseAnd(0, Integer.MAX_VALUE));		
	}

}
