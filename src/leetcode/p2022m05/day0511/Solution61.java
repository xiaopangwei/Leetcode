package leetcode.p2022m05.day0511;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/11
 * @time 8:41 PM
 */
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {

        if (head==null) {
            return null;
        }
        ListNode p = head;
        int      n = 0;
        while (p != null) {
            n++;
            p = p.next;
        }

        k = k % n;

        if (k == 0) {
            return head;
        }
        ListNode fast = head;
        for (int i = 0; i < k - 1; i++) {
            if (fast != null) {
                fast = fast.next;
            } else {
                break;
            }
        }
        ListNode prev = null;
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        ListNode newHead = prev.next;
        prev.next = null;
        ListNode last = slow;
        while (last.next != null) {
            last = last.next;
        }
        last.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        Solution61 solution61 = new Solution61();
        ListNode   head       = ListNode.ofArray("[1,2,3,4,5,6]");
        ListNode   newHead    = solution61.rotateRight(head, 4);
        ListNode   p          = newHead;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
