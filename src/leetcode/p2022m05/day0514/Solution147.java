package leetcode.p2022m05.day0514;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/14
 * @time 3:29 PM
 */
public class Solution147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode();
        dummyHead.val = Integer.MIN_VALUE;
        ListNode p = head;
        while (p != null) {
            ListNode nextP = p.next;
            p.next = null;
            ListNode q = dummyHead;

            while (q.next != null) {
                if (q.val <= p.val && p.val <= q.next.val) {
                    ListNode temp = q.next;
                    q.next = p;
                    p.next = temp;
                    break;
                }
                q = q.next;
            }

            if (q.next == null) {
                q.next = p;
            }

            p = nextP;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution147 solution147 = new Solution147();
        ListNode    head        = solution147.insertionSortList(ListNode.ofArray("[4,2,1,3]"));
        ListNode    p           = head;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

}
