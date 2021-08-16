package demo.test20210120;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/3/11
 * @time 1:58 PM
 */
public class Solution92 {


    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode prev=dummyHead;
        ListNode newHead=dummyHead;
        ListNode last=dummyHead;
        for(int i=0;i<left;i++){
            prev=newHead;
            newHead=newHead.next;
        }


        ListNode temp=newHead;
        for(int i=0;i<right;i++){
            last=last.next;

        }

        ListNode tail=last.next;
        last.next=null;

        ListNode p=newHead.next;
        while (p!=null){
            ListNode q=p.next;
            p.next=newHead;
            prev.next=p;
            newHead=p;
            p=q;
        }

        temp.next=tail;

        return dummyHead.next;
    }

    public static void main(String[] args){
        Solution92 solution92 =new Solution92();
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;

        ListNode newHead=solution92.reverseBetween(n1,2,4);
        System.out.println(newHead);

    }
}
