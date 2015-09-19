package InvertedIndex;

import java.io.Serializable;

public class TermFrequency implements Serializable{
	
	private static final short MAX_VALUE = 32767;
	short tf;
	
	public TermFrequency(){
		tf = 1;
	}
	
	//Increment tht tf variable as long as we have room for increment
	public void Increment(){
		if(tf <= MAX_VALUE){
			tf = (short)(tf+1);
		}
	}
	
	public void Set(short value){
		tf = value;
	}
	
	public short getTF(){
		return tf;
	}
}
