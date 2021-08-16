package leetcode.p2021m08;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/13
 * @time 2:50 PM
 */
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null && head.next==null){
            return head;
        }
        int      count = 0;
        ListNode p     = head;
        while (p != null) {
            count++;
            p = p.next;
        }
        k = k % count;
        if (k == 0) {
            return head;
        }
        ListNode slow = head;

        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        p = fast;
        while (p.next != null) {
            p = p.next;
            slow = slow.next;
        }

        ListNode lastNode = slow;
        ListNode newNode  = lastNode.next;
        lastNode.next = null;
        p.next = head;

        return newNode;
    }

    public ListNode getLastKNode(ListNode head, int k) {

        ListNode slow = head;

        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        ListNode p = fast;
        while (p.next != null) {
            p = p.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Solution61 solution61 = new Solution61();
        ListNode   head       = ListNode.ofArray("[0,1,2]");
        ListNode   ans        = null;

        ans = solution61.rotateRight(head, 3);
        ListNode p = ans;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }

    }
}
