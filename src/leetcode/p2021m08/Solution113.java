package leetcode.p2021m08;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/20
 * @time 2:38 PM
 */
public class Solution113 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, 0, targetSum, new ArrayList<>());
        return ans;
    }

    public void dfs(TreeNode root, int currentSum, final int targetSum, List<Integer> temp) {

        if (root == null) {
            return;
        }

//        System.out.println(root.val+" "+currentSum);
        if (root.left == null && root.right == null) {
            if (currentSum + root.val == targetSum) {
                List<Integer> list = new ArrayList<>();
                for (int item : temp) {
                    list.add(item);
                }
                list.add(root.val);
                ans.add(list);
            }
        }

        temp.add(root.val);
        dfs(root.left, currentSum + root.val, targetSum, temp);

        dfs(root.right, currentSum + root.val, targetSum, temp);
        temp.remove(temp.size() - 1);

    }

    public static void main(String[] args) {
        Solution113         solution113 = new Solution113();
        TreeNode root=TreeNode.ofArray("[1,2]");
        List<List<Integer>> list        = solution113.pathSum(root, 0);
        System.out.println(list);
    }
}
