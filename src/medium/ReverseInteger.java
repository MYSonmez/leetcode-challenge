package medium;

/**
 * QUESTION:
 * Given a signed 32-bit integer x, return x with its digits reversed. If
 * reversing x causes the value to go outside the signed 32-bit integer range
 * [-2^31, 2^31 - 1], then return 0.
 * Assume the environment does not allow you to store 64-bit integers 
 * (signed or unsigned).  
 * 
 * @author m.yusufsonmez03@gmail.com
 */
public class ReverseInteger {

    public static int reverse(int x) {
        if (x > -10 && x < 10) {
            return x;
        }

        boolean isNegative = x < 0;

        StringBuilder xBuilder = new StringBuilder();
        xBuilder.append(Math.abs((long) x));
        xBuilder.reverse();

        long reverseX = Long.parseLong(xBuilder.toString());

        if (isNegative) {
            reverseX = -reverseX;
        }

        if (reverseX > Integer.MAX_VALUE || reverseX < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) reverseX;
    }

    public static void main(String[] args) {
        reverse(-2147483648);
    }
}
