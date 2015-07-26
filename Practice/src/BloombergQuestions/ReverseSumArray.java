package BloombergQuestions;

public class ReverseSumArray {

	public static int[] getReverseSum(int a[], int size) {
		int output[] = new int[size];
		int i, j = 0, sum = 0;
		for(i=size-1; i>=0;i--) {
			sum += a[i];
			output[j] = sum;
			j++;
		}
		return output;
	}
	
	public static void main(String[] args) {
		
		int input[] = {2, 3, 5, 6, 6, 12, 4, 2};
		input  = getReverseSum(input, input.length);
		for(Integer i : input) {
			System.out.print(i + " ");
		}
	}

}
