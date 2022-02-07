package leetcode.p2022m02;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/7
 * @time 8:18 PM
 */
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode p = headA, q = headB;

        while (p != q) {
            if (p == null) {
                p = headB;
            } else {
                p = p.next;
            }

            if (q == null) {
                q = headA;
            } else {
                q = q.next;
            }

        }

        return p;


    }

    public static void main(String[] args) {
        Solution160 solution160 = new Solution160();
        ListNode    h1          = ListNode.ofArray("[1,2,3]");
        ListNode    h2          = ListNode.ofArray("[4,5]");
        ListNode    node        = solution160.getIntersectionNode(h1, h2);
        System.out.println(node);
    }
}
