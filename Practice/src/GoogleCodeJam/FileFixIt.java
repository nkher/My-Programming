package GoogleCodeJam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class FileFixIt {	
	
	
	public void readFile(String fileName) throws IOException{
	
		File file = new File("Documents//File-Fix-It//"+fileName);
		FileReader frobject = new FileReader(file);
		Scanner scanner = new Scanner(frobject);
		
		
		try{
			
			String[] array = null;
			String line="";
			line = scanner.nextLine();
			int toBeCreatedCount=0 , existingDiectoriesCount=0, lineCounter=0;
			HashMap<String, Integer> existingDirectories = new HashMap<String, Integer>();
			HashMap<String, Integer> toBeCreated = new HashMap<String, Integer>();
			
			
			while(scanner.hasNext()){
				line = scanner.nextLine();
								
				// Write the main logic over here
				
				if(!line.contains("/")){
					array = line.split(" ");
					toBeCreatedCount = Integer.parseInt(array[0]);
					existingDiectoriesCount = Integer.parseInt(array[1]);
					lineCounter = 1;
					
					// Clearing the Hashmaps
					toBeCreated.clear();
					existingDirectories.clear();
				}
				
				else{
					array = line.split("/");
					if(existingDiectoriesCount == lineCounter){
						
						// Adding to the existingDirectories HashMap
						for(int j=0; j<array.length; j++)
							existingDirectories.put(array[j].toString(), j);
					}
					if(toBeCreatedCount == lineCounter){
						
						// Adding to the toBeCreated HashMap
						for(int j=0; j<array.length; j++)
							existingDirectories.put(array[j].toString(), j);
					}
					// Incrementing the line counter
					lineCounter++;
				}
			}
		}
		
		finally{
			scanner.close();
			frobject.close();
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		FileFixIt fileFixIt = new FileFixIt();
		fileFixIt.readFile("Sample");
		
	}

}
