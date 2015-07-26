package MicrosoftQuestions;

public class ShowArrayWithoutDuplicates {

	public int[] getWithoutDuplicates(int arr[], int n){
		
		if(n<2){
			System.out.println("Array Size is One !"); 
			return arr;
		}
		
		int storeIndex=1, i=1;
		while(i<n){
			if(arr[i] != arr[i-1]){
				arr[storeIndex] = arr[i];
				storeIndex++;
				i++;
			}
			else if(arr[i] == arr[i-1])
				i++;
		}
		System.out.println("Store Index is : " + storeIndex);
		for(int j=storeIndex;j<n;j++)
			arr[j] = '\0';
		
		return arr;
	}
	
	public static void main(String[] args) {

		int arr[] = {1,2,2,3,3,4,4,4,5,7,7,7,7,7,8,9,9,10,58, 58};
		ShowArrayWithoutDuplicates object = new ShowArrayWithoutDuplicates();
		arr = object.getWithoutDuplicates(arr, arr.length);
		System.out.print("[");
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + " ");
		System.out.print("]");
	}
}
