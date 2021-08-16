package leetcode.p2021m07;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/31
 * @time 11:08 AM
 */
public class Solution234 {
    public boolean isPalindrome(ListNode head) {

        if (head==null||head.next==null){
            return true;
        }

        ListNode mid=null;

        ListNode slow=head;
        ListNode fast=head;

        while (true){
            slow=slow.next;
            fast=fast.next.next;
            if (fast==null||fast.next==null){
                mid=slow;
                break;
            }
        }

        ListNode newHead=reverse(mid);

        ListNode p1=head;
        ListNode p2=newHead;
        while (p1!=null && p2!=null){
            if (p1.val!=p2.val){
                return false;
            }
            p1=p1.next;
            p2=p2.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head){
        ListNode temp=head;
        ListNode prev=null;
        while (true){
            ListNode nextNode=temp.next;
            temp.next=prev;
            prev=temp;
            temp=nextNode;
            if (temp==null){
                return prev;
            }
        }
    }

    public static void main(String[] args){
        Solution234 solution234=new Solution234();
        ListNode head=ListNode.ofArray("[1,2,2,1]");
        System.out.println(solution234.isPalindrome(head));
    }
}
