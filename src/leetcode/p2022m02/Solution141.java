package leetcode.p2022m02;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/7
 * @time 7:30 PM
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head==null || head.next==null){
            return true;
        }
        ListNode slow=head,fast=head;

        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){
                return true;
            }
        }

        return false;
    }
}
