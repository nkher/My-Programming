package DynamicPrograming;

public class EggDroppingProblem {
	
	public int calcMinAttempts(int eggs, int floors) {
		int T[][] = new int[eggs+1][floors+1]; //cols are floors and rows are eggs
		int minAttempts = 0;
		
		// populate the 1st row as 1,2,3,4,.....till f as if we only have 1 egg then
		// minimum attempts will be equal to the number of floors
		for (int i=0;i<floors;i++) {
			T[1][i] = i;
		}
		
		for (int e=2;e<=eggs;e++) {
			
			for (int f=1;f<=floors;f++) {
				T[e][f] = Integer.MAX_VALUE;
					
				for (int k=1;k<=f;k++) {
					
					minAttempts = 1 + Math.max(T[e-1][k-1], T[e][f-k]);
					if (minAttempts < T[e][f]) {
						T[e][f] = minAttempts;
					}
				}
			}
		}
		
		return T[eggs][floors];
	}
	
	public static void main(String[] args) {
		EggDroppingProblem edp = new EggDroppingProblem();
		System.out.println(edp.calcMinAttempts(2, 6));
		
		System.out.println(edp.calcMinAttempts(2, 100));
	}
}
