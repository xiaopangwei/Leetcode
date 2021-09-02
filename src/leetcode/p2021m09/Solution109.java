package leetcode.p2021m09;

import common.ListNode;
import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/1
 * @time 1:12 PM
 */
public class Solution109 {
    public TreeNode sortedListToBST(ListNode head) {


        if (head == null) {
            return null;
        }
        else if (head.next==null){
            return new TreeNode(head.val);
        }

        ListNode middle = findMiddle(head);


        if (middle != null) {
            TreeNode root = new TreeNode(middle.val);
            ListNode q=head;
            while (q.next!=middle){
                q=q.next;
            }
            q.next=null;
//            System.out.println("middle value:" + middle.val);
            ListNode nextMiddle = middle.next;
            root.left = sortedListToBST(head);
            root.right = sortedListToBST(nextMiddle);
            return root;
        }


        return null;

    }

    private void print(ListNode head){
        ListNode p=head;
        while (p!=null){
            System.out.print(p.val+" ");
            p=p.next;
        }
        System.out.println("END");
    }

    private ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            if (fast == null || fast.next == null) {
                return slow;
            }
//            prev=slow;
            slow = slow.next;
            fast = fast.next.next;
        }
    }

    public static void main(String[] args) {
        Solution109 solution109 = new Solution109();
        ListNode    head        = ListNode.ofArray("[-10,-3,9]");
        TreeNode root = solution109.sortedListToBST(head);
        System.out.println(root);
    }
}
