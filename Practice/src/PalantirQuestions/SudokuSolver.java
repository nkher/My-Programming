package PalantirQuestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {
	
	private static final int N = 9;
	private static final int UNASSIGNED = -1;
	
	private HashMap<String, Integer> quadChecker = new HashMap<String, Integer>();
	private Set<GridPoint> quad1 = new HashSet<GridPoint>();
	private Set<GridPoint> quad2 = new HashSet<GridPoint>();
	private Set<GridPoint> quad3 = new HashSet<GridPoint>();
	private Set<GridPoint> quad4 = new HashSet<GridPoint>();
	private Set<GridPoint> quad5 = new HashSet<GridPoint>();
	private Set<GridPoint> quad6 = new HashSet<GridPoint>();
	private Set<GridPoint> quad7 = new HashSet<GridPoint>();
	private Set<GridPoint> quad8 = new HashSet<GridPoint>();
	private Set<GridPoint> quad9 = new HashSet<GridPoint>();

	
	public boolean sudokuSolver(int grid[][]) {
		// first find an unassigned location from the grid
		GridPoint gridPoint = getUnAssignedLocation(grid);
		if (gridPoint == null) {
			return true;
		}
		
		// now check for safe point
		for (int num=1;num<=N;num++) {
						
			// check if the position is safe
			if (isSafe(gridPoint, grid, num)) {
				
				// now we know it is safe
				// assign the number to the location and recurse from there
				grid[gridPoint.row][gridPoint.col] = num;
				
				if (sudokuSolver(grid))
					return true;
				
				grid[gridPoint.row][gridPoint.col] = UNASSIGNED;
			}
		}
		return false;
	}
	
	public GridPoint getUnAssignedLocation(int grid[][]) {
		for (int i=0;i<grid.length;i++) {
			for (int j=0;j<grid[i].length;j++) {
				if (grid[i][j] == UNASSIGNED) {
					return (new GridPoint(i, j));
				}
			}
		}
		return null;
	}
	
	public boolean isSafe(GridPoint gridPoint, int grid[][], int num) {
		// check for row
		if (checkRow(gridPoint, grid, num) && 
				checkCol(gridPoint, grid, num) &&
						checkQuadrant(gridPoint, grid, num)) {
					return true;
				}
		return false;
	}
	
	public boolean checkRow(GridPoint gridPoint, int grid[][], int num) {
		for (int i=0;i<N;i++) {
			if (grid[gridPoint.row][i] == num)
				return false;
		}
		return true;
	}
	
	public boolean checkCol(GridPoint gridPoint, int grid[][], int num) {
		for (int i=0;i<N;i++) {
			if (grid[i][gridPoint.col] == num)
				return false;
		}
		return true;
	}
	
	public boolean checkQuadrant(GridPoint gridPoint, int grid[][], int num) {
		fillQuadrantSetsAndMap();
		int quadNumber = quadChecker.get(gridPoint.row + "" + gridPoint.col);
		if (quadNumber == 1) {
			for ( GridPoint gp : quad1 ) {
				if (grid[gp.row][gp.col] == num) return false;
			}
			return true;
		}
		else if (quadNumber == 2) {
			for ( GridPoint gp : quad2 ) {
				if (grid[gp.row][gp.col] == num) return false;
			}
			return true;
		}
		else if (quadNumber == 3) {
			for ( GridPoint gp : quad3 ) {
				if (grid[gp.row][gp.col] == num) return false;
			}
			return true;
		}
		else if (quadNumber == 4) {
			for ( GridPoint gp : quad4 ) {
				if (grid[gp.row][gp.col] == num) return false;
			}
			return true;
		}
		else if (quadNumber == 5) {
			for ( GridPoint gp : quad5 ) {
				if (grid[gp.row][gp.col] == num) return false;
			}
			return true;
		}
		else if (quadNumber == 6) {
			for ( GridPoint gp : quad6 ) {
				if (grid[gp.row][gp.col] == num) return false;
			}
			return true;
		}
		else if (quadNumber == 7) {
			for ( GridPoint gp : quad7 ) {
				if (grid[gp.row][gp.col] == num) return false;
			}
			return true;
		}
		else if (quadNumber == 8) {
			for ( GridPoint gp : quad8 ) {
				if (grid[gp.row][gp.col] == num) return false;
			}
			return true;
		}
		else {
			for ( GridPoint gp : quad9 ) {
				if (grid[gp.row][gp.col] == num) return false;
			}
			return true;
		}
	}
	
	
	public void fillQuadrantSetsAndMap() {
		String toPut = null;
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				if (i <= 2) {
					toPut = i + "" + j;
					if (j <= 2) {
						quadChecker.put(toPut, 1);
						quad1.add(new GridPoint(i, j));
					}
					else if (j > 2 && j <= 5) {
						quadChecker.put(toPut, 2);
						quad2.add(new GridPoint(i, j));
					}
					else {
						quadChecker.put(toPut, 3);
						quad3.add(new GridPoint(i, j));
					}
				}
				else if (i > 2 && i <= 5) {
					toPut = i + "" + j;
					if (j <= 2) {
						quadChecker.put(toPut, 4);
						quad4.add(new GridPoint(i, j));
					}
					else if (j > 2 && j <= 5) {
						quadChecker.put(toPut, 5);
						quad5.add(new GridPoint(i, j));
					}
					else {
						quadChecker.put(toPut, 6);
						quad6.add(new GridPoint(i, j));
					}	
				}
				else {
					toPut = i + "" + j;
					if (j <= 2) {
						quadChecker.put(toPut, 7);
						quad7.add(new GridPoint(i, j));
					}
					else if (j > 2 && j <= 5) {
						quadChecker.put(toPut, 8);
						quad8.add(new GridPoint(i, j));
					}
					else {
						quadChecker.put(toPut, 9);
						quad9.add(new GridPoint(i, j));
					}	
				}
			}
		}
	}
	
	public void printGrid(int grid[][]) {
		for (int i=0;i<grid.length;i++) {
			System.out.print("[");
			for (int j=0;j<grid[i].length;j++) {
				System.out.print(" " + grid[i][j] + " ");
			}
			System.out.print("]\n");
		}
	}
	
	public static void main(String[] args) {
//		int sudokuGrid[][] = 
//			{ 	{-1,-1,-1,2,6,-1,7,-1,1},
//				{6,8,-1,-1,7,-1,-1,9,-1},
//				{1,9,-1,-1,-1,4,5,-1,-1},
//				{8,2,-1,1,-1,-1,-1,4,-1},
//				{-1,-1,4,6,-1,2,9,-1,-1},
//				{-1,5,-1,-1,-1,3,-1,2,8},
//				{-1,-1,9,3,-1,-1,-1,7,4},
//				{-1,4,-1,-1,5,-1,-1,3,6},
//				{7,-1,3,-1,1,8,-1,-1,-1},
//				};
		
		int sudokuGrid[][] = 
			{ 	{5,-1,-1,-1,8,-1,-1,4,6},
				{-1,-1,-1,-1,-1,4,-1,-1,2},
				{-1,-1,6,1,9,-1,-1,-1,-1},
				{-1,-1,5,-1,-1,2,-1,8,-1},
				{9,-1,1,-1,-1,-1,2,-1,3},
				{-1,8,-1,4,-1,-1,6,-1,-1},
				{-1,-1,-1,-1,2,3,8,-1,-1},
				{6,-1,-1,9,-1,-1,-1,-1,-1},
				{2,7,-1,-1,5,-1,-1,-1,9},
				};
		
		SudokuSolver ss = new SudokuSolver();
		ss.printGrid(sudokuGrid);
		System.out.println();
		
		if (ss.sudokuSolver(sudokuGrid)) {
			System.out.println("Solved");
		}
		else {
			System.out.println("Not Solved");
		}
		
		System.out.println();
		ss.printGrid(sudokuGrid);
	}
}

class GridPoint {
	int row;
	int col;
	
	public GridPoint(int a, int b) {
		row = a;
		col = b;
	}
}

