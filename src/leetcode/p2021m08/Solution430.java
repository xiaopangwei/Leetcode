package leetcode.p2021m08;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/15
 * @time 10:21 PM
 */

public class Solution430 {
    static class Node {
        public int  val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }
    }


    public Node flatten(Node head) {
        Node newNode = dfs(head);
        Node p       = newNode;
        while (p != null) {
            p.child = null;
            Node q = p.next;
            if (q == null) {
                break;
            }
            q.prev = p;
            p = q;
        }
        return newNode;
    }

    public Node dfs(Node head) {
        if (head == null) {
            return null;
        }
        Node p = head;

        Node nextP = p.next;

        if (p.child != null) {
            Node newHead = dfs(p.child);
            p.next = newHead;

            Node q = newHead;
            while (q.next != null) {
                q = q.next;
            }

            q.next = nextP;
        } else {
            Node newHead = dfs(head.next);
            p.next = newHead;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution430 solution430 = new Solution430();
        Node        node1       = new Node(1);
        Node        node2       = new Node(2);
        Node        node3       = new Node(3);
        Node        node4       = new Node(4);
        Node        node5       = new Node(5);
        Node        node6       = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;


        node2.prev = node1;
        node3.prev = node2;
        node4.prev = node3;
        node5.prev = node4;
        node6.prev = node5;

        Node node7  = new Node(7);
        Node node8  = new Node(8);
        Node node9  = new Node(9);
        Node node10 = new Node(10);
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;


        node8.prev = node7;
        node9.prev = node8;
        node10.prev = node9;


        Node node11 = new Node(11);
        Node node12 = new Node(12);
        node11.next = node12;
        node12.prev = node11;


        node3.child = node7;
        node8.child = node11;


        Node newHead = solution430.flatten(node1);
        Node p       = newHead;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }

        System.out.println("------------------");

        p = newHead;
        while (p.next != null) {
//            System.out.println(p.val);
            p = p.next;
        }

        Node q = p;
        while (q != null) {
            System.out.println(q.val);
            q = q.prev;
        }
    }
}
