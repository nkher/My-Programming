package HonorsClass;

import java.util.ArrayList;

import Library.TrafficElement;
import StacksAndQueues.Q9_12;

public class Q22_14 {
	
	public static ArrayList<TrafficElement> calculateTrafficVolumes(TrafficElement[] a, int w) {
		
		Q9_12<TrafficElement> slidingWindow = new Q9_12<TrafficElement>();
		ArrayList<TrafficElement> maxVolumes = new ArrayList<TrafficElement>();
		for (TrafficElement te : a) {
			
			slidingWindow.enqueue(te);
			while ( (te.time - slidingWindow.peek().time) > w) {
				slidingWindow.dequeue();
			}
			System.out.println(slidingWindow.max().volume);
			maxVolumes.add(new TrafficElement(te.time, slidingWindow.max().volume));
		}
		
		return maxVolumes;
	}
	
	public static void main(String[] args) {
		
		TrafficElement[] a = { new TrafficElement(0, 1.3), new TrafficElement(1, 0), new TrafficElement(2, 2.5), new TrafficElement(3, 3.7),
						new TrafficElement(4, 0), new TrafficElement(5, 1.4), new TrafficElement(6, 2.6), new TrafficElement(7, 0),
						new TrafficElement(8, 2.2), new TrafficElement(9, 1.7), new TrafficElement(10, 0), new TrafficElement(11, 0),
						new TrafficElement(12, 0), new TrafficElement(13, 0), new TrafficElement(14, 1.7)};
		
		System.out.println(calculateTrafficVolumes(a, 3).toString());
	}	
}

