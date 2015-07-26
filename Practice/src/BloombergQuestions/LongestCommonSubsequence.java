package BloombergQuestions;

public class LongestCommonSubsequence {
	
	public static int[][] LCS(String x, String y) {
		int M = x.length();
		int N = y.length();
		int[][] lcs_array = new int[M+1][N+1];
				
		for (int i=M-1;i>=0;i--) {
			for (int j=N-1;j>=0;j--) {
				if (x.charAt(i) == y.charAt(j)) {
					lcs_array[i][j] = 1 + lcs_array[i+1][j+1];
				}
				else
					lcs_array[i][j] = Math.max(lcs_array[i+1][j], lcs_array[i][j+1]);
			}
		}
		return lcs_array;
	}
	
	public static void main(String[] args) {
		//String x = "abacebee";
		//String y = "adbavceee";
		String x = "streets";
		String y = "street";
		int M = x.length();
		int N = y.length();
		int lcs_array[][] = LongestCommonSubsequence.LCS(x, y);
		
		// Printing the longest common subsequence
		// recover LCS itself and print it to standard output
        int i = 0, j = 0;
        while(i < M && j < N) {
            if (x.charAt(i) == y.charAt(j)) {
                System.out.print(x.charAt(i));
                i++;
                j++;
            }
            else if (lcs_array[i+1][j] >= lcs_array[i][j+1]) i++;
            else                                 j++;
        }
        System.out.println();
	}
}