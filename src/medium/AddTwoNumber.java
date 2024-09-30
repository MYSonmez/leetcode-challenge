package medium;

import java.math.BigInteger;

/**
 * QUESTION:
 * You are given two non-empty linked lists representing two
 * non-negative integers. The digits are stored in reverse order, and each of
 * their nodes contains a single digit. Add the two numbers and return the sum
 * as a linked list. You may assume the two numbers do not contain any leading
 * zero, except the number 0 itself.
 *
 * @author m.yusufsonmez03@gmail.com
 */
public class AddTwoNumber {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        char[] charArr = CountTotal(l1).add(CountTotal(l2)).toString().toCharArray();
        int totalAsStringLen = charArr.length;
        ListNode l3 = new ListNode(Integer.parseInt(Character.toString(charArr[totalAsStringLen - 1])));
        ListNode temp = l3;
        for (int i = totalAsStringLen - 2; i >= 0; i--) {
            l3.next = new ListNode(Integer.parseInt(Character.toString(charArr[i])));;
            l3 = l3.next;
        }
        return temp;
    }

    private static BigInteger CountTotal(ListNode node) {
        BigInteger decimalPower = BigInteger.ONE;
        BigInteger total = BigInteger.ZERO;
        while (node != null) {
            total = total.add(decimalPower.multiply(new BigInteger(String.valueOf(node.val))));
            decimalPower = decimalPower.multiply(BigInteger.TEN);
            node = node.next;
        }

        return total;
    }

}

class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
