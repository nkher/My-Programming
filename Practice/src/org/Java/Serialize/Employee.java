package org.Java.Serialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Employee implements Serializable {
	
	public String name;
	public String address;
	public int number;
	public transient int SSN;
	
	public void mailCheck() {
		System.out.println("Mailing a check to " + name + " " + address);
	}
	
}
