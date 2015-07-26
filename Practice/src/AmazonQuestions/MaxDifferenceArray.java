package AmazonQuestions;

public class MaxDifferenceArray {

	public int getMaxDifferenceArray(int array[]){
		
		int i,minValue = array[0], maxValue = array[0];
		for(i=1;i<array.length;i++){
			if(minValue>array[i])
				minValue = array[i];
			if(maxValue<array[i])
				maxValue=array[i];
		}
		return maxValue-minValue;
	}
	
	
	public static void main(String[] args) {
		
		MaxDifferenceArray object = new MaxDifferenceArray();
		
		int arr[] = {3,-2,10};
		System.out.println(object.getMaxDifferenceArray(arr));

	}

}
