package Sorting;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

// Sorting Arrays With Many Repeated Entries
public class Q14_8 {
	
	public void groupByAge(Person[] personArray) {
		
		HashMap<Integer, Integer> ageToCount = new HashMap<Integer, Integer>();
		LinkedList<Pair> ageToOff = new LinkedList<Pair>();
		
		/* Add to age to count */
		for (Person p : personArray) {
			if (!ageToCount.containsKey(p.age)) {
				ageToCount.put(p.age, 1);
			}
			else {
				ageToCount.put(p.age, ageToCount.get(p.age) + 1);
			}
		}
		
		/* Add to age to offset */
		int offset = 0;
		for (Integer i : ageToCount.keySet()) {
			ageToOff.add(new Pair(i, offset));
			offset += offset + ageToCount.get(i); // calculate the offset for the next iteration
		}
		
		/* The main logic for shifting */
		while (ageToOff.size() > 0 ) {
			Pair from = ageToOff.getFirst();
		}

	}
	
	public static void main(String args[]) {
		
	}
}

class Person {
	
	int age;
	String name;
	
	public Person(int a, String n) {
		age = a;
		name = n;
	}
	
	public String toString() {
		return "[" + age + ", " + name + "]";
	}
}

class Pair {
	
	int age;
	int offset;
	
	public Pair(int a, int o) {
		age = a;
		offset = o;
	}
}
