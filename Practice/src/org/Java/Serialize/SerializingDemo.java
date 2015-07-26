package org.Java.Serialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializingDemo {

	public static void main(String[] args) {
		
		Employee e1 =  new Employee();
		e1.name = "Reyan Ali";
	    e1.address = "Phokka Kuan, Ambehta Peer";
	    e1.SSN = 11122333;
	    e1.number = 101;
	    
	    FileOutputStream fileOut = null;
	    ObjectOutputStream out = null;
	    
	    try {
	    	fileOut =  new FileOutputStream("serialized-output/employee.ser");
	    	out = new ObjectOutputStream(fileOut);
	    	out.writeObject(e1);
	    	System.out.println("Serialized data is saved in 'serialized-output/employee.ser'");
	    }
	    catch(IOException io) {
	    	io.printStackTrace();
	    }
	    finally {
	    	try {
				out.close();
				fileOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	}

}
