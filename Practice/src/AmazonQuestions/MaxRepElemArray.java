package AmazonQuestions;

public class MaxRepElemArray {
	
	public int maxRepeatingElementArray(int[] array, int k){
		
		int result = 0;
		int i;
		
		// Iterate through the input array for 
		// Every element and increment array[array[i]%k] by k
		// This will store some calculated value by the above formula at an index i
		// This 'i' is the most frequent element in the array
		for(i=0;i<array.length;i++){
			array[array[i]%k] += k;
		}
		
//		for (int j=0;j<array.length;j++)
//			System.out.println(array[j]);
		
		// Now get the index of the element which is the largest in the modified array
		int max = array[0]; 
		for(i=1;i<array.length;i++) {
			if(max < array[i]) {
				max = array[i];
				result = i;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
	
		MaxRepElemArray object = new MaxRepElemArray();
		int[] array = {2,3,3,2,2,6,7,9,2,9,9,};
		int k = array.length;
	
		System.out.println(object.maxRepeatingElementArray(array, k));
	}

}
