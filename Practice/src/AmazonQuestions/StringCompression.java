package AmazonQuestions;

public class StringCompression {
	
	public static String compressString(String s1, int length) {
		if(s1 == null) return null;
		if(length == 1) return s1;
		if(length == 2) {
			if(s1.charAt(0) == s1.charAt(1))
				return new String(s1.charAt(0)+"2");
			else 
				return s1;
		}
		for(int i=0;i<length;i++) {
			int c=i+1;
			// In the while loop below you have to use s1.length() for the length as the 
			// string is changing each loop
			while((c < s1.length()) && (s1.charAt(c) == s1.charAt(i))) { // Incrementing c until it is finding repeating characters
				c++;
			}
			if(c-i > 1) { //  Ensuring that the repeated count is greater than two only then compress
				s1 = s1.substring(0,i+1) + (c-i) + s1.substring(c); 
				i++; // increment the 'i' counter to the next position to start from the next character
			}
		}
		return s1;
	}
	
	public static void main(String[] args) {
		String s1 = "aaabbbccccccceeeeeeeeegg";
		String answer = StringCompression.compressString(s1, s1.length());
		System.out.println(answer);
	}

}
