package PatternSearching;

public class RabinKarpAlgorithm {

	// Average case and best case is O(m + n) 
	// Worst case is O(nm)
	
	public void RabinKarpSearch(String text1, String pattern1,int primeNumber){
		
		int d=256; //This is to indicate the number of characters in the input alphabet
		char[] text = text1.toCharArray();
		char[] pattern = pattern1.toCharArray();
		int patternLength = pattern.length;
		int textLength = text.length;
		int i,j;//Used for looping
		int patternHash=0;//Gives Pattern Hash Value
		int textHash=0;//Gives Text Hash Value
		int h=1;//This is used to get the value of the next set of string
		
		
		//Getting the value of h
		for (i=0;i<patternLength-1;i++){
			h=(h*d)%primeNumber;
		}
		
		System.out.println("h is : " + h);
		
		//Getting the hash value of the pattern and the first window of text
		for (i=0;i<patternLength;i++){
			patternHash=((d*patternHash) + pattern[i])%primeNumber;
			textHash= ((d*textHash) + text[i])%primeNumber;
		}
		
		System.out.println("pattern hash : " + patternHash);
		System.out.println("text hash : " + textHash);
		
		//Now start running the loop 
		for(i=0;i<=textLength-patternLength;i++){
				
			//Comparing the first window hash value to the pattern hash value
			if(patternHash == textHash){
				
				//Now check each string one by one 
				for(j=0;j<patternLength;j++){
					if(pattern[j] != text[j+i])
						break;
				}
				if(j==patternLength)
					System.out.println("Match found at Index : " + i);
			}
			
			//Now checking the hash value of the next window
			if(i<textLength-patternLength){
				
				          /*Removing trailing digit*/  /*Add the next digit*/
				textHash = (d*(textHash - text[i]*h) + text[i+patternLength])%primeNumber;
				
				//Now to handle the negative value
				if(textHash<0){
					textHash = textHash + primeNumber;
				}
			}
		}		
	}
	
	public static void main(String[] args) {
		
		String text = "Geeks for geeks!";
		String pattern = "geek";
		int primeNumber = 101;
		
		
		//Converting to lower Case
		text = text.toLowerCase();
		pattern = pattern.toLowerCase();
		
		//Calling the function
		RabinKarpAlgorithm rka =  new RabinKarpAlgorithm();
		rka.RabinKarpSearch(text, pattern, primeNumber);
	}

}
