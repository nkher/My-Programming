package javaReflection;

import javaReflection.Animal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Reflection {

	public static void main(String[] args) {
		try {
			Class animal = Class.forName("javaReflection.Animal");
			Method methods[] = animal.getDeclaredMethods();
			for (int i=0;i<methods.length;i++) {
				System.out.println(methods[i]);
			}
			Constructor[] constructors = animal.getDeclaredConstructors();
			for (int i=0;i<constructors.length;i++) {
				System.out.println(constructors[i]);
			}
		}
		catch(ClassNotFoundException cnfe) {
			System.out.print("Given Class is not found.");
		}
		catch (Throwable t) {
			System.err.println(t);
		}
	}

}
