package leetcode.p2022m02;

import common.TreeNode;
import common.TreeNodeBuilder;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/13
 * @time 8:28 PM
 */
public class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        TreeNode p = root;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
    }

    public int next() {
        TreeNode temp = stack.pop();
        TreeNode p    = temp.right;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
        return temp.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeBuilder.build("[7,3,15,null,null,9,20]");
        BSTIterator bstIterator=new BSTIterator(root);
        for (int i=0;i<5;i++){
            int val=bstIterator.next();
            System.out.println(val+" "+bstIterator.hasNext());
        }
        System.out.println(bstIterator.hasNext());
    }
}
