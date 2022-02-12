# Josh-M.-Blackjack


Blackjack 1.0

Overview
 =============================================================
 Singleplayer blackjack game. Player will be able to split, double, stand, and hit in a classic game of blackjack. Player will be able to raise/lower and place an initial bet. The game will keep track of current money and will go negative to display how much money you can lose while gambling and how quickly. The game will offer a tutorial to offer new players help or to teach new players the game. Game will be made in Java. Will start printing to console and will later be refactored to work with a GUI. 


Outline
---------

Class - Controller
------------------
Listens to user input through mouse clicks.

Class - Container
------------------
Main class which will run start up Class(View) to make the GUI.

Class - View
-------------------
Will create and run the GUI.

Class - Viewer
-------------------
Will update class view

Class - Hand
----------------------
Will provide a template for a players hand. Will contain methods to show hand, get hand size, add card, and will also check to see if the hand dealt was a Blackjack.

Class - Player
----------------------
Will contain player name and give that player a (Hand). Will potentially be used to save games and add multiple players. 

Class - Deck
----------------------
Will contain all 52 cards of a deck and will work with class(card) to create a standard deck of cards. 4 suits, Ace - King. Methods will include 
cardsLeft()
dealCard()
getCard()
removeCard()

Class - Card 
------------------------
Will contain card value 2,3,4,5,6,7,8,9,10,10,10,10,1. And suit Club,Spade,Diamond,Heart. 

Class - Bank
-------------------
Will contain players current bank/money value. Will go negative. 
