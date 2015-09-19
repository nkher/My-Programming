package CareerCup.Google.Latest;

public class NumberOfCountries {
	
	private int m ,n;
	private int map[][];
	private boolean visited[][];
	
	public NumberOfCountries(int map[][], int m, int n) {
		this.map = map;
		this.n = n;
		this.m = m;
		visited = new boolean[m][n];
		for (int i=0;i<m;i++) {
			for (int j=0;j<n;j++) {
				visited[i][j] = false;
			}
		}
	}
	
	private boolean isVisited(int i, int j) {
		return visited[i][j];
	}
	
	// check if the number at that spot is v, if yes return true and we can move
	private boolean canMove(int i, int j, int v) {
		if (i < 0 || j < 0 || i>=m ||j>=n) return false;
		if ( (!isVisited(i, j) && v == map[i][j]))
			return true;
		return false;
	}
	
	private void dfs(int i, int j, int v) {
		if (canMove(i, j, v)) {
			visited[i][j] = true;
			
			dfs(i-1, j, v); // go up
			dfs(i, j-1, v); // go left
			dfs(i+1, j, v); // go down
			dfs(i, j+1, v); // go right
		}
	}
	
	public int getNumberOfCountries() {
		int count = 0;
		for (int i=0;i<m;i++) {
			for (int j=0;j<n;j++) {
				if (!isVisited(i, j)) {
					count++;
					dfs(i, j, map[i][j]);
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		
		int map1 [][] = {{1,1,1,0},{1,1,0,0},{0,0,0,1}};
		NumberOfCountries o = new NumberOfCountries(map1, map1.length, map1[0].length);
		System.out.println(o.getNumberOfCountries());
		
		int map2[][] = {{1,1,1,1},{0,0,0,0},{1,0,0,1}};
		o = new NumberOfCountries(map2, map2.length, map2[0].length);
		System.out.println(o.getNumberOfCountries());
		
		int map3[][] = {{1,0,1,1},{0,1,0,0},{0,0,1,1},{1,1,0,1}};
		o = new NumberOfCountries(map3, map3.length, map3[0].length);
		System.out.println(o.getNumberOfCountries());
	}

}
