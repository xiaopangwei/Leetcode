package leetcode.springfestival.pm20220205;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/5
 * @time 10:39 AM
 */

public class SolutionJZOffer36 {
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
    }


    Node head, pre = null;

    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        Node right = root.right;
        dfs(root.left);
        if (head == null) {
            head = root;
        } else {
            root.left = pre;
            pre.right = root;
        }
        pre = root;
        dfs(right);
    }


    public Node treeToDoublyList(Node root) {
        dfs(root);
        if (head != null) {
            head.left = pre;
            pre.right = head;
        }
        return head;
    }

    public static void main(String[] args) {
        SolutionJZOffer36 solutionJZOffer36 = new SolutionJZOffer36();
        Node              node2             = new Node(2, new Node(1), new Node(3));
        Node              root              = new Node(4, node2, new Node(5));
        Node              res               = solutionJZOffer36.treeToDoublyList(root);
        System.out.println(res);


    }
}
