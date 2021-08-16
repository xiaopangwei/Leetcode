package leetcode.p2021m07;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/29
 * @time 11:12 PM
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode ansHead=new ListNode(-1);
        ListNode p1=l1;
        ListNode p2=l2;
        ListNode p3=ansHead;

        int n1=0;
        int n2=0;

        ListNode t1=l1;
        ListNode t2=l2;

        while (p1!=null){
            n1++;
            if (p1.next==null){
                t1=p1;
            }
            p1=p1.next;

        }

        while (p2!=null){
            n2++;
            if (p2.next==null){
                t2=p2;
            }
            p2=p2.next;

        }

        int gap=Math.abs(n1-n2);
        if (gap!=0){
            if (n1>n2){
                for (int i=0;i<gap;i++){
                    ListNode node=new ListNode(0);
                    t2.next=node;
                    t2=node;
                }
            }else{
                for (int i=0;i<gap;i++){
                    ListNode node=new ListNode(0);
                    t1.next=node;
                    t1=node;
                }
            }
        }

        p1=l1;
        p2=l2;

        int carry=0;

        while (p1!=null && p2!=null){
            int sum=p1.val+p2.val+carry;
            ListNode node=new ListNode(sum%10);
            p3.next=node;
            p3=node;
            carry=sum/10;

            p1=p1.next;
            p2=p2.next;
        }

        while (carry!=0){
            ListNode node=new ListNode(carry%10);
            p3.next=node;
            p3=node;
            carry=carry/10;
        }
        return ansHead.next;
    }

    public static void main(String[] args){
        ListNode head1=new ListNode(9);
//        ListNode l12=new ListNode(3);
//        ListNode l13=new ListNode(2);
//        ListNode l14=new ListNode(1);
//        head1.nextMap=l12;
//        l12.nextMap=l13;
//        l13.nextMap=l14;
        ListNode p1=head1;
        for (int i=0;i<6;i++){
            p1.next=new ListNode(9);
            p1=p1.next;
        }

        ListNode head2=new ListNode(9);
        ListNode p2=head2;
        for (int i=0;i<3;i++){
            p2.next=new ListNode(9);
            p2=p2.next;
        }
//        ListNode l22=new ListNode(8);
//        ListNode l23=new ListNode(9);
//        head2.nextMap=l22;
//        l22.nextMap=l23;

        Solution2 solution2=new Solution2();
        ListNode newHead=solution2.addTwoNumbers(head1,head2);

        ListNode temp=newHead;
        while (temp!=null){
            System.out.println(temp.val);
            temp=temp.next;
        }


    }
}
