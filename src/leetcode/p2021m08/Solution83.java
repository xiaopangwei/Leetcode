package leetcode.p2021m08;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/2
 * @time 11:41 PM
 */
public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode p = head;
        while (p != null) {
            int      val = p.val;
            ListNode q   = p.next;
            while (q!=null && q.val == val) {
                q = q.next;
            }
            if (p.next != q) {
                p.next = q;
            }
            p = p.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Solution83 solution83 = new Solution83();
        ListNode   head       = ListNode.ofArray("[1,1]");
        ListNode   newHead    = solution83.deleteDuplicates(head);
        ListNode   temp       = newHead;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
