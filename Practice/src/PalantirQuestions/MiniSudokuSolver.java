package PalantirQuestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class MiniSudokuSolver {
	
	private static final int N = 4;
	private static final int UNASSIGNED = -1;
	private HashMap<String, Integer> quadCheck = new HashMap<String, Integer>();
	private Set<GridLocation> quadrant1 = new HashSet<GridLocation>();
	private Set<GridLocation> quadrant2 = new HashSet<GridLocation>();
	private Set<GridLocation> quadrant3 = new HashSet<GridLocation>();
	private Set<GridLocation> quadrant4 = new HashSet<GridLocation>();
	
	
	public boolean solveSudoku(int grid[][]) {
		GridLocation gl = getUnAssignedLocation(grid);
		if (gl == null)  {
			return true;
		}
		
		// Now try numbers from 1 to 4 in the empty location
		for (int num = 1;num<=N;num++) {
			
			// Check if the number if safe for that position
			if (isSafe(gl, grid, num)) {
				
				// Means it is safe. Now put the number at the position
				grid[gl.row][gl.col] = num;
				
				// Here is the main concept. Once you assign a number to a position
				// Recurse from that point as when backtracking it would come to the same point again
				// The stack frame would allow us to back track
				if ( solveSudoku(grid) )
					return true;
				
				grid[gl.row][gl.col] = UNASSIGNED;
			}
		}
		return false;
	}
	
	public GridLocation getUnAssignedLocation(int grid[][]) {
		for (int i=0;i<grid.length;i++) {
			for (int j=0;j<grid[i].length;j++) {
				if (grid[i][j] == UNASSIGNED)
					return new GridLocation(i, j);
			}
		}
		return null;
	}
	
	public boolean isSafe(GridLocation gridLoc, int grid[][], int num) {
		if (checkRow(gridLoc, grid, num) && 
				checkCol(gridLoc, grid, num) && 
				identifyAndCheckQuadrant(gridLoc, grid, num)) {
			return true;
		}
		else
			return false;
	}
	
	public boolean checkRow(GridLocation gridLoc, int grid[][], int num) {
		for (int i=0;i<N;i++) {
			if (grid[gridLoc.row][i] == num) return false;
		}
		return true;
	}
	
	public boolean checkCol(GridLocation gridLoc, int grid[][], int num) {
		for (int i=0;i<N;i++) {
			if (grid[i][gridLoc.col] == num) return false;
		}
		return true;
	}
	
	public boolean identifyAndCheckQuadrant(GridLocation gridLoc, int grid[][], int num) {
		fillQuadrantMaps(grid);
		int number = quadCheck.get(gridLoc.row + "" + gridLoc.col);
		
		if (number == 1) {
			return checkQuad((HashSet<GridLocation>) quadrant1, grid, num);
		}
		else if (number == 2) {
			return checkQuad((HashSet<GridLocation>) quadrant2, grid, num);
		}
		else if (number == 3) {
			return checkQuad((HashSet<GridLocation>) quadrant3, grid, num);
		}
		else {
			return checkQuad((HashSet<GridLocation>) quadrant4, grid, num);
		}
	}
	
	public boolean checkQuad(HashSet<GridLocation> quadrant, int grid[][], int num) {
		for (GridLocation gl : quadrant) {
			if (grid[gl.row][gl.col] == num)
				return false;
		}
		return true;
	}
	
	public void fillQuadrantMaps(int grid[][]) {
		for (int i=0;i<grid.length;i++) {
			for (int j=0;j<grid[i].length;j++) {
				if (i <= 1) {
					if (j <= 1) {
						String toPut = i + "" + j;
						quadCheck.put(toPut, 1);
					}
					else {
						String toPut = i + "" + j;
						quadCheck.put(toPut, 2);
					}
				}
				else {
					if (j <= 1) {
						String toPut = i + "" + j;
						quadCheck.put(toPut, 3);
					}
					else {
						String toPut = i + "" + j;
						quadCheck.put(toPut, 4);
					}
				}
			}
		}
		quadrant1.add(new GridLocation(0, 0));
		quadrant1.add(new GridLocation(0, 1));
		quadrant1.add(new GridLocation(1, 0));
		quadrant1.add(new GridLocation(1, 1));
		
		quadrant2.add(new GridLocation(0, 2));
		quadrant2.add(new GridLocation(0, 3));
		quadrant2.add(new GridLocation(1, 2));
		quadrant2.add(new GridLocation(1, 3));
		
		quadrant3.add(new GridLocation(2, 0));
		quadrant3.add(new GridLocation(2, 1));
		quadrant3.add(new GridLocation(3, 0));
		quadrant3.add(new GridLocation(3, 1));
		
		quadrant4.add(new GridLocation(2, 2));
		quadrant4.add(new GridLocation(2, 3));
		quadrant4.add(new GridLocation(3, 2));
		quadrant4.add(new GridLocation(3, 3));
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
	
	public static void main(String args[]) {
		
		MiniSudokuSolver ss = new MiniSudokuSolver();
		
		// -1 indicates unassigned nodes
		int sudokuGrid[][] = {{-1, 2, -1, 1},
							  {1, -1, -1, 4},
							  {-1, 4, -1, 3},
							  {3, -1, 4, -1}};
		
		ss.printGrid(sudokuGrid);
		
		System.out.println();
				
		if (ss.solveSudoku(sudokuGrid)) {
			System.out.println("Sudoku Solved\n");
		}
		else 
			System.out.println("Remains Unsolved\n");
		
		ss.printGrid(sudokuGrid);
	}
	
	// 00 01 02 03
	// 10 11 12 13
	// 20 21 22 23
	// 30 31 32 33
}

class GridLocation {
	int row;
	int col;
	public GridLocation(int x, int y) {
		this.row = x;
		this.col = y;
	}
}
