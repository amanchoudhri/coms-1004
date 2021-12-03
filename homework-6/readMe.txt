Problem 1:

For an overview, the structure of Game is to set up a Computer and a Human, decide who goes first,
then start the main game loop. If the computer is to go first, Game has it make a turn before the main loop.
Then the game begins. The human takes a turn, then Game checks whether marbles = 0. If it does, that means the human took
the last marble. Note that the edge case of the computer having taken the last marble on the first turn is irrelevant
since the minumum starting marbles is greater than 1. Similarly, the computer then takes a turn, and Game checks once more.

Inside Computer, the move method first determines the greatest power of two less than or equal to the current number
of marbles left. This is to determine, 1. whether the current # of marbles left is a power of 2 minus 1, and 2. how
many marbles the computer would need to take to ensure that the remaining marbles would be a power of 2 minus 1.
Then, the computer checks if it's in stupid mode or if 1. is true. If so, it makes a random move. If not, it calculates
2. and makes that move.

Human is very simple. It has a main while loop in which it asks a user for input until it recieves a valid number of marbles.

I made one interesting decision in creating this solution. Namely, I created an interface called Player, which has methods move
and getChoice. The reason I did this is because, admittedly, I think interfaces are super neat and wanted to try one out, and
secondly, I noticed that the code I was using inside Game for the computer and human moves was very similar. I'd call the move
method, update marbles accordingly, then print out the remaining marbles. So, I pulled that out into a function and had it take
a parameter that implemented Player.

Problem 2:

My solution for problem 2 was relatively straightforward. My two main additional functions were to calculate the check digit
for a given zip code, and then one to return an int array of all the digits in that would be encoded in the bar code (including
prepending zeroes and appending the check digit). To convert from a ZIP to a bar code, I iterate through this int array,
concatenating the hardcoded barcode values together, then enclose that with the frame bars. To convert from a bar code to a ZIP
code, I iterate through all substrings of length 5 inside the frame bars of the barcode. At each step, I check whether the
substring is a valid encoding sequence. If not, the program prints an error and returns. If so, it'll store the digit. Finally,
the program checks the provided check digit against the expected one, pritning an error if appropriate.