package org.BFS;

public class Graph {
	
	private final int MAX_VERTS = 20;
	private Vertex vertexList[]; //List of Vertices
	private int adjMat[][]; //Adjacency Matrix
	private int nVerts; //Current number of vertices
	private Queue theQueue;
	
	//Constructor
	public Graph(){
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts=0;
		for(int j=0;j<MAX_VERTS;j++)  //Set Adjacency matrix to 0
			for(int i=0;i<MAX_VERTS;i++)
				adjMat[j][i] = 0;
		theQueue = new Queue();
	}
	
	public void addVertex(char label){
		vertexList[nVerts++] = new Vertex(label);
	}
	
	public void addEdge(int start, int end){
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
	public void displayVertex(int v){
		System.out.println(vertexList[v].label + " " + vertexList[v].wasVisited);
	}
	
	public void bfs(){
		vertexList[0].wasVisited = true; //Marking first as true
		displayVertex(0); //Display it
		theQueue.insert(0); //Insert at tail
		
		int v2;
		
		while(!theQueue.isEmpty()){//Until Q is Empty
			int v1 = theQueue.remove(); //Removes Vertex at the head
			//Until it has no unvisited neighbours
			while((v2 = getAdjUnvisitedNeighbours(v1)) != -1){
				vertexList[v2].wasVisited = true; //Mark it 
				displayVertex(v2); //Display it
				theQueue.insert(v2); //Insert it into Q
			}
		}
		
		//Queue is Empty
		for(int j=0;j<nVerts;j++)//Reset False
			vertexList[j].wasVisited = false;
	}
	
	//Gets the unvisisted neighbours
	public int getAdjUnvisitedNeighbours(int v){
		for(int j=0;j<nVerts;j++)
			if(adjMat[v][j] == 1 && vertexList[j].wasVisited == false)
				return j;
		return -1;
	}
	
}
