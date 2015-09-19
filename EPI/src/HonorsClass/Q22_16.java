package HonorsClass;

import java.util.Arrays;

public class Q22_16 {
	
	public static int[] computeFairBonuses(int productivity[]) {
		
		int noOfEmployees = productivity.length;
		int []tickets = new int[noOfEmployees];
		int i = 0;
		
		// INITITAL PASS
		// Give one ticket to each
		for (i=0; i<noOfEmployees; i++) {
			tickets[i] = 1;
		}
		
		// LEFT TO RIGHT PASS
		// Now go from left to right and give one more ticket to an employee if he has done more work than is previous emp
		for (i=1; i<noOfEmployees; i++) {
			if (productivity[i] > productivity[i-1]) {
				tickets[i] = tickets[i-1] + 1;
			}
		}
		
		// RIGHT TO LEFT PASS
		// If an employee has done more work than his next employee then he would get [ max(hisOwnTickets, rightEmpTickets) + 1 ] number of tickets
		for (i=noOfEmployees-2; i>=0; i--) {
			if (productivity[i] > productivity[i+1]) {
				tickets[i] = Math.max(tickets[i], tickets[i+1]) + 1;
			}
		}
		
		return tickets;
	}
	
	public static void main(String[] args) {
		
		int productivity[] = {300, 400, 500, 200};
		
		System.out.println(Arrays.toString(computeFairBonuses(productivity)));
	}

}
