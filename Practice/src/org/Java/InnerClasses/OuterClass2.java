package org.Java.InnerClasses;

//Program to demonstrate how inner classes (within methods of outerclasses) are made in Java
public class OuterClass2 {
	
	private int x = 20;
	
	public void innerClassMtd() {
		int rel = 500;
		
		// Only final and abstract
		class InnerClass2 {
			private int ans;
			public void getValue() {
				System.out.println("Outer class value : " + x);
				// Very important rule -  This inner class cannot access the local variables of the method.
				// In this case this inner class cannot access the variable 'rel'
				// 'rel' will be placed in the stack as it is a local variable
				// If we make this 'rel' as final then it can be accessible
			} 
		}
		
		new InnerClass2().getValue();
	}
	
	public static void main(String[] args) {
		
		OuterClass2 out2obj = new OuterClass2();
		out2obj.innerClassMtd();
	}

}
