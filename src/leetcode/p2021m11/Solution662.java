package leetcode.p2021m11;

import common.TreeNode;

import java.util.LinkedList;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/13
 * @time 3:30 PM
 */
public class Solution662 {
    public int widthOfBinaryTree(TreeNode root) {

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        root.val=0;

        int maxWidth = -1;
        while (!queue.isEmpty()) {

            int size = queue.size();


            int width=queue.getLast().val-queue.getFirst().val+1;
            maxWidth=Math.max(maxWidth,width);

            for (int i=0;i<size;i++) {
                TreeNode temp = queue.removeFirst();


                if (temp.left != null) {
                    temp.left.val = temp.val * 2 + 1;
                    queue.add(temp.left);
                }

                if (temp.right != null) {
                    temp.right.val = temp.val * 2 + 2;
                    queue.add(temp.right);
                }
            }

        }

        return maxWidth;

    }


}
