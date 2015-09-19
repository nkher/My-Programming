package bitManipulation;

import java.text.DecimalFormat;

import com.sun.xml.internal.fastinfoset.algorithm.HexadecimalEncodingAlgorithm;

public class BitSet {
	
	static int []bitSet;
	
	public BitSet(int size) {
		bitSet = new int[size >> 5]; // divide by 32
	}
	
	public static boolean get(int pos) {
		System.out.println("-------- start -------------");
		System.out.println("Pos -- > " + pos);
		int wordNumber = (pos >> 5); // divide by 32
		System.out.println("Word Number " + wordNumber);
		int bitNumber = (pos & 0x1F); // mod 32
		System.out.println("Bit Number " + bitNumber);
		System.out.println("getter " + (bitSet[wordNumber] & (1 << bitNumber)));
		System.out.println("----------- end --------------");
		return (bitSet[wordNumber] & (1 << bitNumber)) != 0;
	}
	
	public static void set(int pos) {
		int wordNumber = (pos >> 5); // divide by 32
		int bitNumber = (pos & 0x1F); // mod 32
		//System.out.println("Word Number " + wordNumber);
		//System.out.println("Bit Number " + bitNumber);
		System.out.println("storage " + (bitSet[wordNumber] | (1 << bitNumber)));
		bitSet[wordNumber] |= (1 << bitNumber);
		//System.out.println(bitSet[wordNumber]);
	}
	
	public static void checkDuplicates(int array[]) {
		BitSet bs = new BitSet(32000);
		for (int i=0; i<array.length; i++) {
			int num = array[i]; 
			int num0 = num -1; // bitset starts at 0, numbers start at 1
			if(bs.get(num0))
				System.out.println(num);
			else
				bs.set(num0);
		}		
	}

	public static void main(String[] args) {
		
		//int i = 0b10000110010; // This will give the output in decimal format
		int array[] = {1,2,3,4,2,3,4,6,87,56,87};
//		checkDuplicates(array);
//		get(2);
		
		 byte term1=(byte)0x0a,term2=(byte)0x80;
		 while (term1 >0 && term2 > 0) {
		 }
		 int i = (int)term1;
		 int i2 = (int)term2;
		 System.out.println(term1 + " " + i);
		 System.out.println(Integer.toBinaryString(i));
		 System.out.println(Integer.toHexString(i2));
		 String s = "";
	}

}
