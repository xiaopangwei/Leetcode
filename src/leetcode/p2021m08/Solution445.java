package leetcode.p2021m08;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/31
 * @time 10:52 PM
 */
public class Solution445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int len1 = getLength(l1);
        int len2 = getLength(l2);

        if (len1 != len2) {
            int m = Math.abs(len1 - len2);
            if (len1 > len2) {
                while (m > 0) {
                    ListNode p = new ListNode(0);
                    p.next = l2;
                    l2 = p;
                    m--;
                }
            } else {
                while (m > 0) {
                    ListNode p = new ListNode(0);
                    p.next = l1;
                    l1 = p;
                    m--;
                }
            }
        }

        ListNode r1 = reverse(l1);
        ListNode r2 = reverse(l2);

        ListNode newHead = new ListNode(-1);
        ListNode r       = newHead;
        int      carry   = 0;

        ListNode p = r1;
        ListNode q = r2;
        while (p != null && q != null) {
            int sum = p.val + q.val + carry;
            carry = sum / 10;
            int num = sum % 10;
            r.next = new ListNode(num);
            r = r.next;

            p = p.next;
            q = q.next;
        }


        while (carry != 0) {
            int temp = carry % 10;
            r.next = new ListNode(temp);
            r = r.next;
            carry = carry / 10;
        }

        return reverse(newHead.next);
    }

    private int getLength(ListNode head) {

        int      count = 0;
        ListNode p     = head;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }


    private ListNode reverse(ListNode l1) {
        ListNode prev = null;
        ListNode p    = l1;
        while (p != null) {
            ListNode nextP = p.next;
            p.next = prev;
            prev = p;
            p = nextP;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode    l1          = ListNode.ofArray("[0]");
        ListNode    l2          = ListNode.ofArray("[0]");
        Solution445 solution445 = new Solution445();
        ListNode    res         = solution445.addTwoNumbers(l1, l2);

        ListNode p = res;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
