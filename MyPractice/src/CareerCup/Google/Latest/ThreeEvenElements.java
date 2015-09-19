package CareerCup.Google.Latest;

public class ThreeEvenElements {
	
	// Read this properly
	public static void evenElem(int a[]) {
		
		int n = a.length;
		int tracker = 0;
		
		for (int i=0; i<n; i++) {
			int shift = 1 << a[i];
			tracker ^= shift;
		}
		
		for (int i=0; i<n; i++) {
			int shift = 1 << a[i];
			if ((shift & tracker) == 0) {
				tracker ^= shift;
				System.out.println(a[i]);
			}
		}
	}
	
	public static void getEvenDuplicates()
	{
		int number[]= {1,1,1,5,5,4,4,6,6,6,6,3,3,3,6,6};
		int len = number.length;
		int tracker=0;

		for(int i=0; i< len; ++i)
		{		
			int shifted = 1 << number[i];
			tracker ^= shifted;
			System.out.println("Shifted : " + shifted + " " + "Tracker : " + tracker);
		}
		
		System.out.println("\n\n");
		for(int i=0; i< len; ++i)
		{
			int shifted = 1<< number[i];
			if((shifted & tracker) ==  0) 
			{
				tracker ^= shifted; // to avoid repeated printing of the number
				System.out.println("Shifted : " + shifted + " " + "Tracker : " + tracker);
				System.out.println(number[i]);
			}
		}
	}
	
	public static void main(String[] args) {
		
		//int a[] = {1,6,4,1,4,5,8,8,4,6,8,8,9,7,9,5,9}; 
		
		int a[] = {1,1,1,5,5,4,4,6,6,3,3,3,6,6};
		//evenElem(a);
		
		//getEvenDuplicates();
		
		int b[] = {315,315,315,32,32,42,42,55,55,55,3900,3900};
		evenElem(b);
		
	}
}
