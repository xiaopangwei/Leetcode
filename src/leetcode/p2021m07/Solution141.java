package leetcode.p2021m07;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/24
 * @time 1:36 PM
 */
public class Solution141 {


    public boolean hasCycle(ListNode head) {

       if (head==null || head.next==null){
           return false;
       }
       ListNode slow=head;
       ListNode fast=head.next;

       while (slow!=fast){
           if (fast==null || fast.next==null){
               return false;
           }
           slow=slow.next;
           fast=fast.next.next;
       }

       return true;
    }

    public static void main(String[] args){
        Solution141 solution141=new Solution141();
        ListNode head=new ListNode(1);
        ListNode second=new ListNode(2);
        head.next=second;
        second.next=null;
        System.out.println(solution141.hasCycle(head));
    }
}
