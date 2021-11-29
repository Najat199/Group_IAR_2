import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checker {

    public static boolean isEmpty(String str) {
        return str.trim().length() == 0;
    }

    public static boolean isOnlyNumbers(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isOnlyLetters(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isAlphabetic(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isOnlyNumbersAndLetters(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isAlphabetic(str.charAt(i)) && !Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isExactLength(String str, int length) {
        return str.length() == length;
    }

    public static boolean isMinLength(String str, int length) {
        return str.length() >= length;
    }

    public static boolean isValidDate(String str) {
        SimpleDateFormat parser = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = parser.parse(str);
        } catch (ParseException ex) {
        }

        return date != null;
    }

    public static boolean isValidAddress(String str) {
        if (isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isAlphabetic(str.charAt(i)) && !Character.isDigit(str.charAt(i)) && !Character.isSpaceChar(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    

}
