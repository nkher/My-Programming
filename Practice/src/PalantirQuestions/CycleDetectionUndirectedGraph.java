package PalantirQuestions;

import java.util.ArrayList;

public class CycleDetectionUndirectedGraph {

	int Vertices; // total number of vertices
	GraphVertex[] adjacencyListVertices;
	int countOfVertices;
	
	public CycleDetectionUndirectedGraph(int number) {
		this.Vertices = number;
		adjacencyListVertices = new GraphVertex[number];
		this.countOfVertices = 0;
	}
	
	public void addVertexToGraph(GraphVertex gv) {
		if (countOfVertices < Vertices) {
			adjacencyListVertices[countOfVertices] = gv;
			countOfVertices++;
		}
		else 
			System.out.println("Sorry the graph is full");
	}
			
	public GraphVertex[] getAllVerticesInGraph() {
		return adjacencyListVertices;
	}
	
	public boolean isCyclic() {
		boolean[] visited = new boolean[countOfVertices];
		// making all false
		for (int i=0;i<countOfVertices;i++)
			visited[adjacencyListVertices[i].vertexNumber] = false;
		
		// Call the recursive helper function to detect cycle in different
	    // DFS trees
		for (int u=0;u<countOfVertices;u++) {
			if (!visited[adjacencyListVertices[u].vertexNumber]) {
				if (isCyclicHelper(adjacencyListVertices[u], visited, null) )
					return true;
			}
		}
		return false;
	}
	
	public boolean isCyclicHelper(GraphVertex v, boolean visited[], GraphVertex parent) {
		// make the current node as visited
		visited[v.vertexNumber] = true;
		
		// now iterate over its adjacency list
		ArrayList<GraphVertex> adjacencyList = v.getAdjacencyList();
		for (int j=0;j<adjacencyList.size();j++) {
			// check if the adjacent is visited or not
			if ( !visited[adjacencyList.get(j).vertexNumber] ) { // if not visted
				// recurse
				if (isCyclicHelper(adjacencyList.get(j), visited, v))
					return true;
			}
			else if ( adjacencyList.get(j) != parent ){ // means if it is visited, check if it is not the parent of the current vertex in hand
				return true;
			}
		}
		return false;
	}
	
	public void print() {
		System.out.println("------YOUR GRAPH IS--------\n\n");
		for (int i=0;i<countOfVertices;i++) {
			GraphVertex  v = adjacencyListVertices[i];
			System.out.print("Vertex is : " + v.vertexNumber + "\t");
			ArrayList<GraphVertex> adjacencyList = v.getAdjacencyList();
			System.out.print("Adjacency List :   [");
			for (int j=0;j<adjacencyList.size();j++) {
				System.out.print(" " + adjacencyList.get(j).vertexNumber + " ");
			}
			System.out.println("]");
		}
		System.out.println();
		System.out.println("\n\n------YOUR GRAPH IS--------");
	}
	
	
	public static void main(String[] args) {
		
		CycleDetectionUndirectedGraph graph = new CycleDetectionUndirectedGraph(5);
		
		// Make the vertices
		GraphVertex v0 = new GraphVertex(0);
		GraphVertex v1 = new GraphVertex(1);
		GraphVertex v2 = new GraphVertex(2);
		GraphVertex v3 = new GraphVertex(3);
		GraphVertex v4 = new GraphVertex(4);
		
		// Making the edges
		v0.addNodeToAdjacency(v2);
		v2.addNodeToAdjacency(v1);
		v1.addNodeToAdjacency(v0);
		v0.addNodeToAdjacency(v3);
		v3.addNodeToAdjacency(v4);
		
		graph.addVertexToGraph(v0);
		graph.addVertexToGraph(v1);
		graph.addVertexToGraph(v2);
		graph.addVertexToGraph(v3);
		graph.addVertexToGraph(v4);
		
		// Printing the graph
		graph.print();
				
		// Checking if cyclic or not
		if (graph.isCyclic()) 
			System.out.println("\n\nGraph contains a cycle");
		else
			System.out.println("\n\nGraph does not contain a cycle");
		
		CycleDetectionUndirectedGraph graph2 = new CycleDetectionUndirectedGraph(3);

		GraphVertex v11 = new GraphVertex(0);
		GraphVertex v12 = new GraphVertex(1);
		GraphVertex v13 = new GraphVertex(2);
		
		// Making the edges
		v11.addNodeToAdjacency(v12);
		v12.addNodeToAdjacency(v13);

		graph2.addVertexToGraph(v11);
		graph2.addVertexToGraph(v12);
		graph2.addVertexToGraph(v13);
		
		// Printing the graph
		graph2.print();
				
		// Checking if cyclic or not
		if (graph2.isCyclic()) 
			System.out.println("\n\nGraph contains a cycle");
		else
			System.out.println("\n\nGraph does not contain a cycle");

	}
}

class GraphVertex {
	int vertexNumber;
	int countOfAdjacentNodes;
	ArrayList<GraphVertex> adjacencyList;
	
	public GraphVertex() {
	}
	
	public GraphVertex(int vNumber) {
		this.vertexNumber = vNumber;
		adjacencyList = new ArrayList<GraphVertex>();
		countOfAdjacentNodes++;
	}
	
	public ArrayList<GraphVertex> getAdjacencyList() {
		return adjacencyList;
	}
	
	public void addNodeToAdjacency(GraphVertex v) {
		this.adjacencyList.add(v);
	}
	
}
