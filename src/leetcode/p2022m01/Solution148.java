package leetcode.p2022m01;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/24
 * @time 8:58 PM
 */
public class Solution148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = getMiddle(head);
        ListNode next   = middle.next;
        middle.next = null;

        ListNode left  = sortList(head);
        ListNode right = sortList(next);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode p = left;
        ListNode q = right;

        ListNode dummyHead = new ListNode();
        ListNode r         = dummyHead;
        while (p != null && q != null) {
            if (p.val < q.val) {
                r.next = p;
                p = p.next;
                r = r.next;
            } else if (p.val > q.val) {
                r.next = q;
                q = q.next;
                r = r.next;
            } else {
                r.next = p;
                p = p.next;
                r = r.next;


                r.next = q;
                q = q.next;
                r = r.next;
            }
        }

        if (p != null) {
            r.next = p;
        }

        if (q != null) {
            r.next = q;
        }

        return dummyHead.next;
    }

    private ListNode getMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (fast.next == null || fast.next.next == null) {
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }


    public static void main(String[] args) {
        Solution148 solution148 = new Solution148();
        ListNode    head        = solution148.sortList(ListNode.ofArray("[-1]"));
        ListNode    p           = head;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

}
