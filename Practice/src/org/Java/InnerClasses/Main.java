package org.Java.InnerClasses;

//Program to demonstrate how inner classes (Anonymous class) are made in Java
class OuterClass3 {
	public void display() {
		System.out.println("outer class");
	}
}

class InnerClass {
	OuterClass3 out3obj = new OuterClass3();
	public void display() {
		System.out.println("Anonymous class");
	}
}

public class Main {
	public static void main(String[] args) {
		InnerClass innobj = new InnerClass();
		innobj.out3obj.display(); // Here the OuterClass3's object created acts as a local variable
		// There fore the outerclass's display is called
		innobj.display(); // Inner classes display is called
	}
}
