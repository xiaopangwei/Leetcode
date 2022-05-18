package leetcode.p2022m05.day0508;

import common.TreeNode;

import java.util.LinkedList;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/8
 * @time 8:09 PM
 */
public class Solution662 {
    public int widthOfBinaryTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        root.val = 1;
        queue.add(root);

        int maxWidth = 0;


        while (!queue.isEmpty()) {
            int size = queue.size();

            maxWidth = Math.max(maxWidth, queue.peekLast().val - queue.peekFirst().val + 1);
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();

                if (temp.left != null) {
                    temp.left.val = 2 * temp.val;
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    temp.right.val = 2 * temp.val + 1;
                    queue.add(temp.right);
                }

            }
        }
        return maxWidth;
    }
}
