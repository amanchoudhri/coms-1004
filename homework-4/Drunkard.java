/* 
 * Aman Choudhri
 * ac4972
 * 
 * Drunkard.java represents an entity that randomly walks along the x and y axes.
 * 
 */

import java.util.Random;

public class Drunkard {
    
    private int initialX, initialY, currX, currY;
    
    public Drunkard(int x, int y) {
        initialX = x;
        initialY = y;

        currX = x;
        currY = y;
    }
    
    /* Return a string describing the drunkard's
     * current location.
     */
    public String getLocation() {
        return "(" + currX + ", " + currY + ")";
    }
    
    /* Have the drunkard walk one unit in a random
     * vertical or horizontal direction.
     */
    public void step() {
        Random r = new Random();
        switch (r.nextInt(4)) {
            case 0:
                currX++;
                break;
            case 1:
                currX--;
                break;
            case 2:
                currY++;
                break;
            case 3:
                currY--;
                break;
        }
    }
    
    /* Have the drunkard step the given integer
     * number of times
     */
    public void fastForward(int steps) {
        for (int i = 0; i < steps; i++) {
            this.step();
        }
    }
    
    /* Return the Manhattan distance between the
     * drunkard'scurrent and initial positions.
     */
    public int howFar() {
        int deltaX = Math.abs(currX - initialX);
        int deltaY = Math.abs(currY - initialY);
        return deltaX + deltaY;
    }
}