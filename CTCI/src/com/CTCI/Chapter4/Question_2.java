package com.CTCI.Chapter4;

import java.util.LinkedList;

public class Question_2 {
	
	public enum State {
		Unvisited, Visited, Visiting;
	}
	
	public static void main(String[] args) {
		Question_2_Graph graph = createNewGraph();
		Question_2_Node node[] = graph.getNodes();
		Question_2_Node start = node[0];
		Question_2_Node end = node[5];
		System.out.println(search(graph, start, end));
	}
	
	public static Question_2_Graph createNewGraph() {
		Question_2_Graph graph = new Question_2_Graph();
		Question_2_Node[] temp = new Question_2_Node[6];
		
		temp[0] = new Question_2_Node("a", 3);
		temp[1] = new Question_2_Node("b", 0);
		temp[2] = new Question_2_Node("c", 0);
		temp[3] = new Question_2_Node("d", 1);
		temp[4] = new Question_2_Node("e", 1);
		temp[5] = new Question_2_Node("f", 0);
		
		temp[0].addAdjacent(temp[1]);
		temp[0].addAdjacent(temp[2]);
		temp[0].addAdjacent(temp[3]);
		temp[3].addAdjacent(temp[4]);
		temp[4].addAdjacent(temp[5]);
		
		for(int i=0;i<6;i++) {
			graph.addNode(temp[i]);
		}
		return graph;
	}
	
	// Function perform the search
	public static boolean search(Question_2_Graph g, Question_2_Node start, Question_2_Node end) {
		LinkedList<Question_2_Node> q = new LinkedList<Question_2_Node>(); // Acts like a Stack
		for (Question_2_Node node : g.getNodes()) {
			node.state = State.Unvisited;
		}
		start.state = State.Visiting;
		q.add(start);
		Question_2_Node node;
		while(!q.isEmpty()) { // Till the loop is empty
			node = q.removeFirst(); //  Remove the first one from the stack
			if(node != null) { // If the node is not null
				for (Question_2_Node v : node.getAdjacent()) { // Get all the adjacent nodes
					if(v == end) { // If it is a friend or a friend of friend then return true
						return true; // if found then return
					}
					if (v.state == State.Unvisited) {
						v.state = State.Visiting;
						q.add(v); // Add the node to the list of nodes to be checked ahead
					}
				}
			}
		}
		return false;
	}
}
