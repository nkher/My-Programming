package dfs;

public class Vertex {
	String name;
	Neighbor adjList;
	public Vertex(String name, Neighbor neighbors) {
		this.name = name;
		this.adjList = neighbors;
	}
}
