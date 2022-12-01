package leetcode.p2022q4;

import common.ListNode;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/28
 * @time 9:15 PM
 */
public class Solution2487 {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode        p     = head;
        while (p != null) {
            ListNode nextP = p.next;
            while (!stack.isEmpty() && stack.peek().val < p.val) {
                stack.pop();
            }
            stack.push(p);
            p = nextP;
        }

        Stack<ListNode> revStack = new Stack<>();
        while (!stack.isEmpty()) {
            revStack.push(stack.pop());
        }

        ListNode newHead = null;
        ListNode curr    = null;

        while (!revStack.isEmpty()) {
            ListNode node = revStack.pop();
            if (newHead == null) {
                newHead = node;
            }
            if (curr != null) {
                curr.next = node;
            }
            curr = node;
        }
        return newHead;
    }

    public static void main(String[] args) {
        Solution2487 solution2487 = new Solution2487();
        ListNode     head         = solution2487.removeNodes(ListNode.ofArray("[5,2,13,3,8]"));
        System.out.println(head);
    }
}
