package leetcode.p2021m08;

import example.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/15
 * @time 6:00 PM
 */
public class Solution86 {
    public ListNode partition(ListNode head, int x) {

        if (head == null) {
            return null;
        }
        ListNode smallerHead = new ListNode(-1);
        ListNode biggerHead  = new ListNode(-2);

        ListNode smallerLast = smallerHead;
        ListNode biggerLast  = biggerHead;

        ListNode p = head;

        while (p != null) {
            ListNode nextP = p.next;
            if (p.val < x) {
                smallerLast.next = p;
                smallerLast = p;
            } else {
                biggerLast.next = p;
                biggerLast = p;
            }
            p = nextP;
        }

        biggerLast.next=null;

        smallerLast.next = biggerHead.next;

        return smallerHead.next;

    }

    public static void main(String[] args) {
        ListNode head = ListNode.ofArray("[2,1]");

        Solution86 solution86 = new Solution86();
        ListNode   newHead    = solution86.partition(head, 0);
        ListNode   p          = newHead;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
