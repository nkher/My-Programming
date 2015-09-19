package InvertedIndex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.text.*;
import java.lang.*;

import javax.swing.text.Document;

public class InvertedIndex implements java.io.Serializable{
	
	private HashMap index; //The actual inverted index stores the list of the terms in the II
	private ArrayList documentList; //Stored structured info about each document
	
	//Constructor initilizes the document object
	InvertedIndex() {
		index = new HashMap();
		documentList = new ArrayList();
	}
	
	//To add a document object to the Map
	public void add(Document d){
		String token; //To hold the current token
		//TermFrequency tf; //holds the current terms freq
		Set termSet;// Set of terms to add to index
		LinkedList postingList; //List of DocId and tf entries
		HashMap terms = new HashMap();
		Integer documentFrequency;
		int df;
		
		
		termSet = terms.keySet();
		Iterator i = termSet.iterator();
		
		//Loop through the terms and add to the index
		while(i.hasNext()){
			token = (String)i.next();
			
			//If we have the term then get the existing posting list and then add the new term frequency
			if(index.containsKey(token)){
				postingList = (LinkedList) index.get(token);
			}
			else{
				//Add the term and then create new posting list and add to the map
				postingList = new LinkedList();
				index.put(token, postingList);
			}
			//Now add this node to the posting list
			//tf = (TermFrequency)terms.get(token);
			//PostingListNode currentNode = new PostingListNode(docID, tf);
			//postingList.add(currentNode);
		}
	}
	
	//Returns a posting list for the given term
	public LinkedList getPostingList(String token){
		
		LinkedList result = new LinkedList();
		if(index.containsKey(token)){
			result=(LinkedList)index.get(token);
		}
		else
			result = null;
		
		return result;
	}
	
}
