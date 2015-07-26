package PalantirQuestions;

public class AddVeryLargeNumbers {
	
	public String add(String bigInt1, String bigInt2) {
		int len1 = findIStringLength(bigInt1);
		int len2 = findIStringLength(bigInt2);
		int[] a1 = new int[len1];
		int[] a2 = new int[len2];
		// Getitng the integer array
		a1 = getIntegerArray(bigInt1, a1);
		a2 = getIntegerArray(bigInt2, a2);
		
		// call the sum array function
		return sumArray(a1, a2, len1, len2);
	}
	
	public String sumArray(int a1[], int a2[], int len1, int len2) {
		int carry = 0;
		int sumArray[] = new int[a1.length+1];
		int biggerLen = 0;
		int value1, value2;
		biggerLen = len1 > len2 ? len1 : len2;
		// Sum both the arrays
		for (int i=0;i<biggerLen;i++) {
			value1 = i < len1 ? a1[i] : 0;
			value2 = i < len2 ? a2[i] : 0;
			// main 2 lines
			sumArray[i] = (value1 + value2 + carry) % 10;
			carry = (value1 + value2 + carry) / 10;
		}
		sumArray[biggerLen] = carry;
		return arrayToString(sumArray);
	}
	
	public String arrayToString(int sumArray[]) {
		String sum = "";
		boolean firstNonZero = false;
		for (int i=sumArray.length-1;i>=0;i--) {
			if(!firstNonZero && (sumArray[i] == 0))
				continue;
			else
				firstNonZero = true;
			sum += sumArray[i];
		}
		String numStr = sum.length() == 0? "0" : sum;
		return numStr;
	}
	
	public int[] getIntegerArray(String s, int[] a) {
		for (int i=0;i<s.length();i++) {
			a[i] = Integer.parseInt(s.substring(i, i+1));
		}
		return a;
	}
	
	public int findIStringLength(String integerString) { 
		return integerString.toCharArray().length;
	}
	
	public int findIntLength(int integer) { 
		return Integer.toString(integer).length();
	}
	
	public String multiply(String bigInt1, String bigInt2) {
		int len1 = findIStringLength(bigInt1);
		int len2 = findIStringLength(bigInt2);
		int[] a1 = new int[len1];
		int[] a2 = new int[len2];
		// Getitng the integer array
		a1 = getIntegerArray(bigInt1, a1);
		a2 = getIntegerArray(bigInt2, a2);
		return product(a1, a2, len1, len2);
	}
	
	private String product(int a1[], int a2[], int len1, int len2) {
		int productArray[] = new int[len1+len2];
		
		for (int i=0;i<len1;i++) {
			for (int j=0;j<len2;j++) {
				
				int prod = a1[i] * a2[j];
				int prodLength = findIntLength(prod);
				int prodAsArray[] = intToArray(prod, prodLength);
				
				for (int k=0;k<prodAsArray.length;k++) {
					
					productArray[i+j+k] += prodAsArray[k];
					
					// Handle carry
					int curr = productArray[i+j+k];
					if (curr > 9) {
						productArray[i+j+k] = 0;
						int curValLength = findIntLength(curr);
						int curValAsArray[] = intToArray(curr, curValLength);
						for (int l=0;l<curValAsArray.length;l++)
							productArray[i+j+k+l] += curValAsArray[l];
					}
				}
			}
		}
		return arrayToString(productArray);
	}
	
	public int[] intToArray(int bigInt, int len) {
		int a[] = new int[len-1];
		for (int i=0;i<len-1;i++) {
			a[i] = i < len ? getDigAtIndex(bigInt, len-i-1) : 0;
		}
		return a;
	}
	
	public int getDigAtIndex(int longint, int index) {
		return Integer.parseInt(Integer.toString(longint).substring(index, index+1));
	}
	
	public static void main(String[] args) {
		AddVeryLargeNumbers obj = new AddVeryLargeNumbers();
		String bigInt1 = "1111111111111111";
		String bigInt2 = "9999999999999999";
		System.out.println("Answer is : " + obj.add(bigInt1, bigInt2));
		
		System.out.println("Multiplication is : " + obj.multiply(bigInt1, bigInt2));
	}

}
