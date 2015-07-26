package org.Dijkstra;

public class DijkstraMatrixMain {

	
	public static void main(String[] args) {
		
		int graphWeight[][] =  {{0, 4, 0, 0, 0, 0, 0, 8, 0},
				                {4, 0, 8, 0, 0, 0, 0, 11, 0},
				                {0, 8, 0, 7, 0, 4, 0, 0, 2},
				                {0, 0, 7, 0, 9, 14, 0, 0, 0},
				                {0, 0, 0, 9, 0, 10, 0, 0, 0},
				                {0, 0, 4, 0, 10, 0, 2, 0, 0},
				                {0, 0, 0, 14, 0, 2, 0, 1, 6},
				                {8, 11, 0, 0, 0, 0, 1, 0, 7},
				                {0, 0, 2, 0, 0, 0, 6, 7, 0}
				               };
		
		DijkstraAdjMatrix object = new DijkstraAdjMatrix();
		object.dijkstra(graphWeight, 0);
	}

}
