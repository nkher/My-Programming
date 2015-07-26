package BloombergQuestions;

public class FirstUniqueChar {
	
	public static char getFirstUniqueChar(char[] c) {
		
		int i[] =  new int[256];
		for (int j=0;j<c.length;j++) {
			i[c[j]]++;
		}
		for (int j=0;j<c.length;j++) {
			if(i[c[j]] == 1)
				return c[j];
		}
		return ' ';
	}
	
	public static void main(String[] args) {
		
		char c[] = {'a','b','b','a','a','d','e','d','f','i','f','r','i'};
		char tmp = getFirstUniqueChar(c);
		System.out.println(tmp);
		
		String s = new String(c);
		System.out.println(s);
	}
}
