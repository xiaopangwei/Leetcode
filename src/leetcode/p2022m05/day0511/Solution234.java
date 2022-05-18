package leetcode.p2022m05.day0511;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/11
 * @time 9:04 PM
 */
public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;


        ListNode prevOfSlow = null;

        while (true) {
            if (fast == null || fast.next == null) {
                break;
            }
            fast = fast.next.next;
            prevOfSlow = slow;
            slow = slow.next;
        }


        ListNode newHead = reverse(slow);

        prevOfSlow.next = null;

        ListNode p = head;
        ListNode q = newHead;
        while (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }

            p = p.next;
            q = q.next;
        }

        return true;

    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode p    = head;
        while (p != null) {
            ListNode nextP = p.next;
            p.next = prev;
            prev = p;
            p = nextP;
        }
        return prev;
    }

    public static void main(String[] args) {
        Solution234 solution234 = new Solution234();
        boolean     ans         = solution234.isPalindrome(ListNode.ofArray("[1,2,2,1]"));
        System.out.println(ans);
    }
}
