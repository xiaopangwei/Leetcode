package leetcode.p2022m02;

import common.ListNode;

import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/12
 * @time 3:43 PM
 */
public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode p       = head;

        while (p != null) {
            ListNode q = p.next;
            while (q != null && p.val == q.val) {
                q = q.next;
            }
            p.next = q;
            p = q;
        }
        return head;
    }

    public static void main(String[] args){
        Solution82 solution82=new Solution82();
        ListNode head=solution82.deleteDuplicates(ListNode.ofArray("[1,1,2,2,2,3]"));
        System.out.println(head);
    }
}
