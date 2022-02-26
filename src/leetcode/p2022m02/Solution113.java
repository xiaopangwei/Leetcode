package leetcode.p2022m02;

import common.TreeNode;
import common.TreeNodeBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/23
 * @time 9:33 PM
 */
public class Solution113 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, 0, targetSum, new ArrayList<>());
        return ans;
    }

    private void dfs(TreeNode root, int currentSum, final int targetSum, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (currentSum + root.val == targetSum) {
                List<Integer> data = new ArrayList<>();
                for (int item : list) {
                    data.add(item);
                }
                data.add(root.val);
                ans.add(data);
                return;
            }
        }

        list.add(root.val);
        dfs(root.left, currentSum + root.val, targetSum, list);
        dfs(root.right, currentSum + root.val, targetSum, list);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        Solution113         solution113 = new Solution113();
        List<List<Integer>> ans         = solution113.pathSum(TreeNodeBuilder.build("[5,4,8,11,null,13,4,7,2,null,null,5,1]"), 22);
        System.out.println(ans);


    }
}
