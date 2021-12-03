/** Change.java - add your solutiuon to program 3 of homework 1 here.
 * 
 */
import java.util.Scanner;

public class Change {
    
    public static final void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the amount due (in pennies): ");
        int amtDue = input.nextInt();
        
        System.out.print("Enter the amount recieved (in pennies): ");
        int amtRecieved = input.nextInt();
        
        // Keep a running total of how much change still needs to be given
        int amtLeft = amtRecieved - amtDue;
        
        // Define the denominations that will be returned and the names associated with each
        int[] denominations = {100, 25, 10, 5, 1};
        String[] names = {"Dollars", "Quarters", "Dimes", "Nickels", "Pennies"};
        
        for (int i = 0; i < denominations.length; i++) {
            // Calculate the quantity to return of the current denomination
            int numDenomination = amtLeft / denominations[i];
            // Update the amount of remaining balance
            amtLeft -= numDenomination * denominations[i];
            System.out.println(names[i] + ": " + numDenomination);
        }
    }
    
    
}