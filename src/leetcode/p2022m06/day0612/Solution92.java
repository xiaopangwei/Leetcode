package leetcode.p2022m06.day0612;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/12
 * @time 10:32 PM
 */
public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        ListNode last = prev.next;

        for (int i = 0; i < right - left; i++) {
            ListNode next = last.next;
            last.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution92 solution92 = new Solution92();
        ListNode   node       = solution92.reverseBetween(ListNode.ofArray("[3,5]"), 1, 2);
        System.out.println(node.val);
    }
}
