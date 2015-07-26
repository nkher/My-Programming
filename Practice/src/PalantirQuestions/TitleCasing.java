package PalantirQuestions;

public class TitleCasing {
	
	public static String toTitleCase(String s) {
		StringBuilder titleCase = new StringBuilder();
		boolean next = true; // Set it true for first character
		
		for (char c : s.toCharArray()) {
			if (Character.isSpaceChar(c))
				next = true;
			else if (next) {
				c = Character.toTitleCase(c);
				next = false;
			}
			titleCase.append(c);
		}
		return new String(titleCase);
	}
	
	public static String toTitleCase2(String s) {
		StringBuilder titleCase = new StringBuilder();
		boolean next = true;
		
		for (char c : s.toCharArray()) {
			if (c == ' ') {
				next = true;
			}
			else if (next) {
				if (c >= 97 && c <= 122)
					c = (char)(c - 32);
				next = false;
			}
			titleCase.append(c);
		}
		return new String(titleCase);
	}
	
	public static void main(String[] args) {
		String s = "namesh is a masters graduate student";
		System.out.println(toTitleCase(s));
		
		System.out.println(toTitleCase2(s));
		
		
		System.out.println((int)'a' + " " + (int)'A');
		System.out.println((int)'z' + " " + (int)'Z');
	}

}
