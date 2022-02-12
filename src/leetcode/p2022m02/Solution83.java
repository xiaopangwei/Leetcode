package leetcode.p2022m02;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/12
 * @time 3:43 PM
 */
public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        if (head.val != head.next.val) {
            head.next = deleteDuplicates(head.next);
            return head;
        } else {
            ListNode p = head;
            while (p != null && p.val == head.val) {
                p = p.next;
            }
            return deleteDuplicates(p);
        }
    }

    public static void main(String[] args) {
        Solution83 solution83 = new Solution83();
        ListNode   head       = solution83.deleteDuplicates(ListNode.ofArray("[1,2,3]"));
        System.out.println(head);
    }
}
