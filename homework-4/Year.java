/* 
 * Aman Choudhri
 * ac4972
 * 
 * Year.java represents a calendar year and contains a method that determines if
 * the year is a leap year.
 * 
 */

public class Year{
    
    private int year;

    public Year(int y){
        year = y;
    }


    public boolean isLeapYear(){
        
        // If year is divisible by 4 and not by 100, or is divisible by 400
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        }
        
        return false;
        
    }

}    

