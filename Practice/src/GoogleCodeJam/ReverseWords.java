package GoogleCodeJam;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReverseWords {
	
	public void reverseWords(String filePath, int N) throws IOException{
		
		File file = new File(filePath);
		String line = "";
		int i=0, j=0;
		
		File f = new File("Documents\\output.txt");
		FileWriter fwobj = new FileWriter(f.getAbsoluteFile());
		BufferedWriter bwobj = new BufferedWriter(fwobj);
		
		if(file.exists()){
			FileReader fr = new FileReader(file);
			Scanner scan = new Scanner(fr);
			
			while(scan.hasNextLine()){	
				line = scan.nextLine();
				
				if(j>0 && j<=N){
					if(line.contains(" ")){
						String[] array = line.split(" ");
						bwobj.write("Case #"+j+": ");
						for(i=array.length-1;i>=0;i--)
							bwobj.write(array[i] + " ");
					}
					else {
						bwobj.write("Case #"+j+": ");
						bwobj.write(line + " ");
					}
				}
				bwobj.newLine();
			    j++;
			}
			
			bwobj.close();
			scan.close();
		}
		
	}
	
	public static void main(String[] args) throws IOException {
	
		ReverseWords object = new ReverseWords();
		object.reverseWords("Documents\\B-large-practice.in", 30);
	}

}
