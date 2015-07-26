package com.CTCI.Chapter4;

public class Question_2_Node {
	private Question_2_Node adjacent[]; // list of friends
	public int adjacentCount; // count of friends
	private String vertex; // name of current node
	public Question_2.State state; // state of current node
	
	// Constructor to initiate the new Node
	public Question_2_Node(String vertex, int adjacentLength) {
		adjacentCount = 0;
		this.vertex = vertex;
		adjacent = new Question_2_Node[adjacentLength];
	}
	
	// Adding an adjacent array, max poss = 30
	public void addAdjacent(Question_2_Node x) {
		if(adjacentCount < 30) {
			adjacent[adjacentCount] = x;
			adjacentCount++;
		}
		else {
			System.out.println("No more adjacent can be added");
		}
	}
	
	// Get the vertex 
	public String getVertex() {
		return vertex;
	}
	
	// Get the adjacent friends
	public Question_2_Node[] getAdjacent() {
		return adjacent;
	}
}
