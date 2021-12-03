/*****************************************
 * A template for a Nim game
 ****************************************/ 

import java.util.Random;

public class Game{
    
    private int marbles;
    private Human humanPlayer;
    private Computer computerPlayer;
    private Random r;
    
    public Game(int difficulty){
        
        computerPlayer = new Computer(difficulty);
        humanPlayer = new Human();
        
        r = new Random();
        marbles = r.nextInt(91) + 10; // [0, 91) -> [10, 101)
        
    }
     
    public void play(){
        System.out.println("The game begins! There are currently " + marbles + " in the pile.");
        // decide who should go first
        boolean computerFirst = r.nextInt(2) == 1;
        // if the computer goes first, have it make a move before the main game loop
        if (computerFirst) {
            System.out.println("The computer will go first.");
            move(computerPlayer);
        }
        // repeat alternating human then computer, until the marble count hits 0
        while (true) {
            move(humanPlayer);
            // if there are no marbles left after the human moves,
            // the human must have taken the last marble, meaning the
            // computer won.
            if (marbles == 0) {
                System.out.println("The computer wins. Better luck next time!");
                break;
            }
            move(computerPlayer);
            // same goes for the computer
            if (marbles == 0) {
                System.out.println("Congratulations, you won! " +
                                   "We're all out of prizes, though.");
                break;
            }

        }
    }
    public void move(Player p) {
        p.move(marbles);
        marbles -= p.getChoice();
        System.out.println("Marbles remaining: " + marbles);
    }
}