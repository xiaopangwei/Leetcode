package leetcode.p2022m01;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/24
 * @time 9:34 PM
 */
public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p    = dummy;
        ListNode prev = null;
        for (int i = 0; i < left; i++) {
            prev = p;
            p = p.next;
        }

        ListNode temp = p;
        for (int i = left; i < right; i++) {
            p = p.next;
        }
        ListNode nextP = p.next;
        p.next = null;
        ListNode newHead = reverse(temp);
        if (prev != null) {
            prev.next = newHead;
        }

        temp.next = nextP;

        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
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

    public static void main(String[] args) {
        Solution92 solution92 = new Solution92();
        ListNode   L          = ListNode.ofArray("[5,6]");
//        ListNode R=solution92.reverse(L);
//        System.out.println(R);
        ListNode head = solution92.reverseBetween(L, 1, 2);
        ListNode p    = head;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
