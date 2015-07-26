package com.CTCI5.Chapter3;

import java.util.LinkedList;

public class AnimalQueue {
	
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	private int order = 0;
	
	public void enqueue(Animal a) {
		a.setOrder(order);
		order++;
		if (a instanceof Dog)
			dogs.addLast((Dog) a);
		else
			cats.addLast((Cat) a);
	}
	
	public Animal dequeueAny() {
		if (dogs.size() == 0) return dequeueCats();
		if (cats.size() == 0) return dequeueDogs();
		
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		if (dog.isOlderThan(cat))
			return dogs.poll();
		else
			return cats.poll();
	}
	
	public Animal peek() {
		if (dogs.size() == 0) return dequeueCats();
		if (cats.size() == 0) return dequeueDogs();
		
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		if (dog.isOlderThan(cat))
			return dog;
		else
			return cat;
	}
	
	public int size() {
		return dogs.size() + cats.size();
	}
	
	public Dog dequeueDogs() {
		return dogs.poll();
	}
	
	public Dog peekDogs() {
		return dogs.peek();
	}
	
	public Cat dequeueCats() {
		return cats.poll();
	}
	
	public Cat peekCats() {
		return cats.peek();
	}
	
	
	public static void main(String[] args) {

	}

}
