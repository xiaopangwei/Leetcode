package leetcode.p2021m07;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/24
 * @time 1:44 PM
 */
public class Solution142 {

    public ListNode detectCycle(ListNode head) {
        if (head==null || head.next==null){
            return null;
        }
        ListNode slow=head;
        ListNode fast=head.next;

        while (slow!=fast){
            if (fast==null || fast.next==null){
                return null;
            }
            slow=slow.next;
            fast=fast.next.next;
        }

        slow=slow.next;
        ListNode temp=head;
        while (temp!=slow){
            temp=temp.next;
            slow=slow.next;
        }
        return temp;
    }

    public static void main(String[] args){
        Solution142 solution142=new Solution142();
        ListNode head=new ListNode(1);
//        head.nextMap=head;
        ListNode second=new ListNode(2);
//        ListNode third=new ListNode(3);
        head.next=second;
//        second.nextMap=third;
//        third.nextMap=second;


        ListNode temp=solution142.detectCycle(head);
        if(temp!=null){
            System.out.println(temp.val);
        }else{
            System.out.println("NULL");
        }
    }
}
