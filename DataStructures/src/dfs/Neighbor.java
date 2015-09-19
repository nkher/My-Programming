package dfs;

// A linked list class that will represent the neighbor 
// It stores its neighbor as the adjacent item in the list
public class Neighbor {
	public int vertexNum; 
	public Neighbor next;
	public Neighbor(int vertexNum, Neighbor next) {
		this.vertexNum = vertexNum;
		this.next = next;
	}
}
