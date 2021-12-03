 /*****************************************
 * A template for a computer Nim player
 ****************************************/ 

import java.util.Random;

public class Computer implements Player{
    
    private int mode;
    private int choice;
    private Random r;
    
    public Computer(int m){
        mode = m;
        choice = -1;
        r = new Random();
    }
    
    public void move(int marblesLeft){

        // Find the largest power of two less than marblesLeft
        int powerOfTwo = 1;
        while (powerOfTwo * 2 <= marblesLeft) {
            powerOfTwo *= 2;
        }
        // If the computer is in stupid mode or if marblesLeft is a
        // power of 2 minus 1, make a random move
        if (mode == 1 || marblesLeft == (powerOfTwo * 2) - 1) {
            int maxLegalMove = Math.max(1, marblesLeft / 2);
            int randomMove = r.nextInt(maxLegalMove) + 1;
            choice = randomMove;
        } else {
            // otherwise, take away marbles such that the size of the pile
            // becomes a power of two minus one
            choice = marblesLeft - (powerOfTwo - 1);
        }
        System.out.println("The computer withdrew " + choice + " marble(s)!");
        
    }
    
    
    public int getChoice(){
        return choice;
    }
    
    
}
