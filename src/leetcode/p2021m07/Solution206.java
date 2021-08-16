package leetcode.p2021m07;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/30
 * @time 6:12 PM
 */
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode prev=null;
        ListNode current=head;

        while (true){
            if (current==null){
                break;
            }else{
                ListNode nextNode=current.next;
                current.next=prev;
                prev=current;
                current=nextNode;
            }

        }
        return prev;
    }
    public static void main(String[] args){
        Solution206 solution206=new Solution206();
        ListNode head=ListNode.ofArray("[1]");
        ListNode node=solution206.reverseList(head);
        System.out.println(node);
    }
}
