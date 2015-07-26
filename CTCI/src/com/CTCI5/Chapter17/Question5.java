package com.CTCI5.Chapter17;

public class Question5 {
	
	public static int code(char c) {
		switch(c) {
			case 'B' : return 0;
			
			case 'G' : return 1;
			
			case 'R' : return 2;
			
			case 'Y' : return 3;
			
			default : return -1;
		}
	}
	
	public static int MAX_COLORS = 4;
	
	public static Result estimate(String guess, String solution) {
		
		if (guess.length() != solution.length()) return null;
		
		Result result = new Result();
		int[] frequencies = new int[MAX_COLORS];
		
		for (int i=0;i<guess.length();i++) {
			if (guess.charAt(i) == solution.charAt(i))
				result.hits++;
			else {
				/* Only increment the frequency table (which will be used for pseudo-hits) if
				 * it's not a hit. If it's a hit, the slot has already been "used." */
				int code = code(solution.charAt(i));
				if (code >= 0) {
					frequencies[code]++;
				}
			}
		}
		
		/* Computing psuedo hits */
		for (int i=0;i<guess.length();i++) {
			int code = code(guess.charAt(i));
			if (code >= 0 && frequencies[code] > 0 && guess.charAt(i) != solution.charAt(i)) {
				result.psuedohits++;
				frequencies[code]--;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {	
		String guess = "GRBY";
		String solution = "BBRY";
		
		Result res = Question5.estimate(guess, solution);
		System.out.println(res.toString());
	}
}

class Result {
	public int hits;
	public int psuedohits;
	
	public Result() {}
	
	public Result(int h, int ph) {
		this.hits = h;
		this.psuedohits = ph;
	}
	
	public String toString() {
		return "(" + hits + ", " + psuedohits + ")";
	}
}
