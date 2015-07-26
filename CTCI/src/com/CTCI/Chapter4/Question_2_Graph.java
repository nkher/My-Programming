package com.CTCI.Chapter4;

public class Question_2_Graph {
	private Question_2_Node vertices[];
	public int count;
	
	public Question_2_Graph() {
		vertices = new Question_2_Node[6];
		count = 0;
	}
	
	public void addNode(Question_2_Node x) {
		if(count < 30) {
			vertices[count] = x;
			count++;
		}
		else {
			System.out.print("Graph full");
		}
	}
	
	public Question_2_Node[] getNodes() {
		return vertices;
	}
}
