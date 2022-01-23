package leetcode.p2022m01;

import common.TreeNode;
import common.TreeNodeBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/21
 * @time 11:09 PM
 */
public class TraverseBinTree {

    public List<Integer> preOrder(TreeNode root) {
        List<Integer>   ans   = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                ans.add(root.val);
                stack.push(root);
                root = root.left;
            }

            TreeNode temp = stack.pop();
            root = temp.right;
        }
        return ans;
    }

    public List<Integer> inOrder(TreeNode root) {
        List<Integer>   ans   = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode temp = stack.pop();
            ans.add(temp.val);
            root = temp.right;
        }
        return ans;
    }

    public List<Integer> postOrder(TreeNode root) {
        List<Integer>   ans   = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                ans.add(root.val);
                stack.push(root);
                root = root.right;
            }

            TreeNode temp = stack.pop();
            root = temp.left;
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        //      1
        //  2        3
        // 4  5     6  7
        TreeNode root = TreeNodeBuilder.build("[1,2,3,4,5,6,7]");

        TraverseBinTree binTreeTrans = new TraverseBinTree();
        System.out.println(binTreeTrans.preOrder(root));
        System.out.println(binTreeTrans.postOrder(root));
        System.out.println(binTreeTrans.inOrder(root));
    }
}
