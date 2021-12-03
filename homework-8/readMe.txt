---------------
Aman Choudhri
ac4972
readMe.txt
---------------

Hello! My implementation of Poker doesn't really need too much explanation to
play. All of the instructions required to go through the game are provided in
print statements to the user. Essentially, the game starts by prompting the user
to bet tokens (enter an integer from 1 to 5), then it displays the starting
hand. After this, it goes through each card and asks the user whether they want
to discard the card (the user should enter 1 if yes, 0 if no). Finally, the game
checks the hand, updates the player's bankroll with their winnings (if they have
any). At this point, if the user has any tokens left, they are asked whether
they want to continue playing (if so, they should enter 1, if not, 0).

In terms of code design, my design wasn't all that complex. Essentially, the
constructor for Game creates a new Player and a new Deck, using either a
no-argument constructor for Deck or an argument form that I created (depending
on the constructor used for Game, of course). The no-argument constructor for
Deck creates an array of Cards of length 52, fills it sequentially with cards,
then shuffles it. The argument constructor is more interesting: it first puts
the five cards entered by the user at the start of the deck, then fills the
remainder of the deck sequentially. Finally, it shuffles all but those first
five cards of the deck. I chose to design Deck this way so that the play()
method in Game wouldn't have to check which constructor was called; this way, it
can just deal the first five cards to the user for their starting hand. After
prompting the user whether they want to discard or keep each of the cards, it
deals cards to form a new five-card hand as necessary.

Finally, Game checks the hand and updates the player's bankroll in the checkHand
method. In terms of design, I created a few additional methods to return useful
values like whether the hand contains a straight, whether it contains a flush,
the greatest number of cards that have the same rank, and the number of pairs
present. To check whether the hand contains a straight, I overloaded the method
to divide it into two parts: one part checks whether a straight is present while
treating ace as the highest card, and the other checks while treating the ace as
the lowest card. The isStraight() method returns true if either of those parts
is true. The other methods are relatively simple. To determine which score the
hand should recieve, the checkHand method checks all cases in reverse order
(from the highest payout to the lowest) using the pieces of information returned
from the helper methods. For example, to check for a royal flush, the function
checks for a straight, a flush, and for the first card to be a 10 (since by
default, the hand is sorted such that the ace is the highest card). To check for
a full house, for example, checkHand() looks for 3 cards to be the same and for
there to be two pairs.

And that's about all there is to my code! Thank you so much.
