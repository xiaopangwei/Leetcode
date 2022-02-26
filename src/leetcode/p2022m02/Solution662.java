package leetcode.p2022m02;

import common.TreeNode;
import common.TreeNodeBuilder;

import java.util.LinkedList;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/23
 * @time 10:44 PM
 */
public class Solution662 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        root.val = 1;
        int maxVal = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            maxVal = Math.max(maxVal, queue.peekLast().val - queue.peekFirst().val + 1);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    node.left.val = node.val * 2;
                    queue.add(node.left);
                }
                if (node.right != null) {
                    node.right.val = node.val * 2 + 1;
                    queue.add(node.right);
                }
            }

        }
        return maxVal;
    }

    public static void main(String[] args) {
        Solution662 solution662 = new Solution662();
        int         ans         = solution662.widthOfBinaryTree(TreeNodeBuilder.build("[1,3,2,5,3,null,9]"));
        System.out.println(ans);
    }
}
