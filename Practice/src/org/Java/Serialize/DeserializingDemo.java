package org.Java.Serialize;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializingDemo {

	public static void main(String[] args) {
		Employee e1 = null;
		FileInputStream fileIn = null;
	    ObjectInputStream in = null;
	    
	    try {
	    	fileIn = new FileInputStream("serialized-output/employee.ser");
	    	in = new ObjectInputStream(fileIn);
	    	e1 = (Employee) in.readObject();
	    }
	    catch(IOException io) {
	    	io.printStackTrace();
	    	return;
	    }
	    catch (ClassNotFoundException e) {
			System.out.println("Class not found");
			e.printStackTrace();
			return;
		}
	    finally {
	    	try {
	    		fileIn.close();
	    		in.close();
	    	}
	    	catch (IOException e) {
				e.printStackTrace();
			}
	    }
	    System.out.println("Deserialized Employee...");
	    System.out.println("Name: " + e1.name);
	    System.out.println("Address: " + e1.address);
	    System.out.println("SSN: " + e1.SSN);
	    System.out.println("Number: " + e1.number);
	}

}
