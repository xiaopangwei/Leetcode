package leetcode.p2022m03;

import common.TreeNode;
import common.TreeNodeBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/18
 * @time 8:44 PM
 */
public class Solution437 {
    int                   ans  = 0;
    Map<Integer, Integer> freq = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {

        freq.put(0, 1);
        dfs(root, 0, targetSum);
        return ans;

    }
    private void dfs(TreeNode root, int currentSum, final int target) {
        if (root == null) {
            return;
        }
        int s = currentSum + root.val;
        freq.put(s, freq.getOrDefault(s, 0) + 1);
        if (freq.containsKey(s - target)) {
            ans += freq.get(s - target);
        }
        dfs(root.left, s, target);
        dfs(root.right, s, target);
        freq.put(s, freq.getOrDefault(s, 0) - 1);
    }

    public static void main(String[] args) {
        TreeNode    root        = TreeNodeBuilder.build("[5,4,8,11,null,13,4,7,2,null,null,5,1]");
        Solution437 solution437 = new Solution437();
        int         ans         = solution437.pathSum(root, 22);
        System.out.println(ans);
    }
}
