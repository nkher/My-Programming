package AmazonQuestions;

public class MinimumSubstring {
	
	public final static int MAX_CHARS = 256;
	
	public static StringBuffer minimumSubstring(String ipString1, String ipString2) { 
		StringBuffer sbuffer = new StringBuffer();
		int minLen = 0, i, len2 = ipString2.length(), len1 = ipString1.length();
		int count[] = new int[MAX_CHARS];
		StringBuffer retStr = null;
		
		count = getCountArray(ipString2, count); 
		
		for(i=0;i<ipString1.length();i++) {
			if(len2 == 0)
				break;
			else if(len2 == ipString2.length()) {
				if(count[ipString1.charAt(i)] > 0) {
					sbuffer.append(ipString1.charAt(i));
					count[ipString1.charAt(i)]--;
					len2--;
				}
			}
			else if(len2 < ipString2.length()) {
				sbuffer.append(ipString1.charAt(i));
				if(count[ipString1.charAt(i)] > 0) {
					count[ipString1.charAt(i)]--;
					len2--;
				}
			}
		}
		minLen = i;
		i++;
		retStr = sbuffer;
		System.out.println("first : " + sbuffer);
		while(i < len1) {
			System.out.println(retStr);
			sbuffer.append(ipString1.charAt(i));
			if(ipString1.charAt(i) == sbuffer.charAt(0)) {
				sbuffer = removeTrailingChars(sbuffer, getCountArray(ipString2, count), ipString2.length(), ipString2); // call the function
				minLen = (minLen < sbuffer.length()) ? minLen : sbuffer.length(); // determining the minimum length
				if(retStr.length() > sbuffer.length()) {
					retStr = sbuffer;
				}
			}
			i++;
		}
		return retStr;
	}
	
	public static StringBuffer removeTrailingChars(StringBuffer sbuffer, int count[], int len, String ipString2) {
		sbuffer.delete(0, 1);
		int i;
		for(i=sbuffer.length()-1;i>0;i--) {
			if(len == 0) {
				sbuffer.delete(0, i+1);
				break;
			}
			if(count[sbuffer.charAt(i)] > 0) {
				count[sbuffer.charAt(i)]--;
				len--;
			}
		}
		return sbuffer;
	}
	
	public static int[] getCountArray(String string, int[] count) {
		for(int i=0;i<string.length();i++) { 
			count[string.charAt(i)]++; //increasing the count at the index of the character 
		}
		return count;
	}
	
	public static void getInitialSubstring() {
		
	}
	
	public static void main(String[] args) {
		String ipString1 = "this is a test string";
		String ipString2 = "tist";
		StringBuffer sb = MinimumSubstring.minimumSubstring(ipString1, ipString2);	
		System.out.println("minimum substring is : " + sb);
	}
}
