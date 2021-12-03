/* 
 * Aman Choudhri
 * ac4972
 * Card.java
 */

public class Card implements Comparable<Card>{
	
	private int suit; // use integers 1-4 to encode the suit
	private int rank; // use integers 1-13 to encode the rank
	
	public Card(int s, int r){
		//make a card with suit s and value v
        suit = s;
        rank = r;
	}
	
	public int compareTo(Card c){
		// use this method to compare cards so they 
		// may be easily sorted
        // we want ace to be the greatest element,
        // so check whether either card is an ace
        int difference = rank - c.getRank();
        // If they're the same card, return zero
        if (difference == 0) {
            return 0;
        } else if (rank == 1) {
            // if this card is an ace, return 1
            return 1;
        } else if (c.getRank() == 1) {
            // if the provided card is an ace, return -1
            return -1;
        }
        // if none of the above, just return the differennce in ranks
        return difference;
	}
	
	public String toString(){
		// use this method to easily print a Card object
        String[] suitNames = {"Spades", "Clubs", "Hearts", "Diamonds"};
        String[] rankNames = {"Ace", "Two", "Three", "Four", "Five",
                              "Six", "Seven", "Eight", "Nine", "Ten",
                              "Jack", "Queen", "King"};
        return rankNames[rank - 1] + " of " + suitNames[suit - 1];
	}
    
    public int getRank() {
        return rank;
    }
    
    public int getSuit() {
        return suit;
    }
    /* Useful helper to return if two cards have the same suit + rank. */
    public boolean equals(Card c) {
        return suit == c.getSuit() && rank == c.getRank();
    }
}
