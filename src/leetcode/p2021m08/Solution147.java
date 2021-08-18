package leetcode.p2021m08;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/18
 * @time 5:03 PM
 */
public class Solution147 {
    public ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head;
        ListNode p = head.next;
        newHead.next=null;
        while (p != null) {

            ListNode nextP  = p.next;
            int      target = p.val;
            ListNode q      = newHead;


            if (target <= newHead.val) {
                p.next = newHead;
                newHead = p;
            } else {
                ListNode prev = null;
                while (q != null) {
                    if (q.val < target) {
                        prev = q;
                        q = q.next;
                    } else {
                        break;
                    }
                }

                p.next = q;
                if (prev != null) {
                    prev.next = p;
                }
            }

            p = nextP;

        }
        return newHead;
    }

    public static void main(String[] args) {
        Solution147 solution147 = new Solution147();
        ListNode head=ListNode.ofArray("[1,1,2,2,2]");
        ListNode    p           = solution147.insertionSortList(head);

        ListNode q = p;

        while (q != null) {
            System.out.println(q.val);
            q = q.next;
        }
    }
}
