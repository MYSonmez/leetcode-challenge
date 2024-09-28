package medium;

import java.math.BigInteger;
import java.util.List;

/**
 * QUESTION? You are given two non-empty linked lists representing two
 * non-negative integers. The digits are stored in reverse order, and each of
 * their nodes contains a single digit. Add the two numbers and return the sum
 * as a linked list. You may assume the two numbers do not contain any leading
 * zero, except the number 0 itself.
 *
 * @author m.yusufsonmez03@gmail.com
 */
public class AddTwoNumber {

    public static void main(String[] args) {
        var l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        var l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        addTwoNumbers(l1, l2);

    }

    private static BigInteger CountTotal(ListNode node) {
        BigInteger decimalPower = BigInteger.ONE;

        BigInteger total = BigInteger.ZERO;
        while (node != null) {
            var ara = decimalPower.multiply(new BigInteger(String.valueOf(node.val)));
            var deger = decimalPower.multiply(ara);
            total.add(decimalPower.multiply(deger));
            decimalPower.multiply(BigInteger.TEN);
            node = node.next;
        }

        return total;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger total1 = CountTotal(l1);
        BigInteger total2 = CountTotal(l2);

        BigInteger total = total1.add(total2);

        String totalAsString = String.valueOf(total);
        int totalAsStringLen = totalAsString.length();
        var charArr = totalAsString.toCharArray();

        ListNode l3 = new ListNode(Integer.parseInt(Character.toString(charArr[totalAsStringLen - 1])));
        ListNode temp = l3;
        for (int i = totalAsStringLen - 2; i >= 0; i--) {
            l3.next = new ListNode(Integer.parseInt(Character.toString(charArr[i])));;
            l3 = l3.next;
        }
        return temp;
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
