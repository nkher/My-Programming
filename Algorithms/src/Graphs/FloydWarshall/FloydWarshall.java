package Graphs.FloydWarshall;

public class FloydWarshall {
	
	public static int INF = Integer.MAX_VALUE;

	// TC = O(N^3)
	public static void floydWarshall(int graph[][], int V) {
		
		/* dist[][] will be the output matrix that will finally have the shortest 
	      distances between every pair of vertices */
		int dist[][] = new int[V][V];
		
		/* Initialize the solution matrix same as input graph matrix. Or 
	       we can say the initial values of shortest distances are based
	       on shortest paths considering no intermediate vertex. */
		for(int i=0; i<V; i++) {
			for(int j=0; j<V; j++) {
				dist[i][j] = graph[i][j];
			}
		}
		
		/* Add all vertices one by one to the set of intermediate vertices.
	      ---> Before start of a iteration, we have shortest distances between all
	      pairs of vertices such that the shortest distances consider only the
	      vertices in set {0, 1, 2, .. k-1} as intermediate vertices.
	      ----> After the end of a iteration, vertex no. k is added to the set of
	      intermediate vertices and the set becomes {0, 1, 2, .. k} */
		
		for (int k=0; k<V; k++) {
			
			// Picking sources one by one
			for (int i=0; i<V; i++) {
				
				// Picking up the destinations one by one
				for (int j=0; j<V; j++) {
					
					// If vertex k is on the shortest path from
	                // i to j, then update the value of dist[i][j]
					if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		printSolution(dist);
	}
	
	public static void printSolution(int dist[][]) {
		for (int i=0; i<dist.length; i++) {
			for (int j=0; j<dist[i].length; j++) {
				
				if (dist[i][j] == INF) {
					System.out.print(-1 + " ");
					//System.out.printf("M%d%n", 1);
				}
				else {
					System.out.print(dist[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
				
		int graph[][] = { {0,   5,  INF, 10},
                		{INF,  0,  3,  INF},
                		{INF, INF, 0,   1},
                		{INF, INF, INF, 0} };
		
		floydWarshall(graph, graph.length);
	}

}
