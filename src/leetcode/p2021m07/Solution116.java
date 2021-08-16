package leetcode.p2021m07;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/31
 * @time 3:59 PM
 */
public class Solution116 {

    static  class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

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

        Node p=root;

        while (p!=null) {
            Node nextP=p.left;
            while (p != null) {
                if (p.left!=null) {
                    p.left.next = p.right;
                }

                if (p.right!=null && p.next!=null){
                    p.right.next=p.next.left;
                }
                p = p.next;
            }

            p = nextP;
        }

        return root;

    }

    public static void main(String[] args){
        Solution116 solution116=new Solution116();
        Node node2=new Node(2,new Node(4),new Node(5),null);
        Node node3=new Node(3,new Node(6),new Node(7),null);
        Node node1=new Node(1,node2,node3,null);
        Node root=solution116.connect(node1);
        System.out.println(root);
    }

}
