/* F2C.java - add your solutiuon to program 1 of homework 1 here.
 * 
 */

import java.util.Scanner;

public class F2C {
    
    public static final void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a temperature in Farenheit: ");
        
        int tempF = input.nextInt();
        
        int tempC = ((tempF - 32)  * 5) / 9;
        
        System.out.println("That's equivalent to " + tempC + " degrees Celsius!");
        
    }
    
    
}