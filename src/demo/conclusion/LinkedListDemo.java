package demo.conclusion;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/16
 * @time 3:45 PM
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        ListNode head1 = ListNode.ofArray("[1,3,5,7,100,200]");
        ListNode head2 = ListNode.ofArray("[2,4,6]");

        ListNode newHead=new ListNode(-1);

        ListNode p=newHead;

        ListNode p1=head1;
        ListNode p2=head2;

        while (p1!=null && p2!=null){
            if (p1.val<p2.val){
                p.next=p1;
                p=p1;
                p1=p1.next;
            }else if (p1.val>p2.val){
                p.next=p2;
                p=p2;
                p2=p2.next;
            }else{
                p.next=p1;
                p=p1;
                p1=p1.next;
                p.next=p2;
                p=p2;
                p2=p2.next;
            }
        }

        while (p1!=null){
            p.next=p1;
            p=p1;
            p1=p1.next;
        }

        while (p2!=null){
            p.next=p2;
            p=p2;
            p2=p2.next;
        }


        ListNode q=newHead.next;

        while (q!=null){
            System.out.println(q.val);
            q=q.next;
        }
    }


}
