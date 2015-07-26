package PalantirQuestions;

public class UniqueNumber2Arrays {

	public static void main(String[] args) {
		int a[] = {1,5,8,9,2,13};
		int b[] = {5,8,9,1,2};
		
		int result=a[0]^b[0];
//		for (int i=1;i<a.length;i++)
//			result ^= a[i];
//		
//		for (int i=0;i<b.length;i++) {
//			result ^= b[i];
//		}
		
		// Looping over the bigger array only
		int len1 = a.length, len2 = b.length;
		int len = Math.max(len1, len2); 
		for (int j=1;j<len;j++) {
			if (j < len1)
				result ^= a[j];
			if (j < len2)
				result ^= b[j];
		}
		
		System.out.println("Unique number from both the arrays is : " + result);
	}

}
