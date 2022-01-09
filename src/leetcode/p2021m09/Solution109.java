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
        if (head.next==null){
            return new TreeNode(head.val);
        }

        ListNode[] arr = findMiddle(head);

        ListNode prev   = arr[0];
        ListNode middle = arr[1];

        TreeNode root = new TreeNode(middle.val);

        ListNode nextP = middle.next;
        if (prev != null) {
            prev.next = null;
        }
        root.left = sortedListToBST(head);

        root.right = sortedListToBST(nextP);


        return root;
    }


    public ListNode[] findMiddle(ListNode head) {
        ListNode   slow = head;
        ListNode   fast = head;
        ListNode   prev = null;
        ListNode[] res  = new ListNode[2];

        while (fast != null) {
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                break;
            }

            prev = slow;
            slow = slow.next;
        }

        res[0] = prev;
        res[1] = slow;
        return res;
    }

    public static void main(String[] args) {
        Solution109 solution109 = new Solution109();
        ListNode    temp        = ListNode.ofArray("[-10, -3, 0, 5, 9]");
        TreeNode    root        = solution109.sortedListToBST(temp);
//        ListNode    head        = ListNode.ofArray("[-10,-3,9]");
//        TreeNode    root        = solution109.sortedListToBST(head);
        System.out.println(root);
    }
}
