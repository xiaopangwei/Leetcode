package leetcode.p2022m02;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/12
 * @time 4:26 PM
 */
public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode headOdd  = head;
        ListNode headEven = head.next;

        ListNode p = headOdd;
        ListNode q = headEven;

        ListNode last = p;

        while (p != null && q != null) {
            last = p;
            p.next = q.next;
            p = q.next;
            if (p != null && q != null) {
                q.next = p.next;
                q = p.next;
            } else {
                break;
            }
        }

        if (p != null) {
            last.next = p;
            last = p;
        }
        last.next = headEven;

        System.out.println(last.val);
        return headOdd;
    }

    public static void main(String[] args) {
        ListNode    head        = ListNode.ofArray("[1,2,3,4,5,6,7]");
        Solution328 solution328 = new Solution328();
        ListNode    newHead     = solution328.oddEvenList(head);
        System.out.println(newHead);
    }
}
