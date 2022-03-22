package leetcode.p2022m03;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/27
 * @time 9:46 PM
 */
public class Solution86 {

    public ListNode partition(ListNode head, int x) {
        if (head==null){
            return null;
        }
        ListNode biggerHead  = new ListNode(-1);
        ListNode smallerHead = new ListNode(-1);

        ListNode p     = biggerHead;
        ListNode q     = smallerHead;

        ListNode r     = head;
        while (r != null) {
            ListNode nextR = r.next;
            if (r.val < x) {
                q.next = r;
                q = r;
            } else {
                p.next = r;
                p = r;
            }
            r = nextR;
        }

        p.next = null;
        q.next = null;
        q.next = biggerHead.next;


        return smallerHead.next;
    }

    public static void main(String[] args) {
        Solution86 solution86 = new Solution86();
        ListNode   head       = solution86.partition(ListNode.ofArray("[1,4,3,2,5,2]"), 3);
        System.out.println(head);
    }
}
