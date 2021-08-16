package leetcode.p2021m08;

import example.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/1
 * @time 2:24 PM
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {

        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode p = null, q = null, r = null;
        p = head;
        q = p.next;
        r = q.next;


        q.next = p;
        p.next = null;

        ListNode temp = swapPairs(r);
        p.next = temp;

        return q;
    }

    public static void main(String[] args) {
        Solution24 solution24 = new Solution24();
        ListNode   root       = ListNode.ofArray("[1,2,3]");
        ListNode   p          = solution24.swapPairs(null);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
