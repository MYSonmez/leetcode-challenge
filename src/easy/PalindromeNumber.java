package easy;

/**
 * Given an integer x, return true if x is a palindrome , and false otherwise.
 *
 * @author @author m.yusufsonmez03@gmail.com
 */

public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        String strX = Integer.toString(x);
        int strXLen = strX.length();
        for (int i = 0; i < strXLen / 2; i++) {
            if (strX.charAt(i) != strX.charAt(strXLen - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isPalindrome(993299);
    }
}
