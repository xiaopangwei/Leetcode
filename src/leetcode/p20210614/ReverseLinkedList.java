package leetcode.p20210614;

import example.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/18
 * @time 10:52 AM
 */
public class ReverseLinkedList {

  private ListNode reverse(ListNode head){
      ListNode prev=null,next=null;
      ListNode p=head;

      while(p!=null){
          next=p.next;
          p.next=prev;
          prev=p;
          p=next;
      }

      return prev;
  }
  public static void main(String[] args){
      ListNode n1=new ListNode(1);
      ListNode n2=new ListNode(2);
      ListNode n3=new ListNode(3);
//      ListNode n4=new ListNode(4);

      n1.next=n2;
      n2.next=n3;
//      n3.nextMap=n4;
      ReverseLinkedList reverseLinkedList=new ReverseLinkedList();
      ListNode newNode=reverseLinkedList.reverse(n1);
      ListNode p=newNode;
      while (p!=null){
          System.out.println(p.val);
          p=p.next;
      }
  }
}
