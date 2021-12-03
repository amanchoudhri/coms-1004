/* 
 * Aman Choudhri
 * ac4972
 * Player.java
 */

import java.util.ArrayList;
import java.util.Collections;

public class Player {
	
		
	private ArrayList<Card> hand; // the player's cards
	private double bankroll;
    private double bet;

	// you may choose to use more instance variables
		
	public Player(){		
	    // create a player here
	    hand = new ArrayList<>();
        // arbitrarily start player off with 10 tokens
        bankroll = 10;
	}

	public void addCard(Card c){
	    // add the card c to the player's hand
        hand.add(c);
	}

	public void removeCard(Card c){
	    // remove the card c from the player's hand
        hand.remove(c);
    }

    public void bets(double amt){
        // player makes a bet
        bet = amt;
        bankroll -= bet;
    }

    public void winnings(double odds){
        //	adjust bankroll if player wins
        bankroll += odds * bet;
    }

    public double getBankroll(){
        // return current balance of bankroll
        return bankroll;
    }
    
    /* Useful helper to return the player's hand */
    public ArrayList<Card> getHand(){
        Collections.sort(hand);
        return hand;
    }
    
    /* Clear the player's hand, used when a new round of the game starts. */
    public void clearHand() {
        hand.clear();
    }

}


