package BloombergQuestions;

public class PrintPrimes {
	// Sieve of Eratosthenes
	// Print all the prime number before or equal to 'n'
	
	private boolean[] array;
	
	private boolean[] markMultiples(boolean arr[], int a, int number) {
		int i=2, num;
		while( (num = a*i) <= number ) {
			arr[ num -1 ] = true;
			++i;
		}
		return arr;
	}
	
	public void SieveOfEratosthenes(int number) {
		if(number >= 2) {
			// create an array of size number
			array = new boolean[number];
			for (int i=0;i<array.length;i++) {
				this.array[i] = false;
			}
			
			/* Following property is maintained in the below for loop
	           arr[i] == 0 means i + 1 is prime
	           arr[i] == 1 means i + 1 is not prime */
			for (int i=1;i<number;i++) {
				if (array[i] == false) {
					// (i+1) is a prime
					System.out.print(i+1 + ", ");
					array = markMultiples(array, i+1, number);
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		int number = 40;
		PrintPrimes object = new PrintPrimes();
		object.SieveOfEratosthenes(number);
	}

}
