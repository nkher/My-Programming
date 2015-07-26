package org.Java.InnerClasses;

// Program to demonstrate how inner classes (within outerclasses as variables or methods) are made in Java

// Rule : Outer class can access any private or public methods, variables of its inner class
public class OuterClass {
	
	private int x = 20;
	
	// Rule : To an inner class you can assign access modifiers like 
	// public, private, abstract, final, protected, static		  
	// Rule : Inner class can access any private or public methods, variables of its outer class
	class InnerClass {
		
		private int ans;
		//private int x; (Will access inner variables first and then outer ones)
		
		public void getValue() {
			display(); // Which will be invoked Inner Display or Outer Display ? Answer. Inner Class.
			System.out.println("Outer class value : " + x);
		}
		
		private void display() {
			//Now to call the outer display you have to do it in the following way
			OuterClass.this.display();
			System.out.println("In the Inner Class");
		}
	}
	 
	private void display() {
		System.out.println("In the Outer Class");
	}
	
	public void accessInner() {
		InnerClass ic = new InnerClass();
		ic.ans = 500;
		System.out.println("Inner class value : " + ic.ans);
	}

	public static void main(String[] args) {
		
		OuterClass outobj = new OuterClass();
		OuterClass.InnerClass inObj =  outobj.new InnerClass();
		inObj.getValue();
		
	}

}
