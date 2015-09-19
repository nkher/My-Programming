package org.bst.tester;

public class Customer {
	
	private String customerName;
	private int customerId;
	private double customerBalance;
	
	public Customer() {}
	
	public Customer(String customerName, int customerId, double customerBalance) {
		this.customerBalance = customerBalance;
		this.customerId = customerId;
		this.customerName = customerName;
	}
	
	public String getcustomerName() {
		return customerName;
	}
	
	public double getcustomerBalance() {
		return customerBalance;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public void setcustomerName(String name) {
		customerName = name;
	}
	
	public void setcustomerBalance(double balance) {
		customerBalance = balance;
	}
	
	public void setcustomerId(int Id) {
		customerId = Id;
	}
}
