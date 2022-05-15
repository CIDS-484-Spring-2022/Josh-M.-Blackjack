# Josh-M.-Blackjack


Blackjack 1.0

Overview
 =============================================================
 Singleplayer game of Blackjack. Player will be able to Hit, Stand, Double, or Split. Tracks cash value until you lose all your money the game ends. Game Creates randomized decks each time you start it. Game adds used cards from previous hand to end of stack for continuous gameplay(Assuming you dont lose all you money first).

Future plans
================
GUI
Multiple decks/ game
Saving progress
Multiple Hands besides splitting
Tutorial/ walk through
SideBets ( so you can really throw your fake money away)

Outline
---------

Blackjack Class
----------
Main class for the bulk of the program. 

Card Class 
-------------
Template for a card. Each card has a suit and a value.
Includes toString Method and getValue method.

Deck Class
------------------
I use the deck class to make hands for the player and dealer.
Stores a deck/ creates it in an array. createFullDeck() generates deck in order. 
Shuffle() randomizes the deck.
draw() adds card to a deck from a existing deck and removes it from the deck it took from.
moveAlltoDeck() used for restoring the deck playing cards for continuous play
cardsValue() returns the value of the cards in each deck/hand. 
toString() format printing

Value class
----------
enum class defining TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE

Suit class
---------------
enum class defining SPADES, HEARTS, DIAMONDS, CLUBS
