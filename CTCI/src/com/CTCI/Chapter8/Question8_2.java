package com.CTCI.Chapter8;

import java.awt.Point;
import java.util.ArrayList;

import org.CTCILibrary.AssortedMethods;

public class Question8_2 {
	
	public int[][] maze = new int[5][5];
	ArrayList<Point> current_path = new ArrayList<Point>();
	public boolean getPaths(int x, int y) {
		Point p = new Point(x, y);
		current_path.add(p);
		if (0 == x && 0 == y) {
			// print the path and return true
			printPath(current_path); // Means we have found a path
			//return true;
		}
		boolean success = false; // setting it to false initially
		// Start check on right
		if(x >= 1 && isFree(x-1, y)) {
			success = getPaths(x-1, y); // Free it is go right
		}
		if (!success && y >= 1 && isFree(x, y-1)) { // Try down
			success = getPaths(x, y-1);
		}
		if(!success) { // When we have printed a path this will backtrack and start removing
			current_path.remove(p);
		}
		return success;
	}
	
	public boolean isFree(int x, int y) {
		if (maze[x][y] == 0) 
			return false;
		else 
			return true;
	}
	
	public void printPath(ArrayList<Point> current_path) {
		System.out.println("Path is : ");
		for(int i=current_path.size()-1;i>=0;i--) {
			System.out.print("(" + current_path.get(i).x + "," + current_path.get(i).y + ")" + "  ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int size = 5;
		Question8_2 obj = new Question8_2();
		obj.maze = AssortedMethods.randomMatrix(size, size, 1, 5);
		AssortedMethods.printMatrix(obj.maze);
		
		// Call the get paths method
		obj.getPaths(2, 2);
	}

}
