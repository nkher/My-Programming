
package AmazonQuestions;

public class ArrayOfStrings {

	// The program checks if the strings in the array can be arranged in a cyclic manner
	// They can be done in any manner/order keeping the following condition
	// All words must have its end character same as their successors first character (Not necessary for last word) 
	// A word apart must have its first character same as its predecessors last character (Not necessary for last word) 
	
	public boolean checkArrayOfStrings(String arr[]){
		
		//boolean retValue = false;
		char start, end;
		int checker = 2, sCounter, eCounter;
		
		// abc cde cad def eac
		for(int i=0;i<arr.length;i++){
			
			start = arr[i].charAt(0);
			end = arr[i].charAt(arr[i].length()-1);
			sCounter = 0; eCounter = 0;	
			
			for(int j=0;j<arr.length;j++){	
				if(i != j){
					if(start == arr[j].charAt(arr[j].length()-1))
						sCounter++;
					if(end == arr[j].charAt(0))
						eCounter++;
				}
			}
			if(sCounter == 0 || eCounter == 0){
				checker=checker-1;
			}
			if(checker<0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		//String[] arr = {"abc", "cde", "cad", "def", "eac"};
		String[] arr = {"ode", "ead", "def", "fcf"};
		ArrayOfStrings object =  new ArrayOfStrings();
		
		System.out.println(object.checkArrayOfStrings(arr));
	}

}
