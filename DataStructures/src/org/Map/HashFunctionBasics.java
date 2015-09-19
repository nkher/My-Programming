package org.Map;

public class HashFunctionBasics {

	// 1. Simple hashing for positive integers
	// Here the primeNo is the size of the hashmap
	public void basicHashFunction(int primeNo) {
		System.out.println("Indices for the hasmap would be ");
		System.out.print("[ ");
		for (int j=0;j<primeNo;j++) {
			System.out.print(j%primeNo + " ");
		}
		System.out.println(" ]");
	}
	
	// 2. Simple hashing for floating point numbers
	public void floatingHashFunction(int primeNo, float[] float_arr) {
		int M = float_arr.length;
		System.out.println("Indices for the hasmap would be ");
		System.out.print("[ ");
		for (int j=0;j<float_arr.length;j++) {
			int converted = Math.round(float_arr[j] * primeNo);
			System.out.print(converted%M + " ");
		}
		System.out.println(" ]");
	}
	
	// 3. Modular hashing for long keys like strings
	//  Here the primeNo is a small primeNumber (Java uses 31)
	public void modularHashing(String[] string_arr, int primeNo) {
		int M = primeNo;
		System.out.println("Indices for the hasmap would be ");
		System.out.print("[ ");
		for (int j=0;j<string_arr.length;j++) {
			int hash = 0;
			String curr = string_arr[j];
			for (int i=0;i<curr.length();i++) {
				hash = (primeNo * hash + curr.charAt(i)) % string_arr.length;
			}
			System.out.print(hash + " ");
		}
		System.out.println(" ]");
	}
	
	// 4. Hashing for compound keys, mix them in some way
	// phone number example
	public void compoundKeysHashValue(PhoneNumber[] numbers, int smallPrimeNo) {
		int M = numbers.length;
		System.out.print("[ ");
		for  (int i=0;i<numbers.length;i++) {
			int area = numbers[i].area();
			int exch = numbers[i].exch(), ext = numbers[i].ext();
			int hash = (((area * smallPrimeNo + exch) % M) * smallPrimeNo + ext) % M;
			System.out.print(hash + " ");
		}
		System.out.println(" ]");
	}
	
	public static void main(String[] args) {
		HashFunctionBasics hfb = new HashFunctionBasics();
		int primeNo = 31;
		hfb.basicHashFunction(primeNo);
		
		float[] float_arr = {0.1f, 0.2f, 0.3f, 0.4f, 0.5f};
		hfb.floatingHashFunction(primeNo, float_arr);
		
		String[] string_arr = {"Namesh", "Eshan", "Vikesh", "Utsav", "Amit"};
		hfb.modularHashing(string_arr, primeNo);
		
		PhoneNumber a = new PhoneNumber(609, 258, 4455);
        PhoneNumber b = new PhoneNumber(609, 876, 5309);
        PhoneNumber c = new PhoneNumber(609, 003, 5309);
        PhoneNumber d = new PhoneNumber(215, 876, 5309);
        PhoneNumber e = new PhoneNumber(609, 876, 5309);
        
        PhoneNumber numbers[] = {a, b, c, d, e};
        hfb.compoundKeysHashValue(numbers, primeNo);
        
        System.out.println(0x7fffffff);
        
        String s1 = "";
        s1.hashCode();
		
	}
}

class PhoneNumber {
	private int area; // area code 3 dig
	private int exch; // exchange 3 dig
	private int ext; // extension 4 dig
	
	public PhoneNumber(int a, int exc, int exten) {
		area = a;
		exch = exc;
		ext = exten;
	}
	
	public int area() {
		return area;
	}
	
	public int exch() {
		return exch;
	}
	
	public int ext() {
		return ext;
	}
	
	public boolean equals(PhoneNumber val) {
		if (val == this) return true;
		if (val == null) return false;
		if(val.getClass() != this.getClass()) return false;
		return (val.area == this.area) && (val.exch == this.exch) && (val.ext == this.ext);
	}
	
	public String toString() {
		return String.format("(%03d) %03d-%04d", area, exch, ext);
	}
	
	public int hashCode() {
		// here R is 31
		return 31 * (area + 31 * exch) + ext;
	}
	
}


