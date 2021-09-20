package leetcode.p2021m09;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/16
 * @time 8:47 PM
 */
public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode nextHead = head.next;
        if (head.val == val) {
            return removeElements(nextHead, val);
        } else {
            ListNode temp = removeElements(nextHead, val);
            head.next = temp;
            return head;
        }

    }

    public static void main(String[] args) {
        Solution203 solution203 = new Solution203();
        ListNode    newHead     = solution203.removeElements(ListNode.ofArray("[5,8,7,7,70]"), 7);
        if (newHead == null) {
            System.out.println("NULL");
        }

        ListNode p = newHead;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
