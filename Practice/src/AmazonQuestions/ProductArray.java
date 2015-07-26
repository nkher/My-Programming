package AmazonQuestions;

public class ProductArray {

	public int[] getProductArray(int[] arr, int n){
		
		int left[] = new int[n];
		int right[] = new int[n];
		int prodArray[] = new int[n];
		int i, j;
		
		left[0] = 1; right[n-1] = 1;
		
		// Calculating the values of left
		for(i=1; i<n; i++)
			left[i] = left[i-1] * arr[i-1];
		for(int m=0;i<left.length;m++)
			System.out.print(left[m] + " ");
		
		// Calculating the values of right
		for(j=n-2; j>=0; j--)
			right[j] = right[j+1] * arr[j+1];
		for(int m=0;i<right.length;m++)
			System.out.print(right[m] + " ");
		
		// Now taking the product of left and right to get the product
		for(i=0; i<n;i++)
			prodArray[i] = left[i]*right[i];
		
		return prodArray;
	}
	
 	public static void main(String[] args) {
		
		ProductArray object = new ProductArray();
		int arr[] = {1,2,3,4};
		
		int prodArray[] = object.getProductArray(arr, arr.length);
		
		for(int i=0;i<prodArray.length;i++)
			System.out.print(prodArray[i] + " ");
	}

}
