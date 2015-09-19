package DP;

public class OptimalBST {
	
	public int minCostBST(int input[], int freq[]) {
		
		int n =  input.length;
		int T[][] = new int[n][n];
		
		// For each tree having only one node the cost will be the freq of the node * its level which is 1
		// hence the cost will be equal to the freq
		for (int i=0;i<n;i++) 
			T[i][i] = freq[i];
		
		for (int len=2;len<=n;len++) { //  Now adding lengths of 2 and greater
			
			for(int i=0;i<=n-len;i++) { // should run from 0 to array length - len, else will get index out of bounds !!
				
				int j = i+len-1; // This will be the node which is 'len' indices away from the current node i which is in consideration
				T[i][j] = Integer.MAX_VALUE; // Initialize to max value
				// Now get the sum from i to j
				int sum = getSum(freq, i, j);
				
				/* Now from i to j we will try and find the minimum cost to construct the tree 
				 * We use a third variable k that runs from i to j and we consider that part to be the root
				 * Then we have cost at root k is -> sum(from above) + cost from i to k and + cost from k to j
				 * Then select the minimum cost 
				 * */
				for (int k=i;k<=j;k++) {
					int val = sum + (k-1 < i ? 0 : T[i][k-1]) + (k+1 > j ? 0 : T[k+1][j]);
					if (val < T[i][j])
						T[i][j] = val;
				}
			}
		}
		
		return T[0][n-1];
	}
	
	public int getSum(int freq[], int start, int end) {
		int sum = 0;
		for (int x=start;x<=end;x++)
			sum += freq[x];
		return sum;
	}
	
	public static void main(String[] args) {
		// int input[] = {10,12,20,35,46};
        // int freq[] = {34,8,50,21,16};
        
        int input[] = {10,12,16,20};
        int freq[] = {4,2,6,3};
        
        OptimalBST obst = new OptimalBST();
        System.out.println(obst.minCostBST(input, freq));
	}

}
