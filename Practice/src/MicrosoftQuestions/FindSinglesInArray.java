package MicrosoftQuestions;

public class FindSinglesInArray {

	public int getUnpairedElement(int[] array){
		
		int answer=0;
		int n = array.length;
		for(int i=0;i<n;i++){
			answer = answer ^ array[i];
		}
		return answer;
	}
	
	public static void main(String[] args) {
		
		int[] doublesArray = {3,8,5,4,8,5,3,4,10};
		FindSinglesInArray object =  new FindSinglesInArray();
		int answer = object.getUnpairedElement(doublesArray);
		System.out.println(answer);
	}

}
