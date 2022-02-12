package Main;

public class Player extends Deck{

	private String name;
	private Hand hand;
	
	public Player() {
		this.hand = null;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setHand(Hand h) {
		this.hand = h;
	}
	public void getHand() {
		hand.showHand();
	}
}
