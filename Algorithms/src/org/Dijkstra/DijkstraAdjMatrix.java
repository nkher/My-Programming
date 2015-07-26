package org.Dijkstra;

public class DijkstraAdjMatrix {
	
	private final int vertices = 9;
	
	//Function to find the vertex with the minimum distance value 
	//from the current vertex which is not included in the Set
	public int extractMinDistance(int queue[], boolean set[]){
		int min=Integer.MAX_VALUE;	
		int minIndex=0;
		
		for(int v=0;v<vertices; v++){
			if(set[v] == false && queue[v] <= min){
				min=queue[v]; 
				minIndex=v;
			}
		}
		return minIndex;
	}
		
	//Function to print the constructed array
	public void printSolution(int queue[], int n){
		System.out.print("Vertex Distance from Source \n");
		for(int i=0;i<vertices;i++)
			System.out.println(i + " " + queue[i]);
	}
	
	//Function to implement Dijkstra's single source shortest path algorithm
	public void dijkstra(int graphWeight[][], int source){
		
		int queue[] = new int[vertices]; //The array which will hold the shortest distance from source to node i
		boolean set[] =  new boolean[vertices]; //It will store true for node i if the shortest path to that vertex or node is found
		
		//Initialize distances to infinity and set[] array to false 
		for(int i=0;i<vertices;i++){
			queue[i] = Integer.MAX_VALUE; 
			set[i] = false;
		}
		
		//Distance of source vertex from itself is always 0
		queue[source] = 0;

		//Find shortest path of all the vertices
		for(int count=0;count<vertices-1;count++){
			
			//Pick the minimum distance vertex from the from the set of vertices 
			//not processed. u is equal to source in first iteration
			int u = extractMinDistance(queue, set);
			
			//Mark the picked vertex processed
			set[u] = true;
			//Update queue value of the adjacent vertices of the picked vertex
			for(int v=0;v<vertices;v++)
			{
				//Update queue[v] only if
				// 1. It is not in set true in the Set Array
				// 2. There is an edge from u to v
				// 3. Total weight of path from source to v through u is smaller than current value of queue[v]
				if((graphWeight[u][v] > 0) && set[v] == false){
						if(queue[u] + graphWeight[u][v] < queue[v]){
							queue[v] = queue[u] + graphWeight[u][v];
						}
					}
				}
				//printSolution(queue, vertices);
		}
		//Print the constructed distance array
		printSolution(queue, vertices);
	}
}
