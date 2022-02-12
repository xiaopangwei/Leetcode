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

        ListNode p    = headOdd;
        ListNode q    = headEven;
        ListNode prev = null;

        while (true) {
            if (q == null) {
                break;
            }
            p.next = q.next;
            prev = p;
            p = q.next;

            if (p == null) {
                break;
            }
            q.next = p.next;
            q = p.next;
        }

        if (p == null) {
            prev.next = headEven;
        } else {
            p.next = headEven;
        }
        return headOdd;
    }

    public static void main(String[] args){
        ListNode head=ListNode.ofArray("[1,2]");
        Solution328 solution328=new Solution328();
        ListNode newHead=solution328.oddEvenList(head);
        System.out.println(newHead);
    }
}
