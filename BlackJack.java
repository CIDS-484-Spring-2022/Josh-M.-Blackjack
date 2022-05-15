package main;

import java.util.Scanner;

public class BlackJack {

	// CHECKS
	// Input - playerMoney
	// Output - playerBet
	public static double Bet(double playerMoney, Scanner intmp) {
		
		// Player will place the amount of money they are betting
		// ask player for bet amount and check to make sure it is valid
		System.out.println("You have $" + playerMoney + "\nHow much would you like to bet?");
					
		double playerBet = intmp.nextDouble();
					
		if (playerBet > playerMoney) {
				while(playerBet > playerMoney) {
					System.out.println("You don't have that much! Try again.");
					playerBet = intmp.nextDouble();
				}
		}
		System.out.println("Betting $" + playerBet);
		System.out.println("------------------------------------------------------------");
		return playerBet;
	}
	// Input - playerDeck
	// Output - playerDeck
	public static Deck dealPlayer(Deck playerDeck, Deck playingDeck) {
		
		// Player gets two cards
		playerDeck.draw(playingDeck);
		playerDeck.draw(playingDeck);
		
		return playerDeck;
	}
	public static Deck dealPlayerRigged(Deck playerDeck, Card ten, Card jack) {
		playerDeck.addCard(jack);
		playerDeck.addCard(ten);
		
		return playerDeck;
	}
	public static Deck dealDealer(Deck dealerDeck, Deck playingDeck) {
		// Dealer gets two cards
		dealerDeck.draw(playingDeck);
		dealerDeck.draw(playingDeck);
		
		return dealerDeck;
	}
	public static void main(String[] args) {
		
		boolean exit = false;
		// Create the deck to play with and the user and dealer hands
		// Create the user's gambling cash
		// =============================================================================
		Scanner userInput = new Scanner(System.in);
		// Welcome Message
		System.out.println("Welcome to Blackjack!");
		
		// Create our playing deck
		Deck playingDeck = new Deck();
		playingDeck.createFullDeck();
		playingDeck.Shuffle();
		
		// Create a deck for the player
		Deck playerDeck = new Deck();                
		Deck playerSplit = new Deck();
		// Create a deck for the dealer
		Deck dealerDeck = new Deck();
		
		// Player Starting Cash
		double playerMoney = 100.00;
		// =============================================================================
		
		// Game Loop
		// =============================================================================
		while(playerMoney > 0 && exit == false) {
			
			// player can play the game
			// Player makes bet
			double playerBet = Bet(playerMoney, userInput);
			// =============================================================================
			boolean endRound = false;
			boolean endRound1 = false;
			boolean splitExists = false;
			// Test Split
			// rigged cards
			Card ten = new Card(Suit.SPADE, Value.TEN);                         
			Card jack = new Card(Suit.DIAMOND, Value.JACK);	
			// Start dealing
			//playerDeck = dealPlayer(playerDeck, playingDeck);					// normal deck
			playerDeck = dealPlayerRigged(playerDeck, ten, jack);				// rigged deck
			dealerDeck = dealDealer(dealerDeck, playingDeck);
			
			// Check if BlackJACK 
			if (playerDeck.cardsValue() == 21 && dealerDeck.cardsValue() != 21) {
				System.out.println("Blackjack! You win 3/2 on your bet. But you can play the hand out still.");
				playerMoney = playerMoney + (playerBet * 1.5);
			}
			
			while(true) {
				// display dealer hand
				System.out.println("Dealer Hand: " + dealerDeck.getCard(0).toString() + " and [Hidden]");
				// display current hand
				System.out.println("Your hand:");
				System.out.println(playerDeck.toString());
				System.out.println("\nYour hand is valued at: " + playerDeck.cardsValue());
				
				// What does the player want to do?
				System.out.println("Would you like to (1)Hit or (2) Stand or (3) Double or (4) Split? or (99) to quit.");
				int response = userInput.nextInt();
				
				if (response == 99) {
					exit = true;
					break;
				}
				// They hit
				else if (response == 1) {
						playerDeck.draw(playingDeck);
						System.out.println("------------------------------------------------------------");
						System.out.println("You draw a: " + playerDeck.getCard(playerDeck.deckSize()-1).toString());
						// Bust if > 21
						if (playerDeck.cardsValue() > 21) {
							System.out.println("BUST. Currently valued at: " + playerDeck.cardsValue());
							playerMoney -= playerBet;
							endRound = true;
							break;
						}
				}
				// They Stand
				else if(response == 2) {
						System.out.println("------------------------------------------------------------");
						break;
				}
				// They Double
				else if(response == 3) {
					playerDeck.draw(playingDeck);
					System.out.println("------------------------------------------------------------");
					System.out.println("You draw a: " + playerDeck.getCard(playerDeck.deckSize()-1).toString());
					playerBet = playerBet * 2;
					// Bust if > 21
					if (playerDeck.cardsValue() > 21) {
						System.out.println("BUST. Currently valued at: " + playerDeck.cardsValue());
						playerMoney -= playerBet;
						endRound = true;
						break;
					}
					break;
								
				}
				// They Split
				// ********************************************************************************************
				else if(response == 4 ) {
					splitExists = true;
					
					// take one card from hand 1
					playerSplit.draw(playerDeck);
					
					// draw 1 card for each hand
					playerSplit.draw(playingDeck);
					playerDeck.draw(playingDeck);
					
					// play hand 1
					while(true) {
						// display dealer hand
						System.out.println("Dealer Hand: " + dealerDeck.getCard(0).toString() + " and [Hidden]");
						// display current hand
						System.out.println("Your 1st hand:");
						System.out.println(playerDeck.toString());
						System.out.println("\nYour 1st hand is valued at: " + playerDeck.cardsValue());
									
						// What does the player want to do?
						System.out.println("Would you like to (1)Hit or (2) Stand?");
						int response1 = userInput.nextInt();
						// They hit
						if (response1 == 1) {
								playerDeck.draw(playingDeck);
								System.out.println("------------------------------------------------------------");
								System.out.println("You draw a: " + playerDeck.getCard(playerDeck.deckSize()-1).toString());
								// Bust if > 21
								if (playerDeck.cardsValue() > 21) {
									System.out.println("Hand 1");
									System.out.println("You BUST. Currently valued at: " + playerDeck.cardsValue());
									System.out.println(playerDeck.toString());
									System.out.println("------------------------------------------------------------");
									playerMoney -= playerBet;
									endRound = true;
									break;
								}
						}
						// They Stand
						else if(response1 == 2) {
								System.out.println("------------------------------------------------------------");
								break;
						}
					}
					// play hand 2
					while(true) {
						// display dealer hand
						System.out.println("Dealer Hand: " + dealerDeck.getCard(0).toString() + " and [Hidden]");
						// display current hand
						System.out.println("Your 2nd Hand:");
						System.out.println(playerSplit.toString());
						System.out.println("\nYour 2nd hand is valued at: " + playerSplit.cardsValue());
									
						// What does the player want to do?
						System.out.println("Would you like to (1)Hit or (2) Stand?");
						int response1 = userInput.nextInt();
						// They hit
						if (response1 == 1) {
								playerSplit.draw(playingDeck);
								System.out.println("------------------------------------------------------------");
								System.out.println("You draw a: " + playerSplit.getCard(playerSplit.deckSize()-1).toString());
								if (playerSplit.cardsValue() > 21) {
									System.out.println("Hand 2");
									System.out.println("You BUST. Currently valued at: " + playerSplit.cardsValue());
									System.out.println(playerSplit.toString());
									System.out.println("------------------------------------------------------------");
									playerMoney -= playerBet;
									endRound1 = true;
									break;
								}
						}
						// They Stand
						else if(response1 == 2) {
								System.out.println("------------------------------------------------------------");
								break;
						}
					}
					break;			
				}
				// ********************************************************************************************
				else {
					System.out.println("You can't do that or that isnt an option!");
				}
			}
			
			// Reveal Dealer Cards
			System.out.println("Dealer Flip: \n" + dealerDeck.toString());
			System.out.println("Dealer Flip Hand Value: " + dealerDeck.cardsValue());
			System.out.println("------------------------------------------------------------");
			
			// Dealer TURN
			// =============================================================================
			// CHECK 1
			// Dealer draws at 16, stand at 17
			while ((dealerDeck.cardsValue() < 17) && endRound == false) {
				dealerDeck.draw(playingDeck);
				System.out.println("Dealer Draws: " + dealerDeck.getCard(dealerDeck.deckSize() - 1).toString());
				System.out.println("Dealer Hand Value: " + dealerDeck.cardsValue());
			}
			// CHECK 2
			// Determine if dealer busted
			if((dealerDeck.cardsValue()> 21) && endRound == false) 
			{
				System.out.println("------------------------------------------------------------");
				System.out.println("Dealer busts! You win.");
				playerMoney += playerBet;
				endRound = true;
			}
			// CHECK 3
			// Determine if Dealer wins
			if (dealerDeck.cardsValue() > playerDeck.cardsValue() && endRound == false)
			{
				System.out.println("------------------------------------------------------------");
				System.out.println("Dealer wins!");
				playerMoney -= playerBet;
				endRound = true;	
			}
			// CHECK 4
			// Determine if Player wins
			if((playerDeck.cardsValue() > dealerDeck.cardsValue()) && endRound == false) 
			{
				System.out.println("------------------------------------------------------------");
				System.out.println("You win the hand!");
				playerMoney += playerBet;
				endRound = true;
			}
			// CHECK 5
			// Determine if push
			if((playerDeck.cardsValue() == dealerDeck.cardsValue()) && endRound == false) {
				System.out.println("------------------------------------------------------------");
				System.out.println("Push");
				endRound = true;
			}
			// -----------------------------------------------------------------------------------------------------------------------------------
			// CHECKS FOR SPLIT HAND
			// CHECK 1 SPLIT
			// Determine if dealer busted
			if((dealerDeck.cardsValue()> 21) && endRound1 == false && splitExists == true) 
			{
				System.out.println("------------------------------------------------------------");
				System.out.println("Dealer busts! You win.");
				playerMoney += playerBet;
				endRound1 = true;
			}
			// CHECK 3 SPLIT
			// Determine if Dealer wins for second hand money income
			if (dealerDeck.cardsValue() > playerSplit.cardsValue() && endRound1 == false && splitExists == true)
			{
				System.out.println("------------------------------------------------------------");
				System.out.println("Dealer wins!");
				playerMoney -= playerBet;
				endRound1 = true;	
			}
			// CHECK 4 SPLIT
			// Determine if Player 2nd hand wins
			if((playerSplit.cardsValue() > dealerDeck.cardsValue()) && endRound1 == false && splitExists == true) 
			{
				System.out.println("------------------------------------------------------------");
				System.out.println("You win the hand!");
				playerMoney += playerBet;
				endRound1 = true;
			}
			// CHECK 5 SPLIT
			// Determine if push for 2nd hand
			if((playerSplit.cardsValue() == dealerDeck.cardsValue()) && endRound1 == false && splitExists == true) {
				System.out.println("------------------------------------------------------------");
				System.out.println("Push");
				endRound1 = true;
			}
			
			// Display Total Value for Dealer
			System.out.println(dealerDeck.toString());
			System.out.println("");
			System.out.println("Dealers's Hand is valued at: " + dealerDeck.cardsValue());
			
			playerDeck.moveAllToDeck(playingDeck);
			dealerDeck.moveAllToDeck(playingDeck);
			if (splitExists == true) {
				playerSplit.moveAllToDeck(playingDeck);
			}
			
			System.out.println("");
			System.out.println("End of hand.");
			System.out.println("------------------------------------------------------------");
			
			
			
		}
		// =============================================================================
		userInput.close();
		System.out.println("Game over! :(");
		
		
	}

}
