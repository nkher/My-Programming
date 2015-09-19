import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

import javax.swing.text.html.MinimalHTMLWriter;


public class Practice {

	public int hashCode(char a[]) {
		   int hash = 0;
		   for (int i = 0; i < a.length; i++)
		      hash = (hash * 31) + a[i];
		   return hash;
	}
	
	public static void main(String[] args) {
		
		String s = "polygenelubricants";
		//System.out.println("namesh".hashCode());
		//System.out.println(s.hashCode()); 
		//System.out.println(Math.abs(-2147483648));
		//System.out.println(Math.abs(-1052831200));
		//System.out.println(Integer.MAX_VALUE + " " + Integer.MIN_VALUE);
		
		System.out.println(s.hashCode());
		String s1 = "polygenelubricants";
		System.out.println(s1.hashCode());
		
	}
}
