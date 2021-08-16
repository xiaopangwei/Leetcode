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
public class Solution19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next==null){
            return null;
        }
        ListNode slow=head,quick=head;

        while (n-- >0){
            quick=quick.next;
        }


        while (quick!=null && quick.next!=null){
            slow=slow.next;
            quick=quick.next;
        }

        if (quick==null){
            head=head.next;
        }
        else {
            if (slow != null && slow.next != null) {
                slow.next = slow.next.next;
            } else {
                slow.next = null;
            }
        }
        return head;
    }
    public static void main(String[] args){
        Solution19                   solution19 =new Solution19();
        ListNode a1         =new ListNode(1);
        ListNode a2=new ListNode(2);
        ListNode a3=new ListNode(5);
        a1.next=a2;
        a2.next=a3;

        ListNode head1=solution19.removeNthFromEnd(a1,3);

        System.out.println(head1);

    }
}
