package InvertedIndex;

import java.io.Serializable;

//This class will store information that we wish to store for an occurrence of the term within the document
public class PostingListNode implements Serializable{
	
	long documentID;
	TermFrequency tf;
	
	public PostingListNode(long id, TermFrequency tf){
		documentID = id;
		this.tf = tf;
	}
	
	public long getDocumentID(){
		return documentID;
	}
	
	public short getTF(){
		return tf.getTF();
	}
}
