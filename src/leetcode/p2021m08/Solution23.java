package leetcode.p2021m08;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/11
 * @time 4:27 PM
 */
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        } else if (lists.length <= 1) {
            return lists[0];
        }


        return sort(lists, 0, lists.length - 1);
    }

    private ListNode sort(final ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int      mid   = (start + end) / 2;
        ListNode left  = sort(lists, start, mid);
        ListNode right = sort(lists, mid + 1, end);
        ListNode ans   = mergeBiList(left, right);
        return ans;
    }

    private ListNode mergeBiList(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(-1);
        ListNode p     = a;
        ListNode q     = b;

        ListNode newHead = dummy;
        while (p != null && q != null) {
            ListNode nextP = p.next;
            ListNode nextQ = q.next;
            if (p.val < q.val) {
                dummy.next = p;
                dummy = p;
                dummy.next = null;
                p = nextP;
            } else if (q.val < p.val) {
                dummy.next = q;
                dummy = q;
                dummy.next = null;
                q = nextQ;
            } else {
                dummy.next = p;
                dummy = p;
                dummy.next = null;
                p = nextP;
                dummy.next = q;
                dummy = q;
                dummy.next = null;
                q = nextQ;
            }
        }

        if (p != null) {
            dummy.next = p;
        }

        if (q != null) {
            dummy.next = q;
        }

        return newHead.next;
    }

    private void print(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

    public static void main(String[] args) {
        Solution23 solution23 = new Solution23();
        ListNode[] lists      = new ListNode[1];
        lists[0] = ListNode.ofArray("[]");
//        lists[1] = ListNode.ofArray("[]");
//        lists[2] = ListNode.ofArray("[2,6]");
//
//        ListNode newHead = solution23.mergeBiList(lists[1], lists[2]);
//
        ListNode newHead = solution23.mergeKLists(null);
        solution23.print(newHead);
    }
}
