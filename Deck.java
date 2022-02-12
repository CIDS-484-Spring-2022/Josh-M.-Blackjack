package Main;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck {
	
	//This class will be the layout for the deck
	// Deck suits and deck numbers and values are from "Card" class
	private List<Card> deck = new LinkedList<Card>();

    public Deck() {
        for(Card.Suit suit : Card.Suit.values()) {
            for(Card.Value value : Card.Value.values()) {
                deck.add(new Card(suit,value));
            }
        }
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public int cardsLeft() {
          // As cards are dealt from the deck, the number of cards left
          // decreases.  This function returns the number of cards that
          // are still left in the deck.
        return deck.size();
    }

    public Card dealCard() {
          // Deals one card from the deck and returns it.
        if (deck.size() == 52) {
           shuffle();
        }
        Card temp;
        temp = deck.get(0);
        remove(0);
        System.out.println(temp);
        return temp;
       
    }

    public Card getCard(int i) {
        return deck.get(i);
    }

    public Card remove(int i) {
        Card c = deck.get(i);
        deck.remove(i);
        return c;
    }   
	
}
