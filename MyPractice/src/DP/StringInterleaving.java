package DP;

public class StringInterleaving {

	public boolean isInterleaved(char str1[], char str2[], char str3[]) {
		
		int l1 = str1.length, l2 = str2.length, l3 = str3.length;
		boolean T[][] = new boolean[l1+1][l2+1];
		
		// error check
		if (l3 != l1+l2) return false;
		
		for (int i=0;i<T.length;i++) {
			for (int j=0;j<T[i].length;j++) {
				
				int l = i+j-1;
				if (i == 0 && j == 0) { // the first cell would be true
					T[i][j] = true;
					continue;
				}
				
				else if (i == 0) { // this is for the first row
					if (str3[l] == str2[j-1]) {
						T[i][j] = T[i][j-1]; // check left 
					}
				}	
				else if (j == 0) {
					if (str1[i-1] == str3[l]) {
						T[i][j] = T[i-1][j]; // check top
					}
				}
				else {
					T[i][j] = 
							(str1[i-1] == str3[l] ? T[i-1][j] : false) ||
							(str3[l] == str2[j-1] ? T[i][j-1] : false);
				}
			}
		}
		
		return T[l1][l2];
	}
	
	public static void main(String[] args) {
		
		StringInterleaving si = new StringInterleaving();	
		String s1 = "aab";
		String s2 = "axy";
		
		String s3 = "aaxaby";
		String s4 = "abaaxy";
		
		System.out.println(si.isInterleaved(s1.toCharArray(), s2.toCharArray(), s3.toCharArray()));
		System.out.println(si.isInterleaved(s1.toCharArray(), s2.toCharArray(), s4.toCharArray()));
		
		String str1 = "XXYM";
        String str2 = "XXZT";
        String str3 = "XXXZXYTM";
        System.out.println(si.isInterleaved(str1.toCharArray(), str2.toCharArray(), str3.toCharArray()));
	}

}
