package leetcode.p2021m09;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/23
 * @time 9:21 PM
 */
public class Solution369 {
    public ListNode plusOne(ListNode head) {

        ListNode newHead = reverse(head);
        ListNode p     = newHead;
        int      carry = 1;
        ListNode prev  = null;
        while (p != null) {
            int sum = p.val + carry;
            int a   = sum % 10;
            carry = sum / 10;
            p.val = a;
            prev = p;
            p = p.next;
        }

        while (carry!=0){
            int a=carry%10;
            int b=carry/10;
            ListNode temp=new ListNode(a);
            prev.next=temp;
            prev=prev.next;
            carry=b;
        }

        return reverse(newHead);

    }

    private ListNode reverse(ListNode head) {
        ListNode p    = head;
        ListNode prev = null;

        while (p != null) {
            ListNode nextP = p.next;
            p.next = prev;
            prev = p;
            p = nextP;
        }
        return prev;
    }

    public static void main(String[] args){
        Solution369 solution369=new Solution369();
        ListNode head=solution369.plusOne(ListNode.ofArray("[9,9,9,9]"));
        ListNode p=head;

        while (p!=null){
            System.out.println(p.val);
            p=p.next;
        }

    }
}
