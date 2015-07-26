package GoogleJavaPuzzles;

import java.util.regex.Pattern;

public class Match {

	public static void main(String[] args) {
		
		//Pattern p = Pattern.compile("(aa|aab?)+");
		Pattern p = Pattern.compile("(aab?)+");
		int count=0;
		for(String s="";s.length()<200; s+="a")
			if(p.matcher(s).matches())
				count++;
		System.out.println(count);
		//Output : Runs for 10^15 years before printing anything !!!
		
		//Because of Catastrophic backtracking
		
	}

}
