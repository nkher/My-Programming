package com.CTCI.Chapter7.Deckofcards;

public abstract class Card {
	/* number or face that's on card - a number 2 through 10, 
	 * or 11 for Jack, 12 for Queen, 13 for King, or 1 for Ace 
	 */
	
	public boolean available = true;
	protected int faceValue;
	protected Suit suit;
	
	// Constructor
	public Card(int c, Suit s) {
		faceValue = c;
		suit = s;
	}
	
	public abstract int value();
	
	public Suit suit() {
		return suit;
	}
	
	/* returns whether or not the card is available to be given out to someone */
	public boolean isAvailable() {
		return available;
	}
	
	public void markUnavailable() {
		available = false;
	}
	
	public void markAvailable() {
		available = true;
	}
	
	public void print() {
		String[] faceValues = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		System.out.println(faceValues[faceValue - 1]);
		switch(suit) {
			case Club:
				System.out.println("c");
				break;
			case Heart:
				System.out.println("h");
				break;
			case Diamond:
				System.out.println("d");
				break;
			case Spade:
				System.out.println("s");
				break;
		}
		System.out.println(" ");
	}
}
