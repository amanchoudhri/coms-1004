/* 
 * Aman Choudhri
 * ac4972
 * Deck.java
 */

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	
	private Card[] cards;
	private int top; // the index of the top of the deck

	
	public Deck(){
		// make a 52 card deck here
        cards = new Card[52];
        top = 0;
        int i = 0;
        for (int suit = 1; suit < 5; suit++) {
            for (int rank = 1; rank < 14; rank++) {
                cards[i] = new Card(suit, rank);
                i++;
            }
        }
        // shuffle the cards
        shuffle();
	}

    /* 
     * A constructor for Deck when provided a hand to start with.
     * This will put the given cards in the first five slots in the deck,
     * then fill the remainder of the deck randomly.
     */
    public Deck(String[] startingHand) {
        cards = new Card[52];
        top = 0;
        int idx = 0;
        for (String c : startingHand) {
            char[] suits = {'s', 'c', 'h', 'd'};
            // determine the suit
            int suit = 1;
            for (char s : suits) {
                if (c.charAt(0) == s) {
                    break;
                }
                suit++;
            }
            // determine the rank
            int rank = Integer.parseInt(c.substring(1));
            // create new card
            Card card = new Card(suit, rank);
            // place it in the first few cards of the deck
            cards[idx] = card;
            idx++;
        }
        // initialize the rest of the deck
        int i = idx;
        for (int suit = 1; suit < 5; suit++) {
            for (int rank = 1; rank < 14; rank++) {
                Card c = new Card(suit, rank);
                // if the card is one of the given cards, skip it
                boolean seen = false;
                // compare the card to all of the provided cards
                for (int j = 0; j < idx; j++) {
                    if (c.equals(cards[j])) {
                        seen = true;
                    }
                }
                // if seen is false, add c to the deck
                if (!seen) {
                    cards[i] = c;
                    i++;
                }
            }
        }
        // shuffle all cards after the first few that were specified
        // to be the starting hand
        shuffle(idx);
    }
	
	public void shuffle(){
		// shuffle the deck here
		shuffle(cards);
        // reset the top card
        top = 0;
	}

    /* Static shuffle method to shuffle any given array of cards. */
    static private void shuffle(Card[] deck) {
        Random r = new Random();
        for (int i = 0; i < deck.length - 2; i++) {
            // generate a random int in [i, cards.length)
            int j = r.nextInt(deck.length - i) + i;
            // swap cards[i] and cards[j]
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    /* 
     * Shuffle every card in the deck starting at the specified idx.
     * For example, setting topCard to 5 keeps the first 5 cards the same,
     * and shuffles cards 5-51.
     * This is used when the argument constructor for Deck is called,
     * and we want to preserve the first few cards.
     */
    public void shuffle(int topCard) {
        Card[] subDeck = new Card[52 - topCard];
        // fill the subdeck with cards topCard through 51.
        for (int i = 0; i < subDeck.length; i++) {
            subDeck[i] = cards[i + topCard];
        }
        // shuffle the subdeck
        shuffle(subDeck);
        // replace the actual deck cards from topCard onward with the shuffled cards
        for (int i = topCard; i < cards.length; i++) {
            cards[i] = subDeck[i - topCard];
        }
    }
	
	public Card deal(){
		// deal the top card in the deck
        return cards[top++];
	}
	
    public String toString() {
        String base = "";
        for (int i = 0; i < cards.length - 1; i++) {
            base += cards[i].toString() + "\n";
        }
        return base;
    }

}
