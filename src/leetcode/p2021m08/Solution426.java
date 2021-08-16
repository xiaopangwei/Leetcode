package leetcode.p2021m08;


import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/14
 * @time 2:37 PM
 */
public class Solution426 {
    static class Node {
        public int  val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }

        public static Node ofArray(String str) {
            String   sub   = str.substring(1, str.length() - 1);
            String[] array = sub.split(",");
            String   first = array[0].trim();
            if (first.equalsIgnoreCase("null")) {
                return null;
            }
            Node root = create(array, 0);
            return root;
        }

        private static Node create(String[] array, int start) {
            if (start < 0 || start >= array.length) {
                return null;
            }
            if ("null".equalsIgnoreCase(array[start])) {
                return null;
            }
            Node left  = create(array, 2 * start + 1);
            Node right = create(array, 2 * start + 2);

            Node root = new Node(Integer.parseInt(array[start]));

            root.left = left;
            root.right = right;
            return root;
        }
    }

    public Node treeToDoublyList(Node root) {

        if (root == null) {
            return null;
        }
        Node last = traverseByInOrder(root);
        Node p    = last;
        while (p.left != null) {
            Node q = p.left;
            q.right = p;
            p = q;
        }

        p.left = last;
        last.right = p;
        return p;
    }

    public Node traverseByInOrder(Node root) {
        Node        prev  = null;
        Stack<Node> stack = new Stack<>();
        Node        p     = root;
        Node        temp  = null;
        while (true) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (stack.isEmpty()) {
                break;
            } else {
                temp = stack.pop();
                Node q = temp.right;
                temp.left = prev;
                prev = temp;

                p = q;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        Solution426 solution426 = new Solution426();
        Node        root        = Node.ofArray("[1]");
        Node        head        = solution426.treeToDoublyList(root);

        Node temp = head;
        while (temp != null) {
            System.out.println(temp.val + " " + temp.left.val + " " + temp.right.val + " ");
            temp = temp.right;
            if (temp == head) {
                break;
            }
        }
    }
}
