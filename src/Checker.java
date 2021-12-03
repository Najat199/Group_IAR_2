
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Checker {
    public static boolean isValidCVVNumber(String str)
    {
        // Regex to check valid CVV cardNumber.
        String regex = "^[0-9]{3,4}$";
 
        // Compile the ReGex
        Pattern p = Pattern.compile(regex);
 
        // If the string is empty
        // return false
        if (str == null)
        {
            return false;
        }
 
        // Find match between given string
        // and regular expression
        // using Pattern.matcher()
 
        Matcher m = p.matcher(str);
 
        // Return if the string
        // matched the ReGex
        return m.matches();
    }
    
    public static boolean isValidCardNumber(String cardNum)
    {   try{
        long cardNumber =Long.parseLong(cardNum);
        return (getSize(cardNumber) >= 13 &&
               getSize(cardNumber) <= 16) &&
               (prefixMatched(cardNumber, 4) ||
                prefixMatched(cardNumber, 5) ||
                prefixMatched(cardNumber, 37) ||
                prefixMatched(cardNumber, 6)) &&
              ((sumOfDoubleEvenPlace(cardNumber) +
                sumOfOddPlace(cardNumber)) % 10 == 0);
            }
       catch(Exception e){
        return false; 
       }
      
    }
 
    public static int sumOfDoubleEvenPlace(long cardNumber)
    {
        int sum = 0;
        String num = cardNumber + "";
        for (int i = getSize(cardNumber) - 2; i >= 0; i -= 2)
            sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);
        return sum;
    }
 
    // Return the number if it is a single digit, otherwise,
    // return the sum of the two digits
    public static int getDigit(int number)
    {
        if (number < 9)
            return number;
        return number / 10 + number % 10;
    }
 
    // Return sum of odd-place digits in cardNumber
    public static int sumOfOddPlace(long cardNumber)
    {
        int sum = 0;
        String num = cardNumber + "";
        for (int i = getSize(cardNumber) - 1; i >= 0; i -= 2)
            sum += Integer.parseInt(num.charAt(i) + "");       
        return sum;
    }
    
    // Return true if the prefix parameter is the correct prefix for that card cardNumber
    public static boolean prefixMatched(long cardNumber, int prefix)
    {
        return getPrefix(cardNumber, getSize(prefix)) == prefix;
    }
 
    // Return the number of digits in a card number
    public static int getSize(long cardNumber)
    {
        String num = cardNumber + "";
        return num.length();
    }
 
    //Return prefix of cardNumber with the required size
    // If the cardNumber size is less than
    //sizeOfThePrefix, return cardNumber.
    public static long getPrefix(long cardNumber, int sizeOfThePrefix)
    {
        if (getSize(cardNumber) > sizeOfThePrefix) {
            String num = cardNumber + "";
            return Long.parseLong(num.substring(0, sizeOfThePrefix));
        }
        return cardNumber;
    } 
}
