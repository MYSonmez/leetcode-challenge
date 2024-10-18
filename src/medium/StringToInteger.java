package medium;

import java.math.BigInteger;

/**
 * QUESTION: 
 * Implement the myAtoi(string s) function, which converts a string to
 * a 32-bit signed integer.
 *
 * The algorithm for myAtoi(string s) is as follows:
 *
 * 1-) Whitespace: Ignore any leading whitespace (" "). 
 * 
 * 2-) Signedness: Determine the sign by checking if the next character is 
 * '-' or '+', assuming positivity is neither present. 
 * 
 * 3-) Conversion: Read the integer by skipping leading zeros until
 * a non-digit character is encountered or the end of the string is reached.
 * If no digits were read, then the result is 0. 
 * 
 * 4-) Rounding: If the integer is out of the 32-bit signed integer 
 * range [-2^31, 2^31 - 1], then round the integer to
 * remain in the range. Specifically, integers less than -231 should be rounded
 * to -2^31, and integers greater than 2^31 - 1 should be rounded to 2^31 - 1.
 * 
 * Return the integer as the final result.
 *
 * @author m.yusufsonmez03@gmail.com
 */

public class StringToInteger {

    public static void main(String[] args) {
        myAtoi("    -48398 4 S+F k7");
    }

    public static int myAtoi(String s) {
        boolean isNegative = false;
        StringBuilder builder = new StringBuilder();
        boolean hasSign = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c <= '9' && c >= '0') {
                builder.append(c);
            } else {
                if (builder.length() > 0 || hasSign) {
                    break;
                } else if (c == ' ') {
                } else if (c == '+') {
                    hasSign = true;
                } else if (c == '-') {
                    isNegative = true;
                    hasSign = true;
                } else {
                    break;
                }
            }
        }
        if (builder.isEmpty()) {
            return 0;
        }
        long result = 0;
        try {
            result = Long.parseLong(builder.toString());
        } catch (NumberFormatException e) {
            return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        if (isNegative) {
            result = -result;
        }
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }
}
