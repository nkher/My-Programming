package javaReflection;

public class Animal {
	
	private String name;
	private String color;
	private String species;
	
	public Animal(String name, String color, String species) {
		this.name = name;
		this.color = color;
		this.species = species;
	}
	
	public Animal() {}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public String getSpecies() {
		return species;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setSpecies(String species) {
		this.species = species;
	}
	
}
