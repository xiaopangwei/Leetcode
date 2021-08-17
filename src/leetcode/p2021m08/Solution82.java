package leetcode.p2021m08;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/16
 * @time 4:22 PM
 */
public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode(-1);
        ListNode p       = head;
        ListNode last    = newHead;
        while (p != null) {
            int      target = p.val;
            ListNode q      = p.next;
            if (q != null) {
                if (p.val != q.val) {
                    last.next = p;
                    p.next = null;
                    last = p;
                } else {
                    while (q != null && q.val == target) {
                        q = q.next;
                    }
                }
            } else {
                last.next = p;
                p.next = null;
                last = p;
            }
            p = q;
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        Solution82 solution82 = new Solution82();
        ListNode   node       = ListNode.ofArray("[1]");
        ListNode   ans        = solution82.deleteDuplicates(node);
        System.out.println(ans);
    }
}
