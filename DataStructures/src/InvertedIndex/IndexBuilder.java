package InvertedIndex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import javax.swing.text.Document;

public class IndexBuilder implements java.io.Serializable{
	
	private Properties configSettings;
	private int numberOfDocuments;
	private String inputFileName;
	private ArrayList documentList = new ArrayList();
	
	IndexBuilder(Properties p){
		p=configSettings;
	}
	
	//Building the inverted index
	public InvertedIndex build(){
		boolean endOfFile=false;
		int offset=0;
		Document d;
		InvertedIndex index =  new InvertedIndex();
		//index.clear();
		inputFileName = configSettings.getProperty("TEXT_FILE");
		//The following function loops through all the document objects and calls 
		//add method associated with the Inverted Index object to add each document 
		// to the inverted index
		Iterator i = documentList.iterator();
		while(i.hasNext()){
			d=(Document)i.next();
			index.add(d);
		}
		//index.write(configSettings);//Writes the complete inverted index to the disk
		return index;
	}
}
