package leetcode.p2022m03;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/4
 * @time 3:14 PM
 */
public class Solution637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int  size = queue.size();
            long sum  = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum = sum + (long) node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

            }
            ans.add(sum * 1.0 / size);
        }
        return ans;
    }

}
