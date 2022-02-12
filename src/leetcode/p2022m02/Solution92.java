package leetcode.p2022m02;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/12
 * @time 4:56 PM
 */
public class Solution92 {
    //    输入：head = [1,2,3,4,5], left = 2, right = 4
//    输出：[1,4,3,2,5]
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode p               = head;
        int      count           = 1;
        ListNode leftNode        = null;
        ListNode prevOfLeftNode  = null;
        ListNode rightNode       = null;
        ListNode nextOfRightNode = null;
        ListNode prev            = null;
        while (p != null) {
            if (count == left) {
                prevOfLeftNode = prev;
                leftNode = p;
            }
            if (count == right) {
                rightNode = p;
                break;
            }
            prev = p;
            p = p.next;
            count++;
        }

        if (rightNode != null) {
            nextOfRightNode = rightNode.next;
            rightNode.next = null;
        }

        ListNode newHead = reverse(leftNode);
        if (prevOfLeftNode != null) {
            prevOfLeftNode.next = newHead;
        }
        if (leftNode != null) {
            leftNode.next = nextOfRightNode;
        }

        if (prevOfLeftNode==null){
            return newHead;
        }
        return head;

    }


    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode p    = head;
        while (p != null) {
            ListNode nextP = p.next;
            p.next = prev;
            prev = p;
            p = nextP;
        }
        return prev;
    }

    public static void main(String[] args) {
        Solution92 solution92 = new Solution92();
        ListNode   temp       = solution92.reverseBetween(ListNode.ofArray("[1,2,3,4,5]"), 1, 1);
        System.out.println(temp);
    }
}
