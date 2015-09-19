package TopCoder;

import java.awt.Point;

public class Alarmed {
	
	
	public static Noiseness noiseness = new Noiseness(Integer.MIN_VALUE);
	
	public static double noise(int[] x, int[] y, int[] threshold) {
		
		int startX = 50, startY = 50;
		return noiseHelper(x, y, threshold, noiseness, startX, startY);
	}
	
	public static double noiseHelper(int[] x, int[] y, int[] threshold, Noiseness noiseness, int currX, int currY) {
		
		if (currY == 100 && currX == 50) {
			return noiseness.get();
		}
		
		else if (currX < 0 || currX > 100 || currY < 0 || currY > 100) {
			return noiseness.get();
		}
		
		else {
		
			// calculate noise with current point and update
			System.out.println("x = " + currX + " y = " + currY);
			double currNoise = threshold[0] * Math.pow(distance(new Point(x[0], y[0]), new Point(currX, currY)), 2);
			noiseness.set(Math.max(noiseness.get(), currNoise));
			
			
			
			// Recurse on all possible paths
			noiseHelper(x, y, threshold, noiseness, currX + 1, currY);
			noiseHelper(x, y, threshold, noiseness, currX - 1, currY);
			noiseHelper(x, y, threshold, noiseness, currX, currY + 1);
			noiseHelper(x, y, threshold, noiseness, currX, currY - 1);
		}
		
		return noiseness.get();
	}
	
	public static double distance(Point a, Point b) {
		return Math.sqrt( Math.pow((b.y - a.y), 2) + Math.pow( (b.x - a.x), 2) );
	}
	
	public static void main(String[] args) {
		
		int x[] = {50};
		int y[] = {2};
		int t[] = {87};
		
		System.out.println(noise(x, y, t));		
	}

}

class Noiseness {
	double data;
	
	public Noiseness() {
		
	}
	
	public Noiseness(double d) {
		this.data = d;
	}
	
	public void set(double d) {
		this.data = d;
	}
	
	public double get() {
		return this.data;
	}
}
