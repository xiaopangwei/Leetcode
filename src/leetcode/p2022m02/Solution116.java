package leetcode.p2022m02;


/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/18
 * @time 10:54 PM
 */
public class Solution116 {

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

    ;

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node left  = root.left;
        Node right = root.right;

        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }

        connect(root.left);
        connect(root.right);
        return root;
    }

    public static void main(String[] args) {

        Node root  = new Node(1);
        Node left  = new Node(2);
        Node right = new Node(3);

        root.left = left;
        root.right = right;
        Solution116 solution116 = new Solution116();
        solution116.connect(root);
        System.out.println(root);
    }
}
