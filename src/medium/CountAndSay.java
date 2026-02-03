package medium;

/**
 * QUESTION:
 * The count-and-say sequence is a sequence of digit strings defined by the
 * recursive formula:
 *
 * countAndSay(1) = "1"
 * countAndSay(n) is the way you would "say" the digit string from
 * countAndSay(n-1), which is then converted into a different digit string.
 *
 * To determine how you "say" a digit string, split it into the minimal number
 * of groups so that each group is a contiguous section all of the same digit.
 * Then for each group, say the number of digits, followed by the digit. Finally,
 * concatenate every group's "said" digits together to get the next term in the
 * sequence.
 *
 * Given a positive integer n, return the nth term of the count-and-say sequence.
 *
 * @author m.yusufsonmez03@gmail.com
 **/

public class CountAndSay {
    public static String countAndSay(int n) {
        String s = "1";
        while (n > 1) {
            StringBuilder newS = new StringBuilder();
            int counter = 1;
            int i = 1;
            for(i = 1; i < s.length(); i++) {
                if(s.charAt(i) == s.charAt(i-1)) {
                    counter++;
                } else {
                    newS.append(counter).append(s.charAt(i-1));
                    counter = 1;
                }
            }
            newS.append(counter).append(s.charAt(i-1));
            s = newS.toString();
            n--;
        }
        return s;
    }

    public static void main(String[] args) {
        int n = 4;
        String result = countAndSay(n);
        System.out.println(result);
    }
}