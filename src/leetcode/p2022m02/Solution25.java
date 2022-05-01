package leetcode.p2022m02;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/12
 * @time 3:12 PM
 */
public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }


        ListNode q     = head;
        ListNode p     = head;
        int      count = 1;
        for (int i = 1; i < k; i++) {
            if (p == null) {
                break;
            }
            p = p.next;
            count++;
        }
        ListNode newHead = p;

        if (count < k || p == null) {
            return q;
        } else {
            ListNode nextP = p.next;
            p.next = null;
            ListNode[] temp = reverse(q);
            temp[1].next = reverseKGroup(nextP, k);
        }
        return newHead;

    }

    private ListNode[] reverse(ListNode start) {
        ListNode last = start;
        ListNode prev = null;
        ListNode p    = start;
        while (p != null) {
            ListNode nextP = p.next;
            p.next = prev;
            prev = p;
            p = nextP;
        }
        return new ListNode[]{prev, last};
    }


    public static void main(String[] args) {
        Solution25 solution25 = new Solution25();
        ListNode   head       = solution25.reverseKGroup(ListNode.ofArray("[1,2,3,4,5,6,7,8]"), 3);
        System.out.println(head);

    }
}
