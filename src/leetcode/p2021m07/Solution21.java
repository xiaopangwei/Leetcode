package leetcode.p2021m07;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/30
 * @time 5:38 PM
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode newHead=new ListNode(-1);
        ListNode p1=l1;
        ListNode p2=l2;
        ListNode p3=newHead;
        while (p1!=null && p2!=null){
            if (p1.val<p2.val){
                p3.next=p1;
                p3=p1;
                p1=p1.next;

            }else if (p1.val>p2.val){
                p3.next=p2;
                p3=p2;
                p2=p2.next;
            }else{

                ListNode nextP1=p1.next;
                ListNode nextP2=p2.next;

                p3.next=p1;
                p3=p1;
                p1=nextP1;

                p3.next=p2;
                p3=p2;
                p2=nextP2;
            }
        }

        if (p1!=null) {
            p3.next = p1;
        }
        if (p2!=null){
            p3.next=p2;
        }
        return newHead.next;
    }

    public static void main(String[] args){
        Solution21 solution21=new Solution21();
        ListNode head=solution21.mergeTwoLists(ListNode.ofArray("[1,2,4]"),ListNode.ofArray("[1,3,4]"));
        System.out.println(head);
    }

}
