/* Aman Choudhri
 * ac4972
 * Zipcode.java - convert between zip codes and barcodes
 */

public class Zipcode{
    private String barcode = null;
    private int ZIPcode = -1;
    
    private String[] encoding = {
        "||:::", ":::||", "::|:|", "::||:", ":|::|",
        ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"
        };
    
    public Zipcode(int ZIPcode) {
        this.ZIPcode = ZIPcode;
        int[] zipDigits = getZipDigits();
        String barcodeBuilder = "";
        for (int digit : zipDigits) {
            barcodeBuilder += encoding[digit];
        }
        // add the frame bars
        barcode = "|" + barcodeBuilder + "|";
    }

    public Zipcode(String barcode) {
        this.barcode = barcode;
        String digits = "";
        // Iterate through each substring for a zip code digit
        for (int i = 1; i < barcode.length() - 1; i += 5) {
            System.out.println(digits);
            System.out.println(i);
            String digitString = barcode.substring(i, i+5);
            boolean stringValid = false;
            // compare the substring with all valid digit encodings
            for (int j = 0; j < encoding.length; j++) {
                // if the substring is in the array, append the
                // stringified digit to digits
                if (digitString.equals(encoding[j])) {
                    stringValid = true;
                    digits += String.valueOf(j);
                    break;
                }
            }
            // if the substring isn't found in encoding,
            // print an error and return
            if (!stringValid) {
                System.out.println("Invalid digit sequence! " + digitString);
                return;
            }
        }
        // finally, make sure the check digit is valid for the zip code
        int zip = Integer.parseInt(
            digits.substring(0, digits.length() - 1)
        );
        int providedCheck = Character.getNumericValue(
            digits.charAt(digits.length() - 1)
        );

        int correctCheck = calculateCheckDigit(zip);
        if (providedCheck != correctCheck) {
            System.out.println("Invalid check digit! Expected: " + correctCheck +
                              ". Encountered: " + providedCheck);
            return;
        }

        ZIPcode = zip;
    }

    private static int calculateCheckDigit(int zip) {
        String zipString = String.valueOf(zip);
        int total = 0;
        for (int i = 0; i < zipString.length(); i++) {
            total += Character.getNumericValue(zipString.charAt(i));
        }
        // Find a number <= 10 such that if this number is added to the total,
        // the result would be a multiple of 10
        int checkDigit = 10 - (total % 10);
        // if total % 10 = 0, checkDigit would store 10. use modulus to convert that to 0
        checkDigit %= 10;
        return checkDigit;
    }

    private int[] getZipDigits() {
        int check = calculateCheckDigit(ZIPcode);
        String zipAndCheck = String.valueOf(ZIPcode) + String.valueOf(check);
        // if the zipcode begins with a zero, the zero will get lost
        // when converting to a string, so we prepend zipAndCheck
        // with 0's until it reaches the correct length
        if (zipAndCheck.length() < 6) {
            for (int i = 0; i <= 6 - zipAndCheck.length(); i++) {
                zipAndCheck = "0" + zipAndCheck;
            }
        }
        int[] digits = new int[zipAndCheck.length()];
        for (int i = 0; i < zipAndCheck.length(); i++) {
            digits[i] = Character.getNumericValue(zipAndCheck.charAt(i));
        }
        return digits;
    }
    
    public String getBarcode() {
        return barcode;
    }
    
    public int getZIPcode() {
        return ZIPcode;
    }
}