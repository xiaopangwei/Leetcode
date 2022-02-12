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

        ListNode p     = head;
        ListNode q     = head;
        ListNode prev  = null;
        int      count = 0;
        for (int i = 0; i < k; i++) {
            prev = q;
            if (q == null) {
                break;
            }
            q = q.next;
            count++;
        }

        if (count < k) {
            return p;
        } else {
            if (prev != null) {
                prev.next = null;
            }
            ListNode[] array = reverse(p);
            array[1].next = reverseKGroup(q, k);
            return array[0];
        }
    }

    private ListNode[] reverse(ListNode start) {
        ListNode[] ans  = new ListNode[2];
        ListNode   prev = null;
        ListNode   p    = start;
        while (p != null) {
            ListNode nextP = p.next;
            p.next = prev;
            prev = p;
            p = nextP;
        }
        ans[0] = prev;
        ans[1] = start;
        return ans;
    }

    public static void main(String[] args) {
        Solution25 solution25 = new Solution25();
        ListNode   head       = solution25.reverseKGroup(ListNode.ofArray("[1,2]"), 2);
        System.out.println(head);

    }
}
