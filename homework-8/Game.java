/* 
 * Aman Choudhri
 * ac4972
 * Game.java
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Game {
	
	private Player p;
	private Deck cards;
	
	public Game(String[] testHand){
		// use the contents of testHand to
		// make a hand for the player
		// use the following encoding for cards
		// c = clubs
		// d = diamonds
		// h = hearts
		// s = spades
		// 1-13 correspond to ace-king
		// example: s1 = ace of spades
		// example: testhand = {s1, s13, s12, s11, s10} = royal flush
		p = new Player();
		// use an argument constructor for Deck that I created
		cards = new Deck(testHand);
	}
	
	public Game(){
		// This no-argument constructor is to actually play a normal game
		p = new Player();
		cards = new Deck();
	}
	
	public void play(){
		// this method should play the game
		// ask player for a bet from 1-5 tokens
		System.out.println("How many tokens would you like to bet? " +
				   "Please enter a number from 1 to 5.");
		Scanner input = new Scanner(System.in);
		int bet = input.nextInt();
		p.bets(bet);
		// add the first 5 cards in the deck to the player's hand
		// note: if the argument constructor was used, this will add the
		// specified cards to the player's hand.
		// otherwise, it will add 5 random cards.
		for (int i = 0; i < 5; i++) {
		    p.addCard(cards.deal());
		}
		// display the cards in the hand
		System.out.println("----- Your hand -----");
		Card[] tentativeHand = new Card[5];
		int idx = 0;
		for (Card c : p.getHand()) {
		    System.out.println("Card " + (idx + 1) + ": " + c);
		    tentativeHand[idx] = c;
		    idx++;
		}
		System.out.println("---------------------");
		// now for each card in the hand, ask if the player would like to keep or remove it
		for (int i = 0; i < 5; i++) {
		    // assume player input is valid
		    System.out.println("Would you like to discard card " + (i + 1) +
				       "? Enter 1 if yes, 0 if no.");
		    int choice = input.nextInt();
		    // if the player wants to discard card i
		    // remove card i from the players hand, and 
		    // add the top card from the deck
		    if (choice == 1) {
				p.removeCard(tentativeHand[i]);
				p.addCard(cards.deal());
				System.out.println("Card " + (i + 1) + " discarded!");
		    }
		}
		// display the final hand
		System.out.println("–––––– Final hand –––––");
		for (Card c : p.getHand()) {
		    System.out.println(" - " + c);
		}
		System.out.println("-----------------------");
		// check hand and update player balance (done in checkHand)
		System.out.println("Checking hand...");
		System.out.println("Result: " + checkHand(p.getHand()));
		// display updated balance
		System.out.println("Calculating winnings with a bet of " + bet + " ...");
		System.out.println("Updated balance: " + p.getBankroll());
		// if user has tokens left, ask if they want to play again
		if (p.getBankroll() > 0) {
		    System.out.println("Would you like to play again? " +
				       "Press 1 to continue, and 0 to end.");
		    int continuePlaying = input.nextInt();
		    if (continuePlaying == 1) {
				// clear the player's hand so cards from this round
				// don't persist to next round
				p.clearHand();
				// create a new shuffled deck for next round (per #611 in ed)
				cards = new Deck();
				play();
		    } else {
				System.out.println("Thanks for playing!");
		    }
		} else {
		    System.out.println("Looks like you're out of tokens. " +
				       "Thanks for playing!");
		}
	}
	
	public String checkHand(ArrayList<Card> hand){
		// this method should take an ArrayList of cards
		// as input and then determine what evaluates to and
		// return that as a String
		// start off by sorting the hand
		Collections.sort(hand);
		// next cache useful values to avoid recalculating
		boolean straight = isStraight(hand);
		boolean flush = isFlush(hand);
		int maxNumOfAKind = numOfAKind(hand);
		int numPairs = numPairs(hand);
		// check all possible payouts in reverse order (high -> low)
		// and update player bankroll with winnings
		if (straight && flush) {
		    if (hand.get(0).getRank() == 10) {
				p.winnings(250);
				return "royal flush";
		    } else {
				p.winnings(50);
				return "straight flush";
		    }
		} else if (maxNumOfAKind == 4) {
		    p.winnings(25);
		    return "four of a kind";
		} else if (maxNumOfAKind == 3 && numPairs == 2) {
		    p.winnings(6);
		    return "full house";
		} else if (flush) {
		    p.winnings(5);
		    return "flush";
		} else if (straight) {
		    p.winnings(4);
		    return "straight";
		} else if (maxNumOfAKind == 3) {
		    p.winnings(3);
		    return "three of a kind";
		} else if (numPairs == 2) {
		    p.winnings(2);
		    return "two pairs";
		} else if (numPairs == 1) {
		    p.winnings(1);
		    return "one pair";
		}
		return "nothing :(";
	}
	private static int[] getOccurences(ArrayList<Card> hand) {
		// Store the number of times each rank appears
		int[] appearances = new int[13];
		// Increment the occurences accordingly
		for (Card c : hand) {
		    appearances[c.getRank() - 1]++;
		}
		return appearances;
	}
	private static int numOfAKind(ArrayList<Card> hand) {
		// Find the max num of occurences
		int maxVal = 1;
		for (int count : getOccurences(hand)) {
		    if (count > maxVal) {
			maxVal = count;
		    }
		}
		return maxVal;
	}
    private static int numPairs(ArrayList<Card> hand) {
        // Find all the ranks that have at least two occurences
        int numPairs = 0;
        for (int count : getOccurences(hand)) {
            numPairs += count / 2;
        }
        return numPairs;
    }
    /* Check whether the cards have a flush, i.e. all cards have the same suit
     */
    private static boolean isFlush(ArrayList<Card> hand) {
        int suit = hand.get(0).getSuit();
        for (Card c : hand) {
            if (c.getSuit() != suit) {
                return false;
            }
        }
        return true;
    }
    /* 
	 * Check whether the given hand has a straight in general,
     * considering both the case when the ace is treated as the lowest
     * and as the highest card.
     */
    private static boolean isStraight(ArrayList<Card> hand) {
        return isStraight(hand, true) || isStraight(hand, false);
    }
    /* 
	 * Check whether the given hand has a straight the way it's sorted.
     * The param aceAsLow tells the method whether to sort the hand
     * by treating the ace as the lowest or the highest card.
     */
    private static boolean isStraight(ArrayList<Card> hand, boolean aceAsLow) {
        if (aceAsLow) {
            hand = sortAceLow(hand);
        }
        Card prev = hand.get(0);
        for (int i = 1; i < hand.size(); i++) {
            int currRank = hand.get(i).getRank();
            // Add special case to check whether the current is an
            // ace and the prev is a king
            // Then check to make sure the curr rank is one plus the prev rank
            if (currRank == 1 && prev.getRank() == 13) {
                continue;
            } else if (currRank != prev.getRank() + 1) {
               return false;
            }
            prev = hand.get(i);
        }
        return true;
    }
	/* Sort a given hand but instead of treating ace as the highest card,
	 * treat it as the lowest card. Return the newly sorted hand.
	 */
	private static ArrayList<Card> sortAceLow(ArrayList<Card> hand) {
		// create a new arraylist
		ArrayList<Card> sorted = new ArrayList<>();
		// add aces to the beginning of sorted, add other cards to the end
		for (Card c : hand) {
			if (c.getRank() == 1) {
			sorted.add(0, c);
			} else {
			sorted.add(c);
			}
		}
		return sorted;
	}
}
