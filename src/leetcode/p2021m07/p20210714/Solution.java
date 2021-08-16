package leetcode.p2021m07.p20210714;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/14
 * @time 7:41 PM
 */
public class Solution {
    static class Node {
        public int  value;
        public Node next;

        public Node(int val) {
            this.value = val;
        }

    }

    public Node getCyclicNode(Node head) {

        List<Node> sets = new ArrayList<>();
        Node       p    = head;
        while (p != null) {
            if (!sets.contains(p)) {
                sets.add(p);
            } else {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node     head     = new Node(1);
        Node     second   = new Node(2);
        head.next = second;
//        second.nextMap=head;

        Node temp = solution.getCyclicNode(head);
        System.out.println(temp);
    }
}
