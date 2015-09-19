package HonorsClass;

import java.util.ArrayList;

import Library.HighwaySection;

public class Q22_49 {
	
	public static int INF = Integer.MAX_VALUE;
	
	/* 
	 * Here a and b are the cities between which we have to optimize. Compute the shortest path distances between each pair of 
	 * cities (x, y). We could use floyd Warshalls algorithm for this which is O(n^3). Then we use the distance matrix created to
	 * test each city a and b. For example when testing a proposal 'p' we could check for the minimum distance by proposal using the following 
	 * formula -> 
	 * 
	 * p has a pair of cities (x and y)
	 * 
	 * d(a, b) = Math.min ( d(a, b), [ d(a, x) + d(x, y) + d(y, b) ], [ d(a, y) + d(y, x) + d(x, b) ])
	 * 
	 * Total time complexity would be : O(n^3 + k) time complexity 
	 * */
	public static HighwaySection findBestProposals(ArrayList<HighwaySection> H, ArrayList<HighwaySection> P, int a, int b, int n) {
		
		// Create a graph (matrix data structure) that would store shortest path between all the pair of vertices
		double graph[][] = new double[n][n];
		// initialize graph
		for (int i=0; i<graph.length; i++) {
			graph[i][i] = 0;
		}
		
		// Creating the graph based on existing highway sections H
		for (HighwaySection h : H) {
			graph[h.x][h.y] = graph[h.y][h.x] = h.distance;
		}
		
		// Performing the floyd warshall's algorithm
		floydWarshal(graph);
		
		printSolution(graph);
		
		// Examining each proposal between a and b
		double minDist = graph[a][b];
		HighwaySection bestProposal = new HighwaySection(-1, -1, 0.0);
		
		for (HighwaySection p : P) {
			
			// check the path from a -> p.x -> p.y -> b
			if (graph[a][p.x] != INF && graph[p.y][b] != INF && 
				minDist > (graph[a][p.x] + p.distance + graph[p.y][b]) ) {
				
				minDist = graph[a][p.x] + p.distance + graph[p.y][b];
				bestProposal = p;
			}
				
			// check the path from a -> p.y -> p.x -> b
			if (graph[a][p.y] != INF && graph[p.y][b] != INF &&
				minDist > (graph[a][p.y] + p.distance + graph[p.x][b]) ) {
				
				minDist = graph[a][p.y] + p.distance + graph[p.x][b];
				bestProposal = p;
			}
		}
		
		return bestProposal;
	}
	
	public static void printSolution(double dist[][]) {
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
	
	public static void floydWarshal(double graph[][]) {
		
		for (int k=0; k<graph.length; k++) {
			for (int i=0; i<graph.length; i++) {
				for (int j=0; j<graph.length; j++) {
					
					if (graph[i][k] != INF && graph[k][j] != INF && (graph[i][j] > graph[i][k] + graph[k][j])) {
						
						graph[i][j] = graph[i][k] + graph[k][j];
					}
				}
			}
		}
	}
	
	public static void main(String args[]) {
		
		HighwaySection h1 = new HighwaySection(0, 1, 100);
		HighwaySection h2 = new HighwaySection(1, 2, 200);
		HighwaySection h3 = new HighwaySection(2, 3, 170);
		HighwaySection h4 = new HighwaySection(1, 3, 300);
		
		ArrayList<HighwaySection> H = new ArrayList<HighwaySection>();
		H.add(h1);
		H.add(h2);
		H.add(h3);
		H.add(h4);
		
		HighwaySection p1 = new HighwaySection(0, 1, 50);
		HighwaySection p2 = new HighwaySection(1, 2, 150);

		ArrayList<HighwaySection> P = new ArrayList<HighwaySection>();
		P.add(p1);
		P.add(p2);
		
		
		System.out.println(findBestProposals(H, P, 1, 3, 4));
		
	}
}


