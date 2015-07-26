package com.CTCI5.Chapter9;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

import org.CTCILibrary.AssortedMethods;

public class Question2_DynamicProgramming {

	static int maze[][] = new int[10][10];
	ArrayList<Point> path = new ArrayList<Point>();
	
	public static boolean isfree(int x, int y) {
		if (maze[x][y] == 0)
			return false;
		else
			return true;
	}
	
	
	// T.C -> O(X * Y) time as we hit each cell only once
	public static boolean getPaths(int x, int y, HashMap<Point, Boolean> cache, ArrayList<Point> path) {
		
		if (x < 0 || y < 0 || !isfree(x, y))
			return false;
		
		Point p = new Point(x, y);
		if(cache.containsKey(p)) { // means already visited
			return cache.get(p);
		}
		
		boolean isAtOrigin = (x == 0) && (y == 0);
		boolean success = false;
		
		if (isAtOrigin) {
			System.out.print("Path is \t : ");
			String s = AssortedMethods.listOfPointsToString(path);
			System.out.println(s);
		}
		
		// If there's a path from the start to my current location, add my location.
		if (isAtOrigin || getPaths(x-1, y, cache, path) || getPaths(x, y-1, cache, path)) {
			path.add(p);
			success = true;
		}
		
		cache.put(p, success);
		System.out.println("Path is : " + path.toString());
		return success;
	}
	
	public static void main(String[] args) {
		int size = 5;
		maze = AssortedMethods.randomMatrix(size, size, 0, 3);
		AssortedMethods.printMatrix(maze);
		
		ArrayList<Point> path = new ArrayList<Point>();
		HashMap<Point, Boolean> cache = new HashMap<Point, Boolean>();
		boolean success = getPaths(size-1, size-1, cache, path);
		
		if (success) {
			String s = AssortedMethods.listOfPointsToString(path);
			System.out.println(s);
		}
		else
			System.out.println("No Path found");
	}

}
