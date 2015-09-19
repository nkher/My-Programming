package Bloomberg;

public class ReverseString {
	
	public static String reverseString(String s) {
		int n = s.length();
		char[] string_array = s.toCharArray();
		int start = 0, end = n-1;
		while (start <= end) {
			char temp = string_array[start];
			string_array[start] = string_array[end];
			string_array[end] = temp;
			start++; end--;
		}
		return new String(string_array);
	}
	
	public static void main(String args[]) {
		
		System.out.println(reverseString("namesh"));
		
		System.out.println(0x5DEECE66DL); // multipler
		
		System.out.println(0xBL); // addend
		
		System.out.println((1L << 48) - 1); // mask
		
		System.out.println(0xACE1);
	}
}
