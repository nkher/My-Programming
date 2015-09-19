package Graphs.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph {

	private int V; // number of vertices
	private ArrayList<GraphVertex> adjacencyList;
	private int currentCount;
	
	public Graph(int V) {
		this.V = V;
		adjacencyList = new ArrayList<GraphVertex>();
		currentCount = 0;
	}
	
	public int getGraphCapacity() {
		return V;
	}
	
	public int getCurrentSize() {
		return currentCount;
	}
	
	public void addVertexToGraph(GraphVertex gv) {
		adjacencyList.add(gv);
		currentCount++;
	}
	
	public void print() {
		System.out.println("------YOUR GRAPH IS--------\n\n");
		for (int i=0;i<currentCount;i++) {
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
	
	public void bfs(GraphVertex start) {
		boolean visited[] = new boolean[V];
		// initializing everything to false
		for (int i=0;i<V;i++)
			visited[adjacencyList.get(i).vNumber] = false;
		
		Queue<GraphVertex> q = new LinkedList<GraphVertex>();
		ArrayList<GraphVertex> list;
		// taking the first vertex
		visited[start.vNumber] = true;
		q.add(start); // adding to the queue
		
		while (!q.isEmpty()) {
			
			// Dequeue it
			GraphVertex gv = q.remove();
			System.out.println("Visited : " + gv.vNumber);
			
			// now add all its vertices to the queue and then visit them one by one
			list = gv.getAdjacencyList();
			for (int j=0;j<list.size();j++) {
				// add to the queue only if not visited
				if (visited[list.get(j).vNumber] == false) {
					// make it true and add to the queue
					visited[list.get(j).vNumber]  = true;
					q.add(list.get(j));
				}
			}
		}
	}
	
	// clone using bfs
	public Graph clone(GraphVertex start) {
		if (start == null) return null;
		Graph graph = new Graph(this.V);
		boolean visited[] = new boolean[this.V];
		for (int j=0;j<this.V;j++) {
			visited[this.adjacencyList.get(j).vNumber] = false;
		}
		
		Map<Integer, GraphVertex> map = new HashMap<Integer, GraphVertex>();
		Queue<GraphVertex> queue = new LinkedList<GraphVertex>();
		queue.add(start);
		
		// make copy of start and put in map
		GraphVertex start_clone = null;
		start_clone = start.clone(start_clone);
		map.put(start_clone.vNumber, start_clone);
		graph.addVertexToGraph(start_clone);
		visited[start_clone.vNumber] = true;
		
		// add the first node
		while (!queue.isEmpty()) {
			GraphVertex gv = queue.remove();
			if (!visited[gv.vNumber]) {				
				visited[gv.vNumber] = true; // make it visited
				int n = gv.adjList.size();
				for (int i=0;i<n;i++) {
					GraphVertex neighbor = gv.adjList.get(i);
					
					if (!map.containsKey(neighbor.vNumber)) {
						// Make a similar new vertex and initialize everything
						GraphVertex newGraphVertex = new GraphVertex();	
						newGraphVertex = neighbor.clone(newGraphVertex);
						
						// add to the hashmap
						map.put(newGraphVertex.vNumber, newGraphVertex); 
						
						// add it to current ones adjacency
						gv.addAdjacentVertex(newGraphVertex); 
						queue.add(newGraphVertex); // put in queue
					}
					else {
						gv.addAdjacentVertex(map.get(neighbor.vNumber));
					}
				}
			}
		}
		return graph;
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
		
		System.out.println("Printing Graph 1\n");
		
		graph.print();
		System.out.println();
		
//		System.out.println("Performing BFS on the graph\n\n");
//		graph.bfs(v0);
		
		// Cloning the graph
		Graph g2 = graph.clone(v0);
		
		System.out.println("\nPrinting Graph 2\n");
		g2.print();
	}

}

class GraphVertex {
	int vNumber;
	ArrayList<GraphVertex> adjList;
	public int countOfAdjacency;
	
	public GraphVertex() {}
	
	public GraphVertex(int vNumber) {
		this.vNumber = vNumber;
		adjList = new ArrayList<GraphVertex>();
		countOfAdjacency = 0;
	}
	
	public int getNodeNumber() {
		return this.vNumber;
	}
	
	public ArrayList<GraphVertex> getAdjacencyList() {
		return this.adjList;
	}
	
	public void addAdjacentVertex(GraphVertex gv) {
		adjList.add(gv);
		this.countOfAdjacency++;
		
	}
	
	public GraphVertex clone(GraphVertex v) {
		v = new GraphVertex(this.vNumber);
		v.adjList = this.adjList;
		return v;
	}
}
