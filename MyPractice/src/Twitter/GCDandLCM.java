package Twitter;

public class GCDandLCM {
	
	/* Recursion method 1 */
	public static int gcdrec1(int a, int b) {
		if (a == 0 || b == 0) return a+b;
		return gcdrec1(b, a%b);
	}
	
	/* Recursion method 2 */
	public static int gcdrec2(int a, int b) {
		if (a == b) return a;
		if (a >= b) 
			return gcdrec2(a-b, b);
		return gcdrec2(a, b-a);
	}
	
	/* Iteration method 3 */
	public static int gcditer(int a, int b) {
		while (a != 0 && b != 0) { // until either one of them is zero
			int c = b;
			b = a%b;
			a = c;
		}
		return (a+b);
	}
	
	public static void main(String args[]) {
		System.out.println(gcdrec1(12, 30));
		
		System.out.println(gcdrec2(12, 30));
		
		System.out.println(gcditer(27, 36));
		
		System.out.println(gcdrec2(0,  0));
	}
}
