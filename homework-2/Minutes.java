/** Minutes.java - add your solutiuon to program 2 of homework 1 here.
 * 
 */
import java.util.Scanner;

public class Minutes {
    
    static Scanner input = new Scanner(System.in);
    
    public static final void main(String[] args) {
        
        int hours = getNum("hours");
        int days = getNum("days");
        int weeks = getNum("weeks");
        int years = getNum("years");
        
        // Convert the given combination of units into hours
        weeks += years * 52;
        days += weeks * 7;
        hours += days * 24;
        
        System.out.println("That's equivalent to " + hours * 60 + " minutes!");
        
    }
    
    /* Prompt user to enter how many of a given time unit
     * should be used to calculate the final total.
     * @param unit The string name of the desired unit.
     * @return The number of units to use.
     */
    static int getNum(String unit) {
        System.out.print("How many " + unit + "? ");
        return input.nextInt();
    }
}