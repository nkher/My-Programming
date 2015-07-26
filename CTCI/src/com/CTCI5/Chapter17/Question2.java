package com.CTCI5.Chapter17;

public class Question2 {
	
	
	/* Check 3 by 3 winner */
	public static int checkWinner(int [][]gameboard) {
		for (int i=0;i<gameboard.length;i++) {
			/* Check rows */
			if (gameboard[i][0] != 0 && gameboard[i][1] == gameboard[i][0] && 
					gameboard[i][2] == gameboard[i][0]) {
				return gameboard[i][0];
			}
			
			/* Check columns */
			if (gameboard[0][i] != 0 && gameboard[1][i] == gameboard[0][i] && 
					gameboard[2][i] == gameboard[0][i])
				return gameboard[0][i];
		}
		
		/* Check diagonal */
		if (gameboard[0][0] != 0 && gameboard[1][1] == gameboard[0][0] && 
				gameboard[2][2] == gameboard[2][2])
			return gameboard[0][0];
		
		/* Check diagonal */
		if (gameboard[0][2] != 0 && gameboard[1][1] == gameboard[0][2] && 
				gameboard[2][0] == gameboard[0][2])
			return gameboard[0][2];
		
		return 0;
	}
	
//	  {1,1,0,1},
//	  {2,1,1,1},
//	  {2,2,2,2},
//	  {0,1,1,2} 
	
	/* Check N by N winner */
	public static int checkWinnerBigger(int [][]gameb) {
		int i, j, checker, len = gameb.length;;
		for (i=0;i<gameb.length;i++) {
			/* Check rows */
			checker = gameb[i][0];
			for (j=0;j<gameb[i].length;j++) {
				if (gameb[i][j] != checker)
					break;
			}
			if (j == len) return checker;
			
			/* Check columns */
			checker = gameb[0][i];
			for (j=1;j<gameb[i].length;j++) {
				if (gameb[j][i] != checker)
					break;
			}
			if (j == len) return checker;
		}
		
		/* Check diagonal */
		checker = gameb[0][0];
		for (i=1;i<gameb.length;i++) {
			if (gameb[i][i] != checker)
				break;
		}
		if (i == len) return checker;
		
		/* Check back diagonal */
		checker = gameb[0][len-1];
		int x = len-1;
		for (i=1;i<len;i++) {
			if (gameb[i][x-i] != checker)
				break;
		}
		if (i == len) return checker;
		
		// if non satisfies return 0 which is no winner
		return 0;
	}
	
	
	public static void main(String[] args) {
		
		int gameboard[][] = { {1,2,1},
							  {2,1,1},
							  {1,2,2} };
		
		int result = checkWinner(gameboard);
		if (result == 0) System.out.println("No Winner");
		else System.out.println(result + " is winner ");
		
		
		int gameb[][] = 	{ {1,0,0,1},
				  			  {2,1,1,1},
				  			  {1,1,1,2},
				  			  {1,1,1,0} };
		
		result = checkWinnerBigger(gameb);
		if (result == 0) System.out.println("No Winner");
		else System.out.println(result + " is winner");
	}

}
