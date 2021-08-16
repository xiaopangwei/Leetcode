package leetcode.p2021m02.p20210209;


import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/9
 * @time 10:19 AM
 */
public class Solution148 {

    public ListNode sortList(ListNode head) {
        ListNode slow=head;
        ListNode quick=head;
        while (quick!=null && quick.next!=null){
            slow=slow.next;
            quick=quick.next;
            if (quick!=null){
                quick=quick.next;
            }
           }
        ListNode middle=slow;
        ListNode p=head;
        while (p!=null && p.next!=middle){
            p=p.next;
        }
        if (p!=null) {
            p.next = null;
        }


        if (slow!=quick){
            ListNode left=sortList(head);
            ListNode right=sortList(middle);
            return merge(left,right);
        }
        else{
            return slow;
        }
    }



    public ListNode merge(ListNode left, ListNode right){

        final ListNode node=new ListNode();

        ListNode p=left;
        ListNode q=right;

        ListNode nextp=null;
        ListNode nextq=null;
        ListNode r=node;
        while (p!=null && q!=null){
            if (p.val<q.val){
                r.next=p;nextp=p.next;p=nextp;
            }
            else{
                r.next=q;nextq=q.next;q=nextq;
            }
            r=r.next;
        }

        if (p!=null){
            r.next=p;
        }

        if (q!=null){
            r.next=q;
        }

        return node.next;
    }
    public static void main(String[] args){

        ListNode a1=new ListNode(1);
//        ListNode a2=new ListNode(1);
//        ListNode a3=new ListNode(1);
//        a1.nextMap=a2;
//        a2.nextMap=a3;

//        ListNode a4=new ListNode(10);
//        ListNode a5=new ListNode(18);
//        a4.nextMap=a5;
//
//        a3.nextMap=a4;
//







        Solution148 solution148=new Solution148();
        ListNode total=solution148.sortList(a1);
        System.out.println(total);
    }
}
