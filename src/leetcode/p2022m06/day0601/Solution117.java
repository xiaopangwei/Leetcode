package leetcode.p2022m06.day0601;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/7
 * @time 11:09 PM
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

        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = next(root.next);
            }
        }

        if (root.right != null) {
            root.right.next = next(root.next);
        }

        root.right = connect(root.right);
        root.left = connect(root.left);

        return root;
    }

    private Node next(Node parent) {
        if (parent == null) {
            return null;
        }
        if (parent.left != null) {
            return parent.left;
        }
        if (parent.right != null) {
            return parent.right;
        }
        return next(parent.next);
    }
}
