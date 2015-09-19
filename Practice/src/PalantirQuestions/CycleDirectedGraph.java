package PalantirQuestions;

import java.util.ArrayList;

public class CycleDirectedGraph {
	
	int Vertices; // Number of vertices
	Vertex[] adjacencyListVertices;
	int countOfVertices;
	
	public CycleDirectedGraph(int number) {
		this.Vertices = number;
		adjacencyListVertices = new Vertex[number];
		countOfVertices = 0;
	}
	
	public void addVertexToGraph(Vertex v) {
		if (countOfVertices < 10) {
			adjacencyListVertices[countOfVertices] = v;
			countOfVertices++;
		}
		else {
			System.out.println("Graph is full !!");
		}
	}
	
	public Vertex[] getAllNodes() {
		return adjacencyListVertices;
	}
	
	public boolean isCyclic() {
		
		boolean visited[] = new boolean[countOfVertices];
		boolean recursionStack[] = new boolean[countOfVertices];
		
		// Mark all the vertices as not visited and not part of recursion
	    // stack
		for (int i=0;i<countOfVertices;i++) {
			visited[adjacencyListVertices[i].vertexNumber] = false;
			recursionStack[adjacencyListVertices[i].vertexNumber] = false;
		}
		
		// Call the recursive helper function to detect cycle in different
	    // DFS trees
		for (int i=0;i<countOfVertices;i++) {
			Vertex v = adjacencyListVertices[i];
			if (isCyclicHelper(v, visited, recursionStack))
				return true;
		}
		return false;
	}
	
	public boolean isCyclicHelper(Vertex v, boolean[] visited, boolean[] recursionStack) {
		// first check if the node has already been visited and then proceed
		if (visited[v.vertexNumber] == false) {
			System.out.println("\nCame in for : " + v.vertexNumber);
			// mark it as true in both the arrays
			visited[v.vertexNumber] = true;
			recursionStack[v.vertexNumber] = true;
			
			// Recur for all the vertices in its adjacency list
			ArrayList<Vertex> adjacencyList = adjacencyListVertices[v.vertexNumber].getAdjacencyList();
			for (int i=0;i<adjacencyList.size();i++) {
				if( !visited[adjacencyList.get(i).vertexNumber] && isCyclicHelper(adjacencyList.get(i), visited, recursionStack) )
					return true;
				else if (recursionStack[adjacencyList.get(i).vertexNumber]) {
					//System.out.println("Came here for the termination condition for : " + adjacencyList.get(i).vertexNumber);
					return true;
				}
			}
		}
		recursionStack[v.vertexNumber] = false;
		return false;
	}
	
	public void print() {
		System.out.println("------YOUR GRAPH IS--------\n\n");
		for (int i=0;i<countOfVertices;i++) {
			Vertex  v = adjacencyListVertices[i];
			System.out.print("Vertex is : " + v.vertexNumber + "\t");
			ArrayList<Vertex> adjacencyList = v.getAdjacencyList();
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
		
		// Make a graph
		CycleDirectedGraph graph = new CycleDirectedGraph(4);
		
		// Making vertices 
		Vertex v0 = new Vertex(0);
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		
		// Adding edges
		v0.addAdjacentNode(v1);
		v0.addAdjacentNode(v2);
		v1.addAdjacentNode(v2);
		v2.addAdjacentNode(v0);
		v2.addAdjacentNode(v3);
		v3.addAdjacentNode(v3);
		
		// Without edges
//		v0.addAdjacentNode(v1);
//		v2.addAdjacentNode(v0);
//		v2.addAdjacentNode(v3);
		
		// Adding vertices to the graph
		graph.addVertexToGraph(v0);
		graph.addVertexToGraph(v1);
		graph.addVertexToGraph(v2);
		graph.addVertexToGraph(v3);
		
		// Printing the graph
		graph.print();
				
		// Checking if cyclic or not
		if (graph.isCyclic()) 
			System.out.println("\n\nGraph contains a cycle");
		else
			System.out.println("\n\nGraph does not contain a cycle");
	}
}

class Vertex {
	int vertexNumber;
	ArrayList<Vertex> adjacencyList;
	public int adjacencyCount;
	
	public Vertex(int vertexNumber) {
		this.vertexNumber = vertexNumber;
		adjacencyList = new ArrayList<Vertex>();
	}
	
	public void addAdjacentNode(Vertex v) {
		if (adjacencyCount < 10) {
			adjacencyList.add(v);
			adjacencyCount++;
		}
		else {
			System.out.println("No more adjacent can be added");
		}
	}
	
	public int getVertex() {
		return vertexNumber;
	}
	
	public ArrayList<Vertex> getAdjacencyList() {
		return adjacencyList;
	}
}
