package main;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

	// object variable
	private ArrayList<Card> cards;
	
	// constructor
	public Deck() {
		this.cards = new ArrayList<Card>();
	}
	
	public void createFullDeck() {
		
		// generate cards
		// 4 suits times 13 values in each suit is 52 cards
		// for each suit return the suit value and store it in cardSuit. 4 values
		for(Suit cardSuit : Suit.values()) { 
			// for each value return the value of each value and store it in cardValue 13 values
			for(Value cardValue : Value.values()) { 
				// add new card to the deck
				this.cards.add(new Card(cardSuit, cardValue));
			}
		}
	}
	
	// put cards into new temporary deck at random places then replaces the working deck
	public void Shuffle() {
		
		// temporary array for the shuffled deck
		ArrayList<Card> tmpDeck = new ArrayList<Card>();
		// Use Random
		Random random = new Random();
		int randomCardIndex = 0; // represents the card being randomized
		int originalSize = this.cards.size(); // value to make sure the deck stays at 52
		
		// generate 52 cards in random order
		for(int i = 0; i < originalSize; i++) {
			
			// Generate Random Index 
			// syntax for generating random index = rand.nextInt((max - min) + 1) + min
			randomCardIndex = random.nextInt((this.cards.size() - 1 - 0) + 1) + 0;
			// add random cards to the shuffled deck
			tmpDeck.add(this.cards.get(randomCardIndex));
			// Remove from original card from the working deck to avoid duplicates
			this.cards.remove(randomCardIndex);
		}
		
		this.cards = tmpDeck;
		
	}
	
	public void removeCard(int i){
		this.cards.remove(i);
	}
	
	public Card getCard(int i) {
		return this.cards.get(i);
	}
	
	public void addCard(Card addCard) {
		this.cards.add(addCard);
	}
	
	// Draws from the deck
	public void draw(Deck comingFrom) {
		this.cards.add(comingFrom.getCard(0));
		comingFrom.removeCard(0);
	}
	
	public int deckSize() {
		return this.cards.size();
	}
	
	public void moveAllToDeck(Deck moveTo) {
		int thisDeckSize = this.cards.size();
		
		// puts cards into moveTo deck
		for (int i = 0; i < thisDeckSize; i++) {
			moveTo.addCard(this.getCard(i));
		}
		for (int i = 0; i < thisDeckSize; i++) {
			this.removeCard(0);
		}
	}
	
	// return total value of cards in deck
	public int cardsValue() {
		int totalValue = 0;
		int aces = 0;
		
		for (Card aCard : this.cards) {
			switch(aCard.getValue()) {
			
			case TWO: totalValue += 2; break;
			case THREE: totalValue += 3; break;
			case FOUR: totalValue += 4; break;
			case FIVE: totalValue += 5; break;
			case SIX: totalValue += 6; break;
			case SEVEN: totalValue += 7; break;
			case EIGHT: totalValue += 8; break;
			case NINE: totalValue += 9; break;
			case TEN: totalValue += 10; break;
			case JACK: totalValue += 10; break;
			case QUEEN: totalValue += 10; break;
			case KING: totalValue += 10; break;
			case ACE: aces += 1; break;
			}
		}
		
		for (int i = 0; i < aces; i++) {
			
			if (totalValue > 10) {
				totalValue += 1;
			}
			else {
				totalValue += 11;
			}
		}
		
		return totalValue;
	}
	
	
	// format for printing the cards out
	public String toString() { 
		String cardListOutput = "";
		for(Card aCard : this.cards) {
			cardListOutput = cardListOutput + "\n" + aCard.toString();
		}
		return cardListOutput;
	}
	
}
