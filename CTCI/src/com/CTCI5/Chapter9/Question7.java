package com.CTCI5.Chapter9;

public class Question7 {
	
	public enum Color {
		Black, White, Red, Yellow, Green;
	}
	
	public static String printColor(Color c) {
		switch(c) {
			case Black :
				return "B";
			case White :
				return "W";
			case Red :
				return "R";
			case Yellow :
				return "Y";
			case Green :
				return "G";
		}
		return "X";
	}
	
	public static void printScreen(Color[][] screen) {
		for (int i=0;i<screen.length;i++) {
			for (int j=0;j<screen[i].length;j++) {
				System.out.print(printColor(screen[i][j]) + " ");
			}
			System.out.println();
		}
	}
	
	public static boolean paintFill(Color screen[][], int x, int y, Color ncolor) {
		if (screen[x][y] == ncolor) return false;
		return paintFillColor(screen, x, y, screen[y][x], ncolor);
	}
	
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}
	
	public static boolean paintFillColor(Color[][] screen, int x, int y, Color ocolor, Color ncolor) {
		if (x < 0 || x >= screen[0].length || y < 0 || y >= screen.length) 
			return false;
		if (screen[y][x] == ocolor) {
			screen[y][x] = ncolor;
			paintFillColor(screen, x-1, y, ocolor, ncolor);
			paintFillColor(screen, x+1, y, ocolor, ncolor);
			paintFillColor(screen, x, y-1, ocolor, ncolor);
			paintFillColor(screen, x, y+1, ocolor, ncolor);
		}
		return true;
	}
	
	public static void main(String[] args) {
		int N = 10;
		Color screen[][] = new Color[N][N];
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				screen[i][j] = Color.Black;
			}
		}
		
		for (int i = 0; i < 100; i++) {
			screen[randomInt(N)][randomInt(N)] = Color.Green;
		}
		
		printScreen(screen);
		paintFill(screen, 9, 9, Color.Red);
		System.out.println();
		printScreen(screen);
	}
}
