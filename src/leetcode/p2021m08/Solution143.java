package leetcode.p2021m08;

import example.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/10
 * @time 3:28 PM
 */
public class Solution143 {
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        ListNode prev = null;
        while (true) {

            prev = slow;
            slow = slow.next;
            if (fast == null || fast.next == null) {
                break;
            }
            fast = fast.next.next;
        }

        prev.next = null;
        //reverse
        ListNode p = slow;

        ListNode newHead = reverse(p);


        p = head;
        ListNode q = newHead;

        while (p != null && q != null) {
            ListNode nextP = p.next;
            ListNode nextQ = q.next;
            p.next = q;
            q.next = nextP;
            p = nextP;
            q = nextQ;
        }

    }

    private ListNode reverse(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {

            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        Solution143 solution143 = new Solution143();
        ListNode head=ListNode.ofArray("[1,2,3]");
        solution143.reorderList(head);
        System.out.println(head);

    }
}
