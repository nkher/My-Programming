package com.CTCI5.Chapter17;

public class Question11 {
	
	// Method 1 - using rand5() to generate numbers between 
	// 0 and 24. numbers less than 24 have a equally likely probability
	// from 0 to 21
	public static int rand5() {
		return (int) (Math.random() * 100) % 5;
	}
	
	public static int rand7() {
		while (true) {
			int num = 5 * rand5() + rand5();
			if (num < 21)
				return num % 7;
		}
	}
	
	// Method 2 - using 2 * rand5() * rand5()
	public static int second_rand7() {
		while (true) {
			int r1 = 2 * rand5(); // evens between 0 and 9
			int r2 = rand5(); // number between 0 and 4
			if (r2 != 4) {
				int rand1 = r2 % 2; // getting either a 0 or 1
				int num = r1 + rand1;
				if (num < 7)
					return num;
			}
		}
	}
	
	public static void main(String[] args) {
		/* Test: call rand7 many times and inspect the results. */
		int[] arr = new int[7];
		int test_size = 1000000;
		for(int k = 0; k < test_size; k++){
			arr[rand7()]++;
		}

		for (int i = 0; i < 7; i++) {
			double percent = 100.0 * arr[i] / test_size;
			System.out.println(i + " appeared " + percent + "% of the time.");
		}
		
		for(int k = 0; k < test_size; k++){
			arr[second_rand7()]++;
		}
		
		System.out.println("\n\nMethod 2\n\n");
		
		for (int i = 0; i < 7; i++) {
			double percent = 100.0 * arr[i] / test_size;
			System.out.println(i + " appeared " + percent + "% of the time.");
		}
	}

}
