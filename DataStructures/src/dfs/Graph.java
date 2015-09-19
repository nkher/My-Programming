package dfs;

import java.io.File;
import java.io.FileNotFoundException;

public class Graph {
	
	Vertex[] adjLists;
	
	public Graph(String file) throws FileNotFoundException {
		
		java.util.Scanner sc = new java.util.Scanner(new File("files/" + file));
		String graphType = sc.next();
		boolean undirected = true;
		if(graphType.equals("directed")) {
			undirected = false;
		}
		
		adjLists = new Vertex[sc.nextInt()];
		// Reading the vertices and storing the vertex names
		for (int v=0;v<adjLists.length;v++) {
			adjLists[v] = new Vertex(sc.next(), null);
		}
		
		// reading the edges
		while (sc.hasNext()) {
			// Reading the vertex names and translating to vertex numbers
			int v1 = indexForName(sc.next());
			int v2 = indexForName(sc.next());
			
			// adding v2 to front of v1's adjacency list	
			// adding v1 to front of v2's adjacency list
			adjLists[v1].adjList = new Neighbor(v2, adjLists[v1].adjList);
			if(undirected) 
				adjLists[v2].adjList = new Neighbor(v1, adjLists[v2].adjList);
		}
	}
	
	int indexForName(String name) {
		for (int v=0; v<adjLists.length;v++) {
			if(adjLists[v].name == name)
				return v;
		}
		return -1;
	}
	
	// The dfs() method exposed to the outside world
	public void dfs() {
		boolean visited[] = new boolean[adjLists.length];
		for (int v=0;v<visited.length;v++) {
			if(!visited[v])
				System.out.println("\nSTARTING AT " + adjLists[v].name);
				dfs(v, visited);
		}
	}
	
	
	private void dfs(int v, boolean[] visited) {
		visited[v] = true;
		System.out.println("Visiting " + adjLists[v].name);
		for(Neighbor nbr = adjLists[v].adjList; nbr != null; nbr = nbr.next) {
			if(!visited[nbr.vertexNum]) {
				System.out.println("\n " + adjLists[v].name + " -- " + adjLists[nbr.vertexNum].name);
				dfs(nbr.vertexNum, visited);
			}
		}
 	}
	
	public void printGraph() {
		System.out.println();
		for(int v=0;v<adjLists.length;v++) {
			System.out.println(adjLists[v].name);
			for(Neighbor nbr = adjLists[v].adjList; nbr != null; nbr = nbr.next) 
				System.out.println(" --> " + adjLists[nbr.vertexNum].name);
			}
	}
	
	public static void main(String args[]) throws FileNotFoundException {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.println("Enter graph input file name : ");
		String file = sc.nextLine();
		Graph graph = new Graph(file);
		graph.printGraph();
		graph.dfs();
	}
}











