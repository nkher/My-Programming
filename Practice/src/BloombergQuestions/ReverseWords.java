package BloombergQuestions;

public class ReverseWords {
	
	// Time complexity is O(n) as we spend O(1) per char
	public static char[] reverseWords(char a[]) {
		reverseArray(a, 0, a.length-1); // Array 'a' has been reversed
		// Now reversing each of the word
		int start = 0;
		for(int i=0;i<a.length;i++) {
			if(a[i] == ' ') {
				reverseArray(a, start, i-1);
				start = i+1;
			}
			if(i == a.length-1 && a[i] != ' ')
				reverseArray(a, start, i);
		}
		return a;
	}
	
	public static void reverseArray(char c[], int startIndex, int endIndex) {
		char tmp;
		while(startIndex < endIndex) {
			tmp = c[startIndex];
			c[startIndex] = c[endIndex];
			c[endIndex] = tmp;
			startIndex++;
			endIndex--;
		}
	}
	
	public static void main(String[] args) {
		String s = "My name is"; // Namesh is name My "si eman yM"
		char c[] = s.toCharArray();
		c = reverseWords(c);
		System.out.println(c);
	}

}
