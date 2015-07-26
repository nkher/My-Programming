package org.Java.InnerClasses;

// Static inner classes example
class OuterClass4 {
	int rel = 500;
	
	static class InnerClass {
		public void display() {
			System.out.println("Inner Class");
		}
	}
}

public class Main2 {

	public static void main(String[] args) {
		OuterClass4.InnerClass obj = new OuterClass4.InnerClass();
		obj.display();
	}

}
