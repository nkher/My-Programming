package Graphs.dfs;

import java.util.ArrayList;

public class Graph {

	private int V; // number of vertices
	private ArrayList<GraphVertex> adjacencyList;
	private int countOfVertices = 0;
	
	public Graph(int V) {
		this.V = V;
		adjacencyList = new ArrayList<GraphVertex>(V);
	}
	
	public void addVertexToGraph(GraphVertex node) {
		this.countOfVertices++;
		adjacencyList.add(node);
	}
	
	public void print() {
		System.out.println("------YOUR GRAPH IS--------\n\n");
		for (int i=0;i<countOfVertices;i++) {
			GraphVertex  v = adjacencyList.get(i);
			System.out.print("Vertex is : " + v.vNumber + "\t");
			ArrayList<GraphVertex> adjacencyList = v.getAdjacencyList();
			System.out.print("Adjacency List :   [");
			for (int j=0;j<adjacencyList.size();j++) {
				System.out.print(" " + adjacencyList.get(j).vNumber + " ");
			}
			System.out.println("]");
		}
		System.out.println();
		System.out.println("\n\n------YOUR GRAPH IS--------");
	}
	
	public void dfs() {
		boolean visited[] = new boolean[V];
		for (int i=0;i<V;i++) 			
			visited[i] = false; // making all false first
		
		for (int i=0;i<V;i++) {
			GraphVertex gv = adjacencyList.get(i);
			if (visited[gv.vNumber] == false)
				dfsUtil(gv, visited);
		}
	}
	
	private void dfsUtil(GraphVertex gv, boolean visited[]) {
		visited[gv.vNumber] = true;
		System.out.println("Visited Node : " + gv.vNumber);
		
		// Traverse through it list
		ArrayList<GraphVertex> adjList = gv.adjList;
		for (int i=0;i<adjList.size();i++) {
			if (visited[adjList.get(i).vNumber] == false)
				dfsUtil(adjList.get(i), visited);
		}
	}
	
	public static void main(String[] args) {
		
		// Making the graph
		Graph graph = new Graph(4);
		
		GraphVertex v0 = new GraphVertex(0);
		GraphVertex v1 = new GraphVertex(1);
		GraphVertex v2 = new GraphVertex(2);
		GraphVertex v3 = new GraphVertex(3);
		
		v0.addAdjacentVertex(v1);
		v0.addAdjacentVertex(v2);
		v1.addAdjacentVertex(v3);
		v2.addAdjacentVertex(v3);
		v2.addAdjacentVertex(v0);
		v3.addAdjacentVertex(v1);
		
		graph.addVertexToGraph(v0);
		graph.addVertexToGraph(v1);
		graph.addVertexToGraph(v2);
		graph.addVertexToGraph(v3);
		
		graph.print();
		System.out.println("\n\n");
		
		// doing a dfs
		
		System.out.println("Performing DFS on the graph\n\n");
		graph.dfs();
	}
}

class GraphVertex {
	int vNumber;
	ArrayList<GraphVertex> adjList;
	public int adjacencyCount;
	
	public GraphVertex(int vNumber) {
		this.vNumber = vNumber;
		adjList = new ArrayList<GraphVertex>();
	}
	
	public int getNodeNumber() {
		return vNumber;
	}
	
	public ArrayList<GraphVertex> getAdjacencyList() {
		return adjList;
	}
	
	public void addAdjacentVertex(GraphVertex gv) {
		adjList.add(gv);
		adjacencyCount++;
	}
}
