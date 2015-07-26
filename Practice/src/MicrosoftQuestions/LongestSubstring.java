package MicrosoftQuestions;

public class LongestSubstring {

	public int getLongestSubstring(String text){
		
		text = text.toLowerCase();
		char[] arr = text.toCharArray();
		int []arr2 = new int[arr.length];
		for(int j=0;j<arr2.length;j++) // Creating an Array of Ascii Values
			arr2[j] = (int)arr[j];
		
		// Sorting the array using bubble sort
		for(int m=0;m<arr2.length-1;m++)
			for(int p=0;p<arr2.length-p-1;p++){
				if(arr2[p] > arr2[p+1]){
					int temp=arr2[p];
					arr2[p]=arr2[p+1];
					arr2[p+1]=temp;
				}
			}
		// Applying the logic to get the length of the longest sub string
		int length[] = new int[arr2.length];
		int current = arr2[0], len=1, t=0;	
		for(int k=1;k<arr2.length;k++){
			if(arr[k] == current + 1){
				current = arr[k];
				len++;
			}
			else{
				//System.out.println(len);
				length[t] = len;
				current = arr2[k];
				len = 1;
				t++;
			}
		}
		
		int max=length[0];
		for(int i=1;i<length.length;i++){
			if(max<length[i])
				max=length[i];
		}
		return max;	
	}
	
	public static void main(String[] args) {
		
		LongestSubstring object = new LongestSubstring();
		
		String string = "owadddddcbdddddjkljjj";
		char[] arr = string.toCharArray();
		
		
		int value = object.getLongestSubstring(string);
		System.out.println(value);
	}

}
