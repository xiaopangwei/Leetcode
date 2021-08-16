package leetcode.p2021m08;

import example.TreeNode;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/11
 * @time 11:15 AM
 */
public class Solution99 {
    public void recoverTree(TreeNode root) {

        inorder(root);
    }

    private void inorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode        p     = root;
        TreeNode        a     = null, b = null;
        TreeNode        prev  = new TreeNode(Integer.MIN_VALUE);
        while (true) {
            if (p == null) {
                break;
            }
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            while (!stack.isEmpty()) {
                TreeNode temp = stack.pop();
                System.out.println(temp.val+" "+ prev.val);
                if (a == null && prev.val > temp.val) {
                    a = prev;
                }
                if (a != null && prev.val > temp.val) {
                    b = temp;
                }
                prev = temp;
//                System.out.println(temp.val);
                if (temp.right != null) {
                    p = temp.right;
                    break;
                }
            }
        }

        int temp=a.val;
        a.val=b.val;
        b.val=temp;
    }

    public static void main(String[] args) {
        Solution99 solution99 = new Solution99();
        TreeNode   root       = TreeNode.ofArray("[3,4,1,null,2,null,null]");
        solution99.inorder(root);
    }
}
