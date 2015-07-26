package BloombergQuestions;

import java.util.ArrayList;

public class JosephusProblem {

	public static int josephus(int n, int k) {
		if(n == 1) {
			return 1;
		}
		else {
			/* The position returned by josephus(n - 1, k) is adjusted because the
		       recursive call josephus(n - 1, k) considers the original position 
		       k%n + 1 as position 1 */
			return (josephus(n-1, k) + k-1) % n + 1;
		}
	}
	
	public static int josephus_problem(int n, int k) {
		boolean a[] = new boolean[n];
		for (int i=0;i<a.length;i++) 
			a[i] = true; // every one is alive at start
		int currentPointer = -1, alive = n, moves = 0;
		while (alive > 1) {
			// currentPointer = (currentPointer + k) % n; // go to the kth position from the current one
			while (moves < k) {
				currentPointer = (currentPointer+1)%n;
				if (!a[currentPointer])
					continue;
				else 
					moves++;
			}
			a[currentPointer] = false;
			alive--;
			moves = 0;
		}
		while (a[currentPointer] == false) {
			currentPointer = (currentPointer+1)%n;
		}
		return currentPointer+1;
	}
	
	public static int josephus_problem(ArrayList<Integer> n, int k) {
		boolean a[] = new boolean[n.size()];
		for (int i=0;i<a.length;i++) 
			a[i] = true; // every one is alive at start
		int currentPointer = -1, moves = 0;
		while (n.size() > 1) {
			currentPointer = currentPointer + k-1;
			n.remove(currentPointer);
		}
		return 0;
	}
	
	public static void main(String[] args) {
		int n = 7;
		int k = 3;
		System.out.println("The safe position would be : " + josephus(n, k));
		
		System.out.println();
		
		int alive_position = josephus_problem(n, k);
		System.out.println("The person at position " + alive_position + " is alive !! Congratulations.");
		
		alive_position = josephus_problem(9, 5);
		System.out.println("The person at position " + alive_position + " is alive !! Congratulations.");
		
		ArrayList<Integer> list = new ArrayList<Integer>(7);
		for (int i=0;i<list.size();i++)
			list.add(i, i);
		
		System.out.println("The person at position " + josephus_problem(list, 3) + " is alive !! Congratulations.");
		
	}

}
