package leetcode.p2021m09;


/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/12
 * @time 10:41 PM
 */
public class Solution708 {
    static class Node {
        public int  val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {

        if (head == null) {
            Node newHead = new Node(insertVal);
            newHead.next = newHead;
            return newHead;
        }

        Node p    = head;
        Node last = null;
        while (p.next != head) {
            p = p.next;
        }

        last = p;
        last.next = null;

        p = head;

        boolean flag = false;
        while (p != null) {
            if (p.next != null) {
                if (p.next.val >= p.val) {
                    if (p.val <= insertVal && insertVal <= p.next.val) {
                        Node node = new Node(insertVal);
                        node.next = p.next;
                        p.next = node;
                        last.next = head;
                        flag = true;
                        break;
                    }
                } else {
                    if (insertVal <= p.next.val || p.val <= insertVal) {
                        Node node = new Node(insertVal);
                        node.next = p.next;
                        p.next = node;
                        last.next = head;
                        flag = true;
                        break;
                    }
                }
            } else {
                if (p.val < insertVal) {
                    Node node = new Node(insertVal);
                    last.next = node;
                    last = node;
                    last.next = head;
                    flag = true;
                    break;
                }
            }
            p = p.next;
        }

        if (!flag) {

            Node newNode = new Node(insertVal);
            last.next = newNode;
            newNode.next = head;

        }
        return head;
    }

    public static void main(String[] args) {
        Solution708 solution708 = new Solution708();
//        Node        node3       = new Node(3);
//        Node        node4       = new Node(4);
//        Node        node1       = new Node(1);
//        Node        head        = node3;
//        node3.next = node4;
//        node4.next = node1;
//        node1.next = node3;

        Node node1 = new Node(1);
        Node node3 = new Node(3);
        Node node5 = new Node(5);

        node3.next = node5;
        node5.next = node1;
        node1.next = node3;
        Node head = node3;


        Node newHead = solution708.insert(head, 6);
        System.out.println(newHead);

    }
}
