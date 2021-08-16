package leetcode.p2021m07;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/26
 * @time 4:34 PM
 */
public class Solution328 {



    public ListNode oddEvenList(ListNode head) {
         if (head==null){
             return null;
         }
        ListNode p=head;
        ListNode q=head.next;


        if (q==null){
            return head;
        }
        ListNode head1=p;
        ListNode head2=q;

        while (q!=null){
            ListNode temp=q.next;
            p.next=temp;
            p=temp;
            if (q!=null && p!=null) {
                q.next = p.next;
            }
            q=p;
        }

        p=head1;
        while (p.next!=null){
            p=p.next;
        }


        p.next=head2;

        return head1;
    }


    public static void main(String[] args){
        Solution328 solution328=new Solution328();
        ListNode head=new ListNode(1);
        ListNode n1=new ListNode(2);
        ListNode n2=new ListNode(3);
        ListNode n3=new ListNode(4);
        ListNode n4=new ListNode(5);

        head.next=n1;
        n1.next=n2;
        n2.next=n3;
//        n3.nextMap=n4;

        ListNode newHead=solution328.oddEvenList(head);
        ListNode temp=newHead;
        while (temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
    }
}
