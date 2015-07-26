package com.CTCI.Chapter7.Deckofcards;

public class BlackJackCard extends Card{

	public BlackJackCard(int c, Suit s) {
		super(c, s);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int value() {
		if(isAce()) { //  Ace
			return 1;
		}
		else if (faceValue >= 11 && faceValue <= 13) {
			return 10;
		}
		else return faceValue;
	}
	
	public int minValue() {
		if(isAce()) {
			return 1;
		}
		else 
			return value();
	}
	
	public int maxValue() {
		if(isAce()) {
			return 11;
		}
		return 
			value();
	}
	
	public boolean isAce() {
		return faceValue == 1;
	}

	public boolean isFaceCard() {
		return faceValue >= 11 && faceValue <= 13;
	}
	
	
}
