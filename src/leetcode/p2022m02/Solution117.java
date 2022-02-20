package leetcode.p2022m02;


/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/18
 * @time 10:54 PM
 */
public class Solution117 {

    static class Node {
        public int  val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        }

        if (root.left != null && root.right == null) {
            root.left.next = nextNode(root.next);
        }

        if (root.left == null && root.right != null) {
            root.right.next = nextNode(root.next);
        }

        connect(root.right);
        connect(root.left);
        return root;
    }

    private Node nextNode(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            return root.left;
        }
        if (root.right != null) {
            return root.right;
        }
        if (root.next != null) {
            return nextNode(root.next);
        }
        return null;
    }

    public static void main(String[] args) {

        Node root  = new Node(1);
        Node left  = new Node(2);
        Node right = new Node(3);

        root.left = left;
        root.right = right;
        Solution117 solution116 = new Solution117();
        solution116.connect(root);
        System.out.println(root);
    }
}
