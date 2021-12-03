/*****************************************
 * A template for a Human Nim player
 ****************************************/ 
import java.util.Scanner;

public class Human implements Player{
   
    private int choice;
    private Scanner input;
    
    public Human(){
        input = new Scanner(System.in);
        choice = -1;
    }
    
    public void move(int marbles) {
        // ask user for a move
        int requestedMove;
        // if there's only one marble left, marbles / 2 rounds down to 0
        // that would imply that the user can't make a move, which isn't true
        // since they can always take 1 marble
        int maxLegalMove = Math.max(1, marbles / 2);
        while (true) {
            // input a move from the player
            System.out.print("Enter how many marbles you'd like to take: ");
            requestedMove = input.nextInt();
            // if the move isn't legal, keep repeating the loop
            // until a legal move is recieved
            if ((0 < requestedMove) && (requestedMove <= maxLegalMove)) {
                // legal move recieved!
                choice = requestedMove;
                return;
            } else {
                System.out.println(
                    "Sorry, that's not a valid move! " + 
                    "Please enter a number between 1 and " +
                    maxLegalMove
                );
            }
        }
    }
    
    
    public int getChoice(){
        return choice;
    }
    
    
}
