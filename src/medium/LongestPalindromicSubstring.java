package medium;

/**
 * QUESTION:
 * Given a string 's', return the longest palindromic substring in 's'.
 * 
 * @author m.yusufsonmez03@gmail.com
 */

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        int length = s.length();
        String longestString = "";
        int longestStringLength = 0;
        for (int left = 0; left < length; left++) {
            for (int right = length; right >= left; right--) {
                if (isPalindrome(s, left, right - 1) && longestStringLength < (right - left)) {
                    longestString = s.substring(left, right);
                    longestStringLength = longestString.length();
                }
            }
        }
        return longestString;

    }

    public static boolean isPalindrome(String s, int l, int r) {
        while (r > l) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        longestPalindrome("badbadabda");
    }
}
