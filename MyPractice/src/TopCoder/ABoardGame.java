package TopCoder;

import java.awt.Point;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Check Alice and Bob problem on TopCoder
// 214.79 points / 500
public class ABoardGame {
	
	private static Set<Point> points = new HashSet<Point>();
	private static final String ALICE_WINS = "Alice";
	private static final String BOB_WINS = "Bob";
	private static final String DRAW = "DRAW";
	
	public static String whoWins(String board[]) {
		int N = board.length;
		int layers = (N-1)/2;
		String result = "";
		
		// We start from the innermost region
		int s = layers, e = s+1;
		
		while (layers >= 0 && s >= 0 && e <= (N-1)) {
			result = checkRegion(board, s, e);
			if (!result.equals(DRAW)) 
				break;
			s--;
			e++;
			layers--;
		}
		
		return result;
	}
	
	public static String checkRegion(String board[], int s, int e) {
		int countAlice = 0, countBob = 0;
		Point p;
		String str = "";
				
		// check the region
		for (int i=s;i<=e;i++) {
			for (int j=s;j<=e;j++) {
				p = new Point(i, j);
				if (points.isEmpty() || !points.contains(p)) {
					str = board[i];
					if (str.charAt(j) == 'A') {
						countAlice++;
					}
					else if (str.charAt(j) == 'B') {
						countBob++;
					}
				}
				points.add(p); // add it to the set once finished
			}
		}
		
		if (countAlice > countBob) return ALICE_WINS;
		else if (countBob > countAlice) return BOB_WINS;
		
		return DRAW;
	}
	
	public static void printBoard(String A[]) {
		for (String s : A) {
			System.out.println(Arrays.toString(s.toCharArray()) + "\n");
		}
	}
	
	public static void main(String args[]) {
		
		String A[] = {".....A", "......", "..A...", "...B..", "......", "......"};
		//System.out.println(whoWins(A));
		//printBoard(A);
		
		String B[] = {"AAAA", "A.BA", "A..A", "AAAA"};
		//System.out.println(whoWins(B));
		//printBoard(B);
		
		String C[] = {"..", ".."};
		//System.out.println(whoWins(C));
		
		String D[] = {"BBB..BAB...B.B", ".AAAAAAAAAAAA.", "AA.AA.AB..A.AB", "..........B.AB", ".A..BBAB.A.BAB", ".AB.B.......A.", ".A..A.AB.A..AB", ".ABAA.BA...BA.", "BAAAB.....ABA.", ".A....B..A..B.", "B...B....B..A.", "BA.B..A.ABA.A.", "BAAAA.AAAAA.A.", "B.B.B.BB.B...."};
		//System.out.println(whoWins(D));
		
		String E[] = {"..A..AAA..AA", "ABABB..AAAAA", "ABBBBBBBBBA.", "AABBBABABBAA", "...BABABABBA", "B.BA..A.BBA.", "AA.A..B.AB.B", "..BA.B.AABAA", "..ABABBBABA.", ".ABB.BBBBBAA", "ABAAA.AA.A.A", "A..AAA.AAA.A"};
		//System.out.println(whoWins(E));
		
		String F[] = {"B..ABAABBB", "B.........", "A..A.AA..B", "A.BBBAA..A", "B.AAAAB...", "A..BBBBB.A", "B..ABAABBA", "A......B.B", "B......A.A", "BA.AABBB.A"};
		System.out.println(whoWins(F));
	}
}
