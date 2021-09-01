package leetcode.p2021m08;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/29
 * @time 9:14 PM
 */
public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null) {
            return null;
        }

        ListNode prev  = null;
        ListNode p     = head;
        int      count = 0;
        while (p != null && count < k) {
            prev = p;
            p = p.next;
            count++;
        }

        ListNode nextP = p;
        if (count < k) {
            return head;
        } else {
            ListNode newHead = reverseKGroup(nextP, k);
            if (prev != null) {
                prev.next = null;
            }
            ListNode temp = reverse(head);

            ListNode q = head;
            while (q.next != null) {
                q = q.next;
            }
            q.next = newHead;
            return temp;
        }

    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode p    = head;
        while (p != null) {
            ListNode nextP = p.next;
            p.next = prev;
            prev = p;
            p = nextP;
        }

        return prev;
    }

    public static void main(String[] args) {
        Solution25 solution25 = new Solution25();
        ListNode   head       = ListNode.ofArray("[1,2,3,4,5,6]");
        head = solution25.reverseKGroup(head,6);
        ListNode p = head;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
