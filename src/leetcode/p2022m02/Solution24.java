package leetcode.p2022m02;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/12
 * @time 2:50 PM
 */
public class Solution24 {

    //[1,2,3,4]
    //[2,1,4,3]
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextHead = head.next.next;
        ListNode newHead = head.next;
        head.next.next = null;
        ListNode temp = swap(head, head.next);
        temp.next = swapPairs(nextHead);
        return newHead;
    }

    private ListNode swap(ListNode a, ListNode b) {
        b.next = a;
        a.next = null;
        return a;
    }

    public static void main(String[] args) {
        ListNode   head       = ListNode.ofArray("[1,2,3,4,5]");
        Solution24 solution24 = new Solution24();
        ListNode   newHead    = solution24.swapPairs(head);
        System.out.println(newHead);
    }
}
