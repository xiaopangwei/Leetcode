package leetcode.p2021m08;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/13
 * @time 11:42 PM
 */
public class Solution876 {
    public ListNode middleNode(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            slow = slow.next;
            if (fast == null || fast.next == null) {
                break;
            }
            fast = fast.next.next;
            if (fast == null || fast.next == null) {
                break;
            }
        }
        return slow;
    }
}
