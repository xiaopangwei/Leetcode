package leetcode.p2021m09;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/2
 * @time 9:52 AM
 */
public class Solution22 {
    public ListNode getKthFromEnd(ListNode head, int k) {

        if (head==null){return null;}

        ListNode p=head;
        ListNode q=head;

        int count=0;
        while (count<k){
            q=q.next;
            count++;
        }

        while (q!=null){
            q=q.next;
            p=p.next;
        }

        return p;
    }

    public static void main(String[] args){
        Solution22 solution22=new Solution22();
        ListNode head=ListNode.ofArray("[1,2,3,4,5]");
        System.out.println(solution22.getKthFromEnd(head,3).val);
    }
}
