package bitManipulation;

public class LeftShift {
	public static void main(String[] args) {
		int max = ~0, n = 1024, m = 21, i = 2, j = 6;
		
		int left_shift = (1 << j);
		System.out.println(left_shift-1);
		System.out.println(Integer.toBinaryString(max));
		System.out.println(Integer.toBinaryString(left_shift-1));
		System.out.println(Integer.toBinaryString(-64));
		int left = max - (left_shift-1);
		System.out.println("left : " + Integer.toBinaryString(left));
		
		int right_shift = (1 << i); // 4
		int right = right_shift - 1;
		System.out.println(right);
		
		System.out.println("calculating mask");
		int mask = left | right;
		System.out.println("left " + Integer.toBinaryString(left));
		System.out.println("right " + Integer.toBinaryString(right));
		System.out.println("mask " + Integer.toBinaryString(mask));
		
		System.out.println();
		System.out.println(Integer.toBinaryString(m));
		System.out.println(Integer.toBinaryString(i));

	}
}
