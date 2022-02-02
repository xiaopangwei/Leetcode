package leetcode.springfestival.sf20220130;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/30
 * @time 3:44 PM
 */
public class Solution958 {
    public boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp == null) {
                while (!queue.isEmpty()) {
                    if (queue.poll() != null) {
                        return false;
                    }
                }
            } else {
                queue.add(temp.left);
                queue.add(temp.right);
            }
        }
        return true;
    }
}
