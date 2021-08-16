package leetcode.p20210630;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/30
 * @time 9:53 AM
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

    public static void main(String[] args){

    }


    public Node connect(Node root) {

        Node p=root;
        Stack<Node> stack=new Stack<>();
        while (!stack.isEmpty()){
            while (p!=null){
                if (p.left!=null && p.right!=null){
                    p.left.next=p.right;
                }
                stack.push(p);
                p=p.left;
            }

            Node temp=stack.pop();
            System.out.println(temp.val);
            p=temp.right;
        }


        return root;

    }




}
