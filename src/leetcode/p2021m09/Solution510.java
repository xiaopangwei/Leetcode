package leetcode.p2021m09;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/15
 * @time 9:08 PM
 */
public class Solution510 {
    static class Node {
        public int  val;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node inorderSuccessor(Node node) {

        if (node == null) {
            return null;
        }
        //右孩子，向左走到尽头
        Node parent = node.parent;

        if (node.right != null) {
            Node p = node.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        } else {
            if (parent==null){
                return null;
            }
            else if (parent.left == node) {
                return parent;
            } else {

                Node p = node;

                while (p != null && p.parent != null && p.parent.right == p) {
                    p = p.parent;
                }
                if (p == null) {
                    return null;
                } else {
                    return p.parent;
                }

            }
        }
    }

    public static void main(String[] args) {
        Solution510 solution510 = new Solution510();
        Node        node1       = new Node(0);
//        Node        node2       = new Node(2);
//        Node        node3       = new Node(3);
//        node2.left = node1;
//        node2.right = node3;
//
//        node2.parent = null;
//
//        node1.parent = node2;
//        node3.parent = node2;
        Node node = solution510.inorderSuccessor(node1);
        if (node == null) {
            System.out.println("NULL");
        } else {
            System.out.println(node.val);
        }
    }
}
