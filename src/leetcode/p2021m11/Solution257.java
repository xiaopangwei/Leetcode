package leetcode.p2021m11;

import common.TreeNode;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/23
 * @time 10:30 PM
 */
public class Solution257 {
    Map<TreeNode, List<String>> cached = new HashMap<>();

    public List<String> binaryTreePaths(TreeNode root) {
        return dfs(root);

    }

    private List<String> dfs(TreeNode root) {
        if (cached.containsKey(root)) {
            return cached.get(root);
        }
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.left == null && root.right == null) {
            return Arrays.asList(String.valueOf(root.val));
        }
        List<String> leftList  = dfs(root.left);
        List<String> rightList = dfs(root.right);


        List<String> ans = new ArrayList<>();
        for (String item : leftList) {
            ans.add(root.val + "->" + item);
        }


        for (String item : rightList) {
            ans.add(root.val + "->" + item);
        }


        cached.put(root, ans);
        return ans;
    }

    public static void main(String[] args) {
        Solution257 solution257 = new Solution257();
        TreeNode    node        = TreeNode.ofArray("[1]");
        System.out.println(solution257.binaryTreePaths(node));
    }
}
