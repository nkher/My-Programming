package GoogleCodeJam;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AlienLanguage {

	public void printAllUniqueWords() throws IOException{
		
		File file = new File("Documents\\AlienLanguage\\A-small-practice.in");
		FileReader frobj = new FileReader(file);
		Scanner scan = new Scanner(frobj);
		int i, m, count=0;
		
		String line = "";
		line = scan.nextLine();
		String[] arr = line.split(" ");
		i = Integer.parseInt(arr[1]);
		char[][] words = new char[i+1][Integer.parseInt(arr[0])];
	
		while(scan.hasNextLine() && count<=i){
			
			line = scan.nextLine();
			char[] wordArray = line.toCharArray();
			for(int j=0;j<words[0].length;j++)
				words[count][j] = wordArray[j];			
			count++;
		}
		
		int l=-1;
		line = scan.nextLine();
		while(scan.hasNextLine()){
			
			char[] currentLine = line.toCharArray();
			
			for(m=0; m<currentLine.length; m++){
				
				for(l=0;l<words.length;l++){					
					if(m==0 && currentLine[m] == words[l][0])
						break;
				}
				
				
			}
			
			System.out.println();
			line = scan.nextLine();
		}
		
		scan.close();
		frobj.close();
	}
	
	public static void main(String[] args) throws IOException {
		
		AlienLanguage object = new AlienLanguage();
		object.printAllUniqueWords();
	}

}
