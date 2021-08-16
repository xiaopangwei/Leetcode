package leetcode.p2021m06.p20210614;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/18
 * @time 1:50 PM
 */
public class Solution160 {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA=getCount(headA);
        int countB=getCount(headB);
        int sum=countA+countB;

        if (countA==0||countB==0){
            return null;
        }

        if(countA==1 && countB==1){
            if (headA==headB){
                return headA;
            }else{
                return null;
            }
        }
//        System.out.println(sum);
        ListNode p=headA;
        ListNode q=headB;
        if (p==q){
            return p;
        }
        for (int i=0;i<sum;i++){
            ListNode pNext=p.next;

            if (pNext!=null){
                p=pNext;
            }else{
                p=headB;
            }

            ListNode qNext=q.next;
            if (qNext!=null){
                q=qNext;
            }else{
                q=headA;
            }

            if (p==q){
                return p;
            }
        }

        if (p!=q){
            return null;
        }else{
            return p;
        }
    }


    private int getCount(ListNode head){
      ListNode p=head;
      int count=0;
      while (p!=null){
          count++;
          p=p.next;
      }
      return count;
    }

    public static void main(String[] args){
        Solution160 solution14=new Solution160();
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);

        n1.next=n2;



//        ListNode n6=new ListNode(6);
//        ListNode n7=new ListNode(7);
//        ListNode n8=new ListNode(8);
//        n6.nextMap=n7;
//        n7.nextMap=n8;
//
//        ListNode n1=new ListNode(1);
//        ListNode n2=new ListNode(2);
//        ListNode n3=new ListNode(3);
//        n1.nextMap=n2;
//        n2.nextMap=n3;
//
//        ListNode n4=new ListNode(4);
//        ListNode n5=new ListNode(5);
//        n4.nextMap=n5;
//
//        n3.nextMap=n6;
//        n5.nextMap=n6;

        ListNode intersectionNode=solution14.getIntersectionNode(n1,n1);
        if (intersectionNode!=null){
            System.out.println(intersectionNode.val);
        }else{
            System.out.println("NULL");
        }
    }
}
