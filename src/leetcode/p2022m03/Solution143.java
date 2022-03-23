package leetcode.p2022m03;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/2
 * @time 8:44 PM
 */
public class Solution143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode temp   = findMiddle(head);
        ListNode p      = head;
        ListNode second = temp.next;
        temp.next = null;
        ListNode reversedList = reverse(second);
        ListNode q            = reversedList;
        ListNode newHead      = new ListNode(-1);

        ListNode r = newHead;
        while (p != null && q != null) {
            ListNode nextP = p.next;
            ListNode nextQ = q.next;
            r.next = p;
            r = p;
            p = nextP;


            r.next = q;
            r = q;
            q = nextQ;
        }

        if (p != null) {
            r.next = p;
        }

        if (q != null) {
            r.next = q;
        }

    }

    private ListNode reverse(ListNode head) {
        ListNode p    = head;
        ListNode prev = null;
        while (p != null) {
            ListNode nextP = p.next;
            p.next = prev;
            prev = p;
            p = nextP;
        }
        return prev;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Solution143 solution143 = new Solution143();
        ListNode    head        = ListNode.ofArray("[1,2,3,4]");
        solution143.reorderList(head);

        ListNode p = head;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }

    }
}
