package leetcode.shopee;

import example.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/3/14
 * @time 1:53 PM
 */
public class SolutionReverseLinkedList {


    public ListNode reverseLinkedList (ListNode head, int n) {

        if (head==null || head.next==null){
            return head;
        }
        ListNode p=head;
        int count=0;
        while (p!=null ){
            p=p.next;
            count++;
            if (count%n==0){
                break;
            }
            if (p==null){
                return head;
            }
        }

        ListNode newHead=reverse(head,p);
        head.next=reverseLinkedList(p,n);
        return newHead;

    }

    public ListNode reverse(ListNode head,ListNode tail){

        ListNode p=head;
        ListNode prev=null;
        ListNode next=null;


        while (p!=tail){
            next=p.next;
            p.next=prev;
            prev=p;
            p=next;
        }


        return prev;
    }
    public static void main(String[] args){

        SolutionReverseLinkedList solution  =new SolutionReverseLinkedList();

        ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(2);
        ListNode a3=new ListNode(3);
        ListNode a4=new ListNode(4);
        ListNode a5=new ListNode(5);

        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a4.next=a5;
//
//        ListNode root=a1;
//        ListNode tail=a4;
//
//
//        ListNode newHead=solution.reverse(root,tail);
//
//        System.out.println(newHead);

        ListNode node=solution.reverseLinkedList(a1,1);
        System.out.println(node);


    }



}
